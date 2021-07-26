package com.dms.api.controller.common;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.service.common.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  @GetMapping(value = "/open-api/JsonWebToken", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Token 발행", notes = "Login 시 Token을 발행 한다.")
  public ResponseEntity<Response> generateJsonWebToken(
      @ModelAttribute UserMasterDto userMasterDto)
      throws Exception {
    return authenticationService.generateJsonWebToken(userMasterDto);
  }

}
