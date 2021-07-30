package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserMasterDto extends CommonDto {

  @NonNull
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
