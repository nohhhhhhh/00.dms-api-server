package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.ProcessEquipmentRelationDto;
import com.dms.api.service.business.setting.ProcessEquipmentRelationService;
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
 * Process Class Master CRUD Controller.
 *
 * @author NOH
 * @since 1.0
 */
@RestController
@RequestMapping("process-equipment-relation")
public class ProcessEquipmentRelationController {

  @Autowired
  ProcessEquipmentRelationService processEquipmentRelationService;

  @GetMapping
  @ApiOperation(value = "공정 리스트", notes = "공정 리스트")
  public ResponseEntity<Response> getProcessEquipmentRelations(
      ProcessEquipmentRelationDto processEquipmentRelationDto) {
    return processEquipmentRelationService
        .getProcessEquipmentRelations(processEquipmentRelationDto);
  }

  @PostMapping
  @ApiOperation(value = "공정 등록", notes = "공정 등록")
  public ResponseEntity<Response> saveProcessEquipmentRelations(
      ProcessEquipmentRelationDto processEquipmentRelationDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return processEquipmentRelationService
        .saveProcessEquipmentRelations(processEquipmentRelationDto, authorizedUser);
  }

  @PutMapping
  @ApiOperation(value = "공정 수정", notes = "공정 수정")
  public ResponseEntity<Response> updateProcessEquipmentRelations(
      ProcessEquipmentRelationDto processEquipmentRelationDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return processEquipmentRelationService
        .updateProcessEquipmentRelations(processEquipmentRelationDto, authorizedUser);
  }

}
