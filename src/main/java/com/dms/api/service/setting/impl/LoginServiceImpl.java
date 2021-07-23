package com.dms.api.service.setting.impl;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import com.dms.api.repository.setting.UserAcessRelationRepository;
import com.dms.api.repository.setting.UserMasterRepository;
import com.dms.api.service.setting.LoginService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private UserMasterRepository userMasterRepository;

  @Autowired
  private UserAcessRelationRepository userAcessRelationRepository;

  @Autowired
  HttpSession session;

  public int status = 500;
  public String message;
  public Map<String, Object> resultData;
  public List<?> resultList;


  public ResponseEntity<Response> getUserLoginResult(UserMasterDto userMasterDto)
      throws Exception {

    try {
      status = 200;
      message = "HttpStatus.OK";
      userMasterDto.setUseYn("Y");

      /*UserId, UserPwd Check*/
      List<UserMaster> user = userMasterRepository.selectListByOption(userMasterDto);
      if (user.size() > 0) {
        /*UserAccessPlant Check*/
        if (!userAcessRelationRepository.selectListByOption(userMasterDto).isEmpty()) {
          resultData.put("userInfo", user);
          /*JWT Authority*/
          session.setAttribute("userInfo", userMasterDto);


        } else {
          throw new Exception("선택하신 구역의 접근권한이 없습니다. 관리자에게 문의해주세요.");
        }

      } else {
        throw new Exception("등록되지 않은 아이디이거나, 잘못된 비밀번호입니다.");
      }


    } catch (Exception e) {
      message = e.getMessage();
    }

    Response response = new Response(status, LocalDateTime.now(), message, resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}


