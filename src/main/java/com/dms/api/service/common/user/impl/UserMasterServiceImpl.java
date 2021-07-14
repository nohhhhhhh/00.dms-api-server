package com.dms.api.service.common.user.impl;

import com.dms.api.dto.common.user.UserBaseDto;
import com.dms.api.entitiy.common.user.UserMaster;
import com.dms.api.repository.common.user.UserMasterRepo;
import com.dms.api.service.common.user.UserMasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMasterServiceImpl implements UserMasterService {

  @Autowired
  private UserMasterRepo userMasterRepo;

  public List<UserMaster> getUserMaster(UserBaseDto userMasterDto) {
    return userMasterRepo.findByOption(userMasterDto);
  }

}
