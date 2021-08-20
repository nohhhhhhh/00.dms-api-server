package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.EquipmentMasterDto;
import com.dms.api.service.business.setting.EquipmentClassMasterService;
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
@RequestMapping("equipment-class-master")
public class EquipmetClassMasterController {

  @Autowired
  EquipmentClassMasterService equipmentClassMasterService;

  @GetMapping
  @ApiOperation(value = "설비 Class 리스트", notes = "설비 Class 리스트")
  public ResponseEntity<Response> getEquipmentClassMasters(EquipmentMasterDto equipmentMasterDto) {
    return equipmentClassMasterService.getEquipmentClassMasters(equipmentMasterDto);
  }

  @PostMapping
  @ApiOperation(value = "설비 Class 등록", notes = "설비 Class 등록")
  public ResponseEntity<Response> saveEquipmentClassMasters(EquipmentMasterDto equipmentMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return equipmentClassMasterService.saveEquipmentClassMasters(equipmentMasterDto, authorizedUser);
  }

  @PutMapping
  @ApiOperation(value = "설비 Class 수정", notes = "설비 Class 수정")
  public ResponseEntity<Response> updateEquipmentClassMasters(EquipmentMasterDto equipmentMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return equipmentClassMasterService.updateEquipmentClassMasters(equipmentMasterDto, authorizedUser);
  }

}
