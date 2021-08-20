package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.CodeMasterDto;
import com.dms.entitiy.CmCodeMEntity;
import com.dms.repository.setting.CodeMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CodeMasterService {

  @Autowired
  private CodeMasterRepository codeMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<Response> getCodeMasters(CodeMasterDto codeMasterDto) {
    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData.put("dataList", codeMasterRepository.selectCodeMasterList(codeMasterDto));
    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> saveCodeMasters(CodeMasterDto codeMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    codeMasterDto.setCreateUserId(authorizedUser.getUserId());
    CmCodeMEntity cmCodeMEntity = modelMapper.map(codeMasterDto, CmCodeMEntity.class);
    codeMasterRepository.merge(cmCodeMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateCodeMasters(CodeMasterDto codeMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    codeMasterDto.setUpdateUserId(authorizedUser.getUserId());
    CmCodeMEntity cmCodeMEntity = modelMapper.map(codeMasterDto, CmCodeMEntity.class);
    codeMasterRepository.merge(cmCodeMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
