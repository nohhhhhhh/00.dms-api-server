package com.dms.api.service.common.impl;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.repository.setting.UserAcessRelationRepository;
import com.dms.repository.setting.UserMasterRepository;
import com.dms.api.service.common.AuthenticationService;
import com.dms.config.security.jwt.JwtTokenProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired
  private UserMasterRepository userMasterRepository;

  @Autowired
  private UserAcessRelationRepository userAcessRelationRepository;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  public int status = 500;
  public String message;
  public Map<String, Object> resultData;
  public List<?> resultList;


  public ResponseEntity<Response> generateJsonWebToken(UserMasterDto userMasterDto) {
    String jwt = "";
    resultData = new HashMap<String, Object>();
    userMasterDto.setUseYn("Y");

    UserMasterDto matchUser = new UserMasterDto();
    matchUser = userMasterRepository.selectUserOneByOption(userMasterDto)
        .orElseThrow(() -> new UsernameNotFoundException((
            "등록되지 않은 아이디이거나, 잘못된 비밀번호입니다.")));

    if (!userAcessRelationRepository.selectUserAcessListByOption(userMasterDto).isEmpty()) {
      jwt = jwtTokenProvider.createToken(userMasterDto.getUserId());
      resultData.put("userId", matchUser.getUserId());
      resultData.put("userNm", matchUser.getUserNm());
    } else {
      throw new NullPointerException("선택하신 구역의 접근권한이 없습니다. 관리자에게 문의해주세요.");
    }

    resultData.put("userToken", jwt);
    Response response = new Response(status, message, resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


}


