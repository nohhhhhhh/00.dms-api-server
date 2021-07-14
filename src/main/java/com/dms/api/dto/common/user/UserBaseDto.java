package com.dms.api.dto.common.user;

import com.dms.api.dto.DmsBaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBaseDto extends DmsBaseDto {

  private String userId;
  private String userNm;
  private String userState;
  private String userPwd;
  private String changePwdDt;
  private String email;
  private String telephone;
  private String mobile;
  private String mainMenuId;

}
