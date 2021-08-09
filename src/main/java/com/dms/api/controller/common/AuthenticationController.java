package com.dms.api.controller.common;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.service.common.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * Auth Check Controller.
 *
 * @author NOH
 * @since 1.0
 *
 */
@RestController
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  @GetMapping(value = "/open-api/JsonWebToken")
  public ResponseEntity<Response> generateJsonWebToken(
      @ModelAttribute UserMasterDto userMasterDto) {
    return authenticationService.generateJsonWebToken(userMasterDto);
  }

}
