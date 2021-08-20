package com.dms.api.dto.common;

import java.text.SimpleDateFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDto {

  private String idOrName;

  private Integer seq;
  private String plantId;
  private String description;
  private String useYn;
  private SimpleDateFormat createDt;
  private String createUserId;
  private SimpleDateFormat updateDt;
  private String updateUserId;
  private String api;
  private String tid;

}
