package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.MenuMasterDto;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.service.business.setting.MenuMasterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu-master")
public class MenuMasterController {

  @Autowired
  private MenuMasterService menuMasterService;

  @ApiOperation(value = "top-items", notes = "상단 메뉴 정보")
  @GetMapping("/top-items")
  public ResponseEntity<Response> getTopItems(@RequestParam(required = false) String useYn,
      @RequestParam(required = false) String plantId,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return menuMasterService.getTopItems(authorizedUser, useYn, plantId);
  }

  @ApiOperation(value = "top-items", notes = "선택 Menu 의 권한 체크")
  @GetMapping("/menu-auth")
  public ResponseEntity<Response> checkMenuAuth(@ModelAttribute UserMasterDto userMasterDto,
      @ModelAttribute MenuMasterDto menuMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser
  ) {
    return menuMasterService.checkMenuAuth(authorizedUser, userMasterDto, menuMasterDto);
  }



}
