package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.PlantMasterDto;
import com.dms.entitiy.CmPlantMEntity;
import com.dms.repository.setting.PlantMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlantMasterService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private PlantMasterRepository plantMasterRepository;

  public ResponseEntity<Response> getPlantMaster(PlantMasterDto plantMasterDto) {

    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData.put("dataList", plantMasterRepository.selectListByOption(plantMasterDto));
    Response response = new Response(resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }


  public ResponseEntity<Response> savePlantMaster(PlantMasterDto plantMasterDto,
      AuthorizedUser authorizedUser) {

    plantMasterDto.setCreateUserId(authorizedUser.getUserId());
    CmPlantMEntity cmPlantMEntity = modelMapper.map(plantMasterDto, CmPlantMEntity.class);
    plantMasterRepository.merge(cmPlantMEntity);
    Response response = new Response(new HashMap<>());
    return new ResponseEntity<Response>(response, HttpStatus.OK);

  }

  public ResponseEntity<Response> updatePlantMaster(PlantMasterDto plantMasterDto,
      AuthorizedUser authorizedUser) {

    plantMasterDto.setUpdateUserId(authorizedUser.getUserId());
    CmPlantMEntity cmPlantMEntity = modelMapper.map(plantMasterDto, CmPlantMEntity.class);
    plantMasterRepository.merge(cmPlantMEntity);
    Response response = new Response(new HashMap<>());
    return new ResponseEntity<Response>(response, HttpStatus.OK);

  }

}
