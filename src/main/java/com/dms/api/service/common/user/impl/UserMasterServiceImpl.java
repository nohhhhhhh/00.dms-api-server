package com.dms.api.service.common.user.impl;

import com.dms.api.entitiy.common.user.UserMaster;
import com.dms.api.repository.common.user.UserMasterRepository;
import com.dms.api.service.common.user.UserMasterService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMasterServiceImpl implements UserMasterService {

  @Autowired
  private UserMasterRepository userMasterRepository;

  public Optional<List<UserMaster>> getUserMasters(UserMaster userMaster) {
    return Optional.of(userMasterRepository.findAll());
  }

}
