package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.LineMasterDto;
import com.dms.api.service.business.setting.LineMasterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/line-master")
public class LineMasterController {

  @Autowired
  private LineMasterService lineMasterService;

  @ApiOperation(value = "라인 리스트")
  @GetMapping
  public ResponseEntity<Response> getLineMasters(@ModelAttribute LineMasterDto lineMasterDto) {
    return lineMasterService.getLineMasters(lineMasterDto);
  }

  @ApiOperation(value = "라인 신규 등록")
  @PostMapping
  public ResponseEntity<Response> saveLineMaster(@ModelAttribute LineMasterDto lineMasterDto,
  @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return lineMasterService.saveLineMaster(lineMasterDto, authorizedUser);
  }

  @ApiOperation(value = "라인 수정")
  @PutMapping
  public ResponseEntity<Response> updateLineMaster(@ModelAttribute LineMasterDto lineMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return lineMasterService.updateLineMaster(lineMasterDto, authorizedUser);
  }

}
