package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.ProcessMasterDto;
import com.dms.entitiy.PmProcessClassMEntity;
import com.dms.repository.setting.ProcessClassMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProcessClassMasterservice {

  @Autowired
  private ProcessClassMasterRepository processClassMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<Response> getProcessClassMasters(
      ProcessMasterDto processMasterDto) {
    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData
        .put("dataList",
            processClassMasterRepository.selectProcessClassMasterList(processMasterDto));
    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> saveProcessClassMasters(
      ProcessMasterDto processMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    processMasterDto.setCreateUserId(authorizedUser.getUserId());
    PmProcessClassMEntity pmProcessClassMEntity = modelMapper
        .map(processMasterDto, PmProcessClassMEntity.class);
    processClassMasterRepository.merge(pmProcessClassMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateProcessClassMasters(
      ProcessMasterDto processMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    processMasterDto.setUpdateUserId(authorizedUser.getUserId());
    PmProcessClassMEntity pmProcessClassMEntity = modelMapper
        .map(processMasterDto, PmProcessClassMEntity.class);
    processClassMasterRepository.merge(pmProcessClassMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
