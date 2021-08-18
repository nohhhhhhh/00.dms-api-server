package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.SiteMasterDto;
import com.dms.api.service.business.setting.SiteMasterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/site-master")
public class SiteMasterController {

  @Autowired
  private SiteMasterService siteMasterService;

  @ApiOperation(value = "사이트 리스트")
  @GetMapping
  public ResponseEntity<Response> getSiteMasters(@ModelAttribute SiteMasterDto siteMasterDto) {
    return siteMasterService.getSiteMasters(siteMasterDto);
  }

  @ApiOperation(value = "사이트 신규 등록")
  @PostMapping
  public ResponseEntity<Response> saveSiteMaster(@ModelAttribute SiteMasterDto siteMasterDto,
  @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return siteMasterService.saveSiteMaster(siteMasterDto, authorizedUser);
  }

  @ApiOperation(value = "사이트 수정")
  @PutMapping
  public ResponseEntity<Response> updateSiteMaster(@ModelAttribute SiteMasterDto siteMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return siteMasterService.updateSiteMaster(siteMasterDto, authorizedUser);
  }

  @ApiOperation(value = "사이트 삭제")
  @DeleteMapping
  public ResponseEntity<Response> deleteSiteMaster(@ModelAttribute SiteMasterDto siteMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return siteMasterService.deleteSiteMaster(siteMasterDto, authorizedUser);
  }

}
