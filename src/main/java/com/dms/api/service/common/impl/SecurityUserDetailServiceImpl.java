package com.dms.api.service.common.impl;

import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import com.dms.api.repository.setting.UserMasterRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailServiceImpl implements UserDetailsService {

  @Autowired
  UserMasterRepository userMasterRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    UserMasterDto userMasterDto = new UserMasterDto();
    String authUserId = "";
    String authPwd = "";

    userMasterDto.setUserId(userId);
    List<UserMaster> userMaster = userMasterRepository.selectListByOption(userMasterDto);

    if (userMaster.size() > 0) {
      authUserId = userMaster.get(0).getUserId();
      authPwd = userMaster.get(0).getUserPwd();
    }

    return new org.springframework.security.core.userdetails.User(authUserId, authPwd,
        new ArrayList<>());
  }

}
