package com.dms.api.controllers.common.user;

import com.dms.api.domains.common.user.UserMaster;
import com.dms.api.services.common.user.UserMasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-master")
public class UserMasterController {

  @Autowired
  private UserMasterService userMasterService;

  @RequestMapping(value = "users", method = {RequestMethod.GET, RequestMethod.POST})
  public List<UserMaster> getUserMasters(UserMaster userMaster) {
    return userMasterService.getUserMasters(userMaster);
  }

}
