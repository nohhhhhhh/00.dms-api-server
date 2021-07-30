package com.dms.api.controller.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.service.setting.MenuMasterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu-master")
public class MenuMasterController {

  @Autowired
  private MenuMasterService menuMasterService;

  @ApiOperation(value = "top-items", notes = "상단 메뉴 정보")
  @GetMapping("/top-items")
  public ResponseEntity<Response> getTopItems(@ModelAttribute UserMasterDto userMasterDto)
      throws Exception {
    return menuMasterService.getTopItems(userMasterDto);
  }

}
