package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.ProcessEquipmentRelationDto;
import com.dms.api.dto.setting.ProcessMasterDto;
import com.dms.entitiy.PmProcessEquipmentREntity;
import com.dms.entitiy.PmProcessMEntity;
import com.dms.repository.setting.ProcessEquipmentRelationRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProcessEquipmentRelationService {

  @Autowired
  private ProcessEquipmentRelationRepository processEquipmentRelationRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<Response> getProcessEquipmentRelations(
      ProcessEquipmentRelationDto processEquipmentRelationDto) {
    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData
        .put("dataList",
            processEquipmentRelationRepository.selectProcessEquipmentRelationList(processEquipmentRelationDto));
    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> saveProcessEquipmentRelations(
      ProcessEquipmentRelationDto processEquipmentRelationDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    processEquipmentRelationDto.setCreateUserId(authorizedUser.getUserId());
    PmProcessEquipmentREntity pmProcessEquipmentREntity = modelMapper
        .map(processEquipmentRelationDto, PmProcessEquipmentREntity.class);
    processEquipmentRelationRepository.merge(pmProcessEquipmentREntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateProcessEquipmentRelations(
      ProcessEquipmentRelationDto processEquipmentRelationDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    processEquipmentRelationDto.setUpdateUserId(authorizedUser.getUserId());

    PmProcessEquipmentREntity pmProcessEquipmentREntity = modelMapper
        .map(processEquipmentRelationDto, PmProcessEquipmentREntity.class);
    processEquipmentRelationRepository.merge(pmProcessEquipmentREntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
