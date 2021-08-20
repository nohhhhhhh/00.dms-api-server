package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class LineMasterDto extends CommonDto {

  @NonNull
  private String lineId;
  private String lineNm;
  private String parentLineId;
  private String pmsYn;
  private String wgtYn;
  private String ifYn;
  private String ifId;

}
