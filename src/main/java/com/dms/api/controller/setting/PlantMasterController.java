package com.dms.api.controller.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.PlantMasterDto;
import com.dms.api.service.setting.PlantMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserMaster CRUD Controller.
 *
 * @author NOH
 * @since 1.0
 *
 */
@RestController
@RequestMapping("plant-master")
public class PlantMasterController {

  @Autowired
  private PlantMasterService plantMasterService;

  @GetMapping
  public ResponseEntity<Response> getPlantMaster(@ModelAttribute PlantMasterDto plantMasterDto)
      throws Exception {
    return plantMasterService.getPlantMaster(plantMasterDto);
  }

}
