package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.PlantMasterDto;
import com.dms.api.service.business.setting.PlantMasterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserMaster CRUD Controller.
 *
 * @author NOH
 * @since 1.0
 *
 */
@RestController
public class PlantMasterController {

  @Autowired
  private PlantMasterService plantMasterService;

  @ApiOperation(value = "Plant List", notes = "접근 가능한 Plant List 조회")
  @GetMapping("/open-api/plant-master")
  public ResponseEntity<Response> getPlantMaster(@ModelAttribute PlantMasterDto plantMasterDto)
      throws Exception { return plantMasterService.getPlantMaster(plantMasterDto);
  }

}
