package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.CodeMasterDto;
import com.dms.api.service.business.setting.CodeMasterService;
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
@RequestMapping("code-master")
public class CodeMasterController {

  @Autowired
  CodeMasterService codeMasterService;

  @GetMapping
  @ApiOperation(value = "공통코드 리스트", notes = "공통코드 리스트")
  public ResponseEntity<Response> getCodeMasters(CodeMasterDto codeMasterDto) {
    return codeMasterService.getCodeMasters(codeMasterDto);
  }

  @PostMapping
  @ApiOperation(value = "공통코드 등록", notes = "공통코드 등록")
  public ResponseEntity<Response> saveCodeMasters(CodeMasterDto codeMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return codeMasterService.saveCodeMasters(codeMasterDto, authorizedUser);
  }

  @PutMapping
  @ApiOperation(value = "공통코드 수정", notes = "공통코드 수정")
  public ResponseEntity<Response> updateCodeMasters(CodeMasterDto codeMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return codeMasterService.updateCodeMasters(codeMasterDto, authorizedUser);
  }

}
