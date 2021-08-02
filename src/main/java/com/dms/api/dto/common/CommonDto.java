package com.dms.api.dto.common;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDto {

  private String idOrName;

  private String plantId;
  private String description;
  private String useYn;
  private Date createDt;
  private String createUserId;
  private Date updateDt;
  private String updateUserId;
  private String api;
  private String tid;

}
