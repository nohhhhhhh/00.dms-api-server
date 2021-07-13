package com.dms.api.controller.common.user;

import com.dms.api.entitiy.common.user.UserMaster;
import com.dms.api.service.common.user.UserMasterService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
  public Optional<List<UserMaster>> getUserMasters(@RequestParam("param") String param,
      UserMaster userMaster) {
    System.out.println(param);
    return userMasterService.getUserMasters(userMaster);
  }

}