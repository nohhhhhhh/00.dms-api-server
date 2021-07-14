package com.dms.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DmsBaseDto {

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
