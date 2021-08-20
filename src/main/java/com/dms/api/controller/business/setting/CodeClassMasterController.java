package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.CodeMasterDto;
import com.dms.api.service.business.setting.CodeClassMasterService;
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
@RequestMapping("code-class-master")
public class CodeClassMasterController {

  @Autowired
  CodeClassMasterService codeClassMasterService;

  @GetMapping
  @ApiOperation(value = "코드 Class 리스트", notes = "코드 Class 리스트")
  public ResponseEntity<Response> getCodeClassMasters(CodeMasterDto codeMasterDto) {
    return codeClassMasterService.getCodeClassMasters(codeMasterDto);
  }

  @PostMapping
  @ApiOperation(value = "코드 Class 등록", notes = "코드 Class 등록")
  public ResponseEntity<Response> saveProcessClassMasters(CodeMasterDto codeMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return codeClassMasterService.saveClassCodeMasters(codeMasterDto, authorizedUser);
  }

  @PutMapping
  @ApiOperation(value = "코드 Class 수정", notes = "코드 Class 수정")
  public ResponseEntity<Response> updateProcessClassMasters(CodeMasterDto codeMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return codeClassMasterService.updateClassCodeMasters(codeMasterDto, authorizedUser);
  }

}
