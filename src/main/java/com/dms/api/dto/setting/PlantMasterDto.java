package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PlantMasterDto extends CommonDto {

  @NonNull
  private String plantId;
  private String plantNm;
  private String ifYn;
  private String siteId;

}
