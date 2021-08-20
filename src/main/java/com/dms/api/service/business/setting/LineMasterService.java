package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.LineMasterDto;
import com.dms.entitiy.CmLineMEntity;
import com.dms.repository.setting.LineMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LineMasterService {

  @Autowired
  private LineMasterRepository lineMasterRepository;

  @Autowired
  private ModelMapper modelMapper;


  public ResponseEntity<Response> getLineMasters(LineMasterDto lineMasterDto) {

    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData.put("dataList", lineMasterRepository.selectLineList(lineMasterDto));
    Response response = new Response(resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> saveLineMaster(LineMasterDto lineMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    lineMasterDto.setCreateUserId(authorizedUser.getUserId());
    CmLineMEntity cmLineMEntity = modelMapper.map(lineMasterDto, CmLineMEntity.class);
    lineMasterRepository.merge(cmLineMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateLineMaster(LineMasterDto lineMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    lineMasterDto.setUpdateUserId(authorizedUser.getUserId());
    CmLineMEntity cmLineMEntity = modelMapper.map(lineMasterDto, CmLineMEntity.class);
    lineMasterRepository.merge(cmLineMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


}
