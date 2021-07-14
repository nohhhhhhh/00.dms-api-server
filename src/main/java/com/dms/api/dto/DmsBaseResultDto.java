package com.dms.api.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DmsBaseResultDto {

  private String resultCode;
  private String resultMessage;
  private List<?> resultList;

}
