package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.entitiy.CmUserMEntity;
import com.dms.api.service.business.setting.UserMasterService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserMaster CRUD Controller.
 *
 * @author NOH
 * @since 1.0
 */
@RestController
@RequestMapping("user-master")
public class UserMasterController {

  @Autowired
  private UserMasterService userMasterService;

  @GetMapping
  @ApiOperation(value = "User List 조회")
  public List<CmUserMEntity> getUserMaster(@ModelAttribute UserMasterDto userMasterDto,
      @RequestParam(required = false) String param) {
    return userMasterService.getUserMaster(userMasterDto);
  }

  @GetMapping("/guide")
  public ResponseEntity<Response> getUserMasters(@ModelAttribute UserMasterDto userMasterDto,
      @RequestParam String param) {
    return userMasterService.getUserMasters(userMasterDto);
  }

  @PostMapping
  @ApiOperation(value = "User 등록")
  public ResponseEntity<Response> saveUserMaster(@ModelAttribute UserMasterDto userMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return userMasterService.saveUserMaster(userMasterDto, authorizedUser);
  }

  @PutMapping
  @ApiOperation(value = "User 수정")
  public ResponseEntity<Response> updateUserMaster(@ModelAttribute UserMasterDto userMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return userMasterService.updateUserMaster(userMasterDto, authorizedUser);
  }

  @DeleteMapping
  @ApiOperation(value = "User 삭제")
  public ResponseEntity<Response> deleteUserMaster(@ModelAttribute UserMasterDto userMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return userMasterService.deleteUserMaster(userMasterDto, authorizedUser);
  }

}
