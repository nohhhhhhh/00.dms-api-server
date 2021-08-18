package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.UserMasterDto;
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
public class UserMasterService {

  @Autowired
  private UserMasterRepository userMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<CmUserMEntity> getUserMaster(UserMasterDto userMasterDto) {
    return userMasterRepository.selectUserListByOption(userMasterDto);
  }


  public ResponseEntity<Response> getUserMasters(UserMasterDto userMasterDto) {

    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData.put("dataList", userMasterRepository.selectUserListByOption(userMasterDto));
    Response response = new Response(resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> saveUserMaster(UserMasterDto userMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();
    userMasterDto.setCreateUserId(authorizedUser.getUserId());
    userMasterDto.setUserPwd(passwordEncoder.encode(userMasterDto.getUserPwd()));
    CmUserMEntity userMaster = modelMapper.map(userMasterDto, CmUserMEntity.class);
    userMasterRepository.save(userMaster);

    Response response = new Response(resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> updateUserMaster(UserMasterDto userMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    userMasterDto.setUpdateUserId(authorizedUser.getUserId());
    userMasterDto.setUserPwd(passwordEncoder.encode(userMasterDto.getUserPwd()));
    CmUserMEntity cmUserMEntity = modelMapper.map(userMasterDto, CmUserMEntity.class);

    userMasterRepository.merge(cmUserMEntity);
    Response response = new Response(resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> deleteUserMaster(UserMasterDto userMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData =  new HashMap<String, Object>();

    userMasterDto.setUserPwd(passwordEncoder.encode(userMasterDto.getUserPwd()));
    userMasterDto.setUseYn("N");
    userMasterDto.setUpdateUserId(authorizedUser.getUserId());
    CmUserMEntity userMaster = modelMapper.map(userMasterDto, CmUserMEntity.class);
    userMasterRepository.merge(userMaster);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


}
