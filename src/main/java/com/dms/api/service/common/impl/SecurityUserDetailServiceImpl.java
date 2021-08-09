package com.dms.api.service.common.impl;

import com.dms.api.dto.common.auth.AuthorizedAdapter;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.repository.setting.UserMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Spring Security UserDetailsService Implements.
 *
 * @author NOH
 * @since 1.0
 *
 */
@Service
public class SecurityUserDetailServiceImpl implements UserDetailsService {

  @Autowired
  UserMasterRepository userMasterRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

    UserMasterDto userMasterDto = new UserMasterDto();

    userMasterDto.setUserId(userId);
    userMasterDto = userMasterRepository.selectUserOneByOption(userMasterDto)
        .orElseThrow(() -> new UsernameNotFoundException((userId)));

    AuthorizedUser authorizedUser = new AuthorizedUser(null, userMasterDto.getUserId(),
        userMasterDto.getUserPwd()
        , userMasterDto.getUserNm(), null
    );

    return new AuthorizedAdapter(authorizedUser);
  }

}
