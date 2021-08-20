package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class EquipmentMasterDto extends CommonDto {

  @NonNull
  private String equipmentClassId;
  private String equipmentClassNm;
  private String equipmentClassType;

  private String equipmentId;
  private String equipmentNm;
  private String parentEquipmentId;
  private String equipmentType;
  private String equipmentLevel;
  private String lifecycleYn;
  private String lineId;
  private String ifYn;
  private String ifId;
}
