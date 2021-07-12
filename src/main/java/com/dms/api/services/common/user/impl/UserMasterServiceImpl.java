package com.dms.api.services.common.user.impl;

import com.dms.api.domains.common.user.UserMaster;
import com.dms.api.repositories.common.user.UserMasterRepository;
import com.dms.api.services.common.user.UserMasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMasterServiceImpl implements UserMasterService {

  @Autowired
  private UserMasterRepository userMasterRepository;

  public List<UserMaster> getUserMasters(UserMaster userMaster) {
    return userMasterRepository.findAll();
  }

}
