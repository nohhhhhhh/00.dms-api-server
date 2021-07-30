package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuMasterDto extends CommonDto {

  @NonNull
  private String menuId;
  private String menuNm;
  private String parentMenuId;
  private int menuLevel;
  private String menuUrl;
  private String seq;
  private String linkYn;

}
