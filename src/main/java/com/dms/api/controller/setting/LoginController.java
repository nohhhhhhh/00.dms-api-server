package com.dms.api.controller.setting;

import com.dms.api.dto.ResponseDto;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.service.setting.LoginService;
import com.dms.api.service.setting.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserMaster CRUD Controller
 *
 * @author NOH
 * @since 1.0
 *
 */
@RestController
@RequestMapping("login")
public class LoginController {

  @Autowired
  private UserMasterService userMasterService;

  @Autowired
  private LoginService loginService;

  @GetMapping
  public ResponseEntity<ResponseDto> getUserLoginResult(@ModelAttribute UserMasterDto userMasterDto)
      throws Exception {
    return loginService.getUserLoginResult(userMasterDto);
  }

}
