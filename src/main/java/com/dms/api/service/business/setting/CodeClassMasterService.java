package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.CodeMasterDto;
import com.dms.entitiy.CmCodeClassMEntity;
import com.dms.repository.setting.CodeClassMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CodeClassMasterService {

  @Autowired
  private CodeClassMasterRepository codeClassMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<Response> getCodeClassMasters(CodeMasterDto codeMasterDto) {
    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData.put("dataList", codeClassMasterRepository.selectCodeClassMasterList(codeMasterDto));
    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> saveClassCodeMasters(CodeMasterDto codeMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    codeMasterDto.setCreateUserId(authorizedUser.getUserId());
    CmCodeClassMEntity cmCodeClassMEntity = modelMapper
        .map(codeMasterDto, CmCodeClassMEntity.class);
    codeClassMasterRepository.merge(cmCodeClassMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateClassCodeMasters(CodeMasterDto codeMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    codeMasterDto.setUpdateUserId(authorizedUser.getUserId());
    CmCodeClassMEntity cmCodeClassMEntity = modelMapper
        .map(codeMasterDto, CmCodeClassMEntity.class);
    codeClassMasterRepository.merge(cmCodeClassMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
