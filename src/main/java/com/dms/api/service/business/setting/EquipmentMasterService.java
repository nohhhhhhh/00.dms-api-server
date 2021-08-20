package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.EquipmentMasterDto;
import com.dms.entitiy.EmEquipmentMEntity;
import com.dms.repository.setting.EquipmentMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EquipmentMasterService {

  @Autowired
  private EquipmentMasterRepository equipmentMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<Response> getEquipmentMasters(EquipmentMasterDto equipmentMasterDto) {
    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData.put("dataList",
        equipmentMasterRepository.selectEquipmentMasterList(equipmentMasterDto));
    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> saveEquipmentMasters(EquipmentMasterDto equipmentMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    equipmentMasterDto.setCreateUserId(authorizedUser.getUserId());
    EmEquipmentMEntity equipmentMEntity = modelMapper
        .map(equipmentMasterDto, EmEquipmentMEntity.class);
    equipmentMasterRepository.merge(equipmentMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateEquipmentMasters(EquipmentMasterDto equipmentMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    equipmentMasterDto.setUpdateUserId(authorizedUser.getUserId());
    EmEquipmentMEntity equipmentMEntity = modelMapper
        .map(equipmentMasterDto, EmEquipmentMEntity.class);
    equipmentMasterRepository.merge(equipmentMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
