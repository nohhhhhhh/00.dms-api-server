package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.EquipmentMasterDto;
import com.dms.entitiy.EmEquipmentClassMEntity;
import com.dms.repository.setting.EquipmentClassMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EquipmentClassMasterService {

  @Autowired
  private EquipmentClassMasterRepository equipmentClassMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<Response> getEquipmentClassMasters(EquipmentMasterDto equipmentMasterDto) {
    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData.put("dataList",
        equipmentClassMasterRepository.selectEquipmentClassMasterList(equipmentMasterDto));
    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> saveEquipmentClassMasters(EquipmentMasterDto equipmentMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    equipmentMasterDto.setCreateUserId(authorizedUser.getUserId());
    EmEquipmentClassMEntity equipmentClassMEntity = modelMapper
        .map(equipmentMasterDto, EmEquipmentClassMEntity.class);
    equipmentClassMasterRepository.merge(equipmentClassMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateEquipmentClassMasters(EquipmentMasterDto equipmentMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    equipmentMasterDto.setUpdateUserId(authorizedUser.getUserId());
    EmEquipmentClassMEntity equipmentClassMEntity = modelMapper
        .map(equipmentMasterDto, EmEquipmentClassMEntity.class);
    equipmentClassMasterRepository.merge(equipmentClassMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
