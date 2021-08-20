package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.ProcessMasterDto;
import com.dms.api.service.business.setting.ProcessClassMasterservice;
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
@RequestMapping("process-class-master")
public class ProcessClassMasterController {

  @Autowired
  ProcessClassMasterservice processClassMasterservice;

  @GetMapping
  @ApiOperation(value = "공정 Class 리스트", notes = "공정 Class 리스트")
  public ResponseEntity<Response> getProcessClassMasters(
      ProcessMasterDto processMasterDto) {
    return processClassMasterservice.getProcessClassMasters(processMasterDto);
  }

  @PostMapping
  @ApiOperation(value = "공정 Class 등록", notes = "공정 Class 등록")
  public ResponseEntity<Response> saveProcessClassMasters(
      ProcessMasterDto processMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return processClassMasterservice.saveProcessClassMasters(processMasterDto, authorizedUser);
  }

  @PutMapping
  @ApiOperation(value = "공정 Class 수정", notes = "공정 Class 수정")
  public ResponseEntity<Response> updateProcessClassMasters(
      ProcessMasterDto processMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return processClassMasterservice
        .updateProcessClassMasters(processMasterDto, authorizedUser);
  }

}
