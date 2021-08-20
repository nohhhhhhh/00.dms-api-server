package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.EquipmentMasterDto;
import com.dms.api.service.business.setting.EquipmentMasterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CodeMaster CRUD Controller.
 *
 * @author NOH
 * @since 1.0
 */
@RestController
@RequestMapping("equipment-master")
public class EquipmetMasterController {

  @Autowired
  EquipmentMasterService equipmentMasterService;

  @GetMapping
  @ApiOperation(value = "설비 리스트", notes = "설비 리스트")
  public ResponseEntity<Response> getEquipmentMasters(EquipmentMasterDto equipmentMasterDto) {
    return equipmentMasterService.getEquipmentMasters(equipmentMasterDto);
  }

  @PostMapping
  @ApiOperation(value = "설비 등록", notes = "설비 등록")
  public ResponseEntity<Response> saveEquipmentMasters(EquipmentMasterDto equipmentMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return equipmentMasterService.saveEquipmentMasters(equipmentMasterDto, authorizedUser);
  }

  @PutMapping
  @ApiOperation(value = "설비 수정", notes = "설비 수정")
  public ResponseEntity<Response> updateEquipmentMasters(EquipmentMasterDto equipmentMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return equipmentMasterService.updateEquipmentMasters(equipmentMasterDto, authorizedUser);
  }

}
