package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.ProcessMasterDto;
import com.dms.entitiy.PmProcessMEntity;
import com.dms.repository.setting.ProcessMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProcessMasterService {

  @Autowired
  private ProcessMasterRepository ProcessMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<Response> getProcessMasters(
      ProcessMasterDto processMasterDto) {
    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData
        .put("dataList",
            ProcessMasterRepository.selectProcessMasterList(processMasterDto));
    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> saveProcessMasters(
      ProcessMasterDto processMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    processMasterDto.setCreateUserId(authorizedUser.getUserId());
    PmProcessMEntity PmProcessMEntity = modelMapper
        .map(processMasterDto, PmProcessMEntity.class);
    ProcessMasterRepository.merge(PmProcessMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateProcessMasters(
      ProcessMasterDto processMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    processMasterDto.setUpdateUserId(authorizedUser.getUserId());
    PmProcessMEntity PmProcessMEntity = modelMapper
        .map(processMasterDto, PmProcessMEntity.class);
    ProcessMasterRepository.merge(PmProcessMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
