package com.dms.api.dto.common.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorizedUser {

  private String token;

  private String userId;

  private String userPwd;

  private String userName;

  private String plantId;

  public AuthorizedUser(String token, String userId, String userPwd, String userName,
      String plantId) {
    super();

    this.token = token;
    this.userId = userId;
    this.userPwd = userPwd;
    this.userName = userName;
    this.plantId = plantId;

  }

}
