package com.dms.api.service.common.impl;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import com.dms.api.repository.setting.UserAcessRelationRepository;
import com.dms.api.repository.setting.UserMasterRepository;
import com.dms.api.service.common.AuthenticationService;
import com.dms.config.security.jwt.JwtTokenProvider;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired
  private UserMasterRepository userMasterRepository;

  @Autowired
  private UserAcessRelationRepository userAcessRelationRepository;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public int status = 500;
  public String message;
  public Map<String, Object> resultData;
  public List<?> resultList;


  public ResponseEntity<Response> generateJsonWebToken(UserMasterDto userMasterDto)
      throws Exception {
    String jwt = "";
    HttpHeaders httpHeaders = new HttpHeaders();

    resultData = new HashMap<String, Object>();
    try {
      status = 200;
      message = "HttpStatus.OK";
      userMasterDto.setUseYn("Y");

      List<UserMaster> matchUser = userMasterRepository.selectListByOption(userMasterDto)
          .stream()
          .filter(user -> passwordEncoder.matches(userMasterDto.getUserPwd(), user.getUserPwd()))
          .collect(Collectors.toList());

      if (matchUser.size() > 0) {
        /*UserAccessPlant Check*/
        if (!userAcessRelationRepository.selectListByOption(userMasterDto).isEmpty()) {
          jwt = jwtTokenProvider.createToken(userMasterDto.getUserId());
          resultData.put("JWT", jwt);
        } else {
          throw new Exception("선택하신 구역의 접근권한이 없습니다. 관리자에게 문의해주세요.");
        }

      } else {
        throw new Exception("등록되지 않은 아이디이거나, 잘못된 비밀번호입니다.");
      }


    } catch (Exception e) {
      message = e.getMessage();
    }

    resultData.put("UserToken", jwt);
    Response response = new Response(status, LocalDateTime.now(), message, resultData);
    return new ResponseEntity<Response>(response, httpHeaders, HttpStatus.OK);

  }


}


