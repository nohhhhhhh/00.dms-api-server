package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ProcessMasterDto extends CommonDto {

  @NonNull
  private String processClsId;
  private String processClsNm;
  private String processClsType;

  private String processId;
  private String processNm;
  private String processType;

  private String ifYn;
  private String lotYn;

}
