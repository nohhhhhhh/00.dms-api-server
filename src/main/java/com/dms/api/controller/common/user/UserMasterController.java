package com.dms.api.controller.common.user;

import com.dms.api.dto.common.user.UserBaseDto;
import com.dms.api.entitiy.common.user.UserMaster;
import com.dms.api.service.common.user.UserMasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserMaster CRUD Guide Page.
 */
@RestController
@RequestMapping("user-master")
public class UserMasterController {

  @Autowired
  private UserMasterService userMasterService;

  @GetMapping
  public List<UserMaster> getUserMaster(@ModelAttribute UserBaseDto userMasterDto,
      @RequestParam String param) {
    return userMasterService.getUserMaster(userMasterDto);
  }

}
