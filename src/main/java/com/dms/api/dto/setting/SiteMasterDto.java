package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class SiteMasterDto extends CommonDto {

  @NonNull
  private String siteId;
  private String siteNm;
  private int seq;

}
