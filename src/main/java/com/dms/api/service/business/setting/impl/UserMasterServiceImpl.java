package com.dms.api.service.business.setting.impl;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.service.business.setting.UserMasterService;
import com.dms.entitiy.CmUserMEntity;
import com.dms.repository.setting.UserMasterRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMasterServiceImpl implements UserMasterService {

  @Autowired
  private UserMasterRepository userMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public int status = 500;
  public String message;
  public Map<String, Object> resultData;
  public List<?> resultList;

  public List<CmUserMEntity> getUserMaster(UserMasterDto userMasterDto) {
    return userMasterRepository.selectUserListByOption(userMasterDto);
  }


  public ResponseEntity<Response> getUserMasters(UserMasterDto userMasterDto) throws Exception {

    try {
      status = 200;
      message = "HttpStatus.OK";
      resultData = new HashMap<String, Object>();
      resultData.put("dataList", userMasterRepository.selectUserListByOption(userMasterDto));
    } catch (Exception e) {
      message = "HttpStatus.INTERNAL_SERVER_ERROR";
    }

    Response response = new Response(status, message, resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> saveUserMaster(UserMasterDto userMasterDto) throws Exception {

    try {
      status = 200;
      message = "HttpStatus.OK";
      resultData = new HashMap<String, Object>();

      userMasterDto.setUserPwd(passwordEncoder.encode(userMasterDto.getUserPwd()));
      CmUserMEntity userMaster = modelMapper.map(userMasterDto, CmUserMEntity.class);
      userMasterRepository.save(userMaster);

    } catch (Exception e) {
      status = 200;
      message = e.getMessage();
    }

    Response response = new Response(status, message, resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> updateUserMaster(UserMasterDto userMasterDto) {

    status = 200;
    message = "HttpStatus.OK";
    resultData = new HashMap<String, Object>();

    userMasterDto.setUserPwd(passwordEncoder.encode(userMasterDto.getUserPwd()));
    CmUserMEntity cmUserMEntity = modelMapper.map(userMasterDto, CmUserMEntity.class);

    if (userMasterDto.getChangePwdDt() == null) {
      throw new NullPointerException("비밀번호가 없습니다");
    }
    userMasterRepository.save(cmUserMEntity);
    Response response = new Response(status, message, resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> deleteUserMaster(UserMasterDto userMasterDto) {

    status = 200;
    message = "HttpStatus.OK";
    resultData = new HashMap<String, Object>();

    userMasterDto.setUserPwd(passwordEncoder.encode(userMasterDto.getUserPwd()));
    userMasterDto.setUseYn("N");
    userMasterDto.setUpdateUserId("noh");
    CmUserMEntity userMaster = modelMapper.map(userMasterDto, CmUserMEntity.class);
    userMasterRepository.save(userMaster);

    //1유져
    //api>~url
    Response response = new Response(status, message, resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}


