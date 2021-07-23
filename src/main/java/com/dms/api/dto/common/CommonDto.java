package com.dms.api.dto.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDto {

  private String idOrName;
  private String plantId;
  private String description;
  private String useYn;
  private String createDt;
  private String createUserId;
  private String updateDt;
  private String updateUserId;
  private String api;
  private String tid;

}
