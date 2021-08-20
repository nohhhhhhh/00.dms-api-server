package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class TagMasterDto extends CommonDto {

  @NonNull
  private String tagId;
  private String tagNm;
  private String tagClsId;
  private String tagParentId;
  private String tagType;
  private String tagAttr;
  private String equipmentId;
  private String unitId;
  private String decimalPt;
  private String ctqYn;
  private String weightYn;
  private String displayYn;
  private String manualYn;
  private String summaryYn;
  private String controlYn;
  private String commYn;
  private String commWebsckIp;
  private Integer commWebsckPort;
  private String commWebsckNm;
  private String commType;
  private String commTagId;
  private String commTagAddr;
  private String commScaleVal;
  private String commReverseYn;
  private String chartType;
  private String tableId;

}
