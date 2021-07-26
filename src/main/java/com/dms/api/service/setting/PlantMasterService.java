package com.dms.api.service.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.PlantMasterDto;
import org.springframework.http.ResponseEntity;

public interface PlantMasterService {

  ResponseEntity<Response> getPlantMaster(PlantMasterDto plantMasterDto) throws Exception;

}
