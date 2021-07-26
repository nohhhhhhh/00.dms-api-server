package com.dms.api.service.setting.impl;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.PlantMasterDto;
import com.dms.api.repository.setting.PlantMasterRepository;
import com.dms.api.service.setting.PlantMasterService;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlantMasterServiceImpl implements PlantMasterService {

  @Autowired
  private PlantMasterRepository plantMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public int status = 500;
  public String message;
  public Map<String, Object> resultData;
  public List<?> resultList;

  public ResponseEntity<Response> getPlantMaster(PlantMasterDto plantMasterDto) throws Exception {

    try {
      status = 200;
      message = "HttpStatus.OK";
      resultData = new HashMap<String, Object>();
      resultData.put("dataList", plantMasterRepository.selectListByOption(plantMasterDto));
    } catch (Exception e) {
      message = "HttpStatus.INTERNAL_SERVER_ERROR";
    }

    Response response = new Response(status, LocalDateTime.now(), message, resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}


