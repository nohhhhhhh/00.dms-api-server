package com.dms.api.service.setting.impl;

import com.dms.api.dto.ResponseDto;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import com.dms.api.repository.setting.UserMasterRepository;
import com.dms.api.service.setting.UserMasterService;
import java.time.LocalDateTime;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMasterServiceImpl implements UserMasterService {

  @Autowired
  private UserMasterRepository userMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public int status = 500;
  public String message;
  public List<?> resultList;

  public List<UserMaster> getUserMaster(UserMasterDto userMasterDto) {
    return userMasterRepository.selectListByOption(userMasterDto);
  }


  public ResponseEntity<ResponseDto> getUserMasters(UserMasterDto userMasterDto) throws Exception {

    try {
      status = 200;
      message = "HttpStatus.OK";
      resultList = userMasterRepository.selectListByOption(userMasterDto);
    } catch (Exception e) {
      message = "HttpStatus.INTERNAL_SERVER_ERROR";
    }

    ResponseDto responseDto = new ResponseDto(status, LocalDateTime.now(), message, resultList);

    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  public ResponseEntity<ResponseDto> saveUserMaster(UserMasterDto userMasterDto) throws Exception {

    try {
      status = 200;
      message = "HttpStatus.OK";

      UserMaster userMaster = modelMapper.map(userMasterDto, UserMaster.class);
      userMasterRepository.save(userMaster);

    } catch (Exception e) {
      status = 200;
      message = e.getMessage();
    }

    ResponseDto responseDto = new ResponseDto(status, LocalDateTime.now(), message, resultList);

    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

}


