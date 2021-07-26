package com.dms.api.service.common.impl;

import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import com.dms.api.repository.setting.UserMasterRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserMasterRepository userMasterRepository;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    UserMasterDto userMasterDto = new UserMasterDto();
    userMasterDto.setUserId(userName);
    List<UserMaster> user = userMasterRepository.selectListByOption(userMasterDto);

    if (user.size() == 0) {
      throw new UsernameNotFoundException("No user found. Username tried: " + userName);
    }

    Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
    grantedAuthorities.add(new SimpleGrantedAuthority("admin"));

    return new org.springframework.security.core.userdetails.User(user.get(0).getUserId(),
        user.get(0).getUserPwd(), grantedAuthorities);
  }

}


