package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserMasterDto extends CommonDto {

  @NonNull
  @ApiParam(value = "사용자 ID", required = true)
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
