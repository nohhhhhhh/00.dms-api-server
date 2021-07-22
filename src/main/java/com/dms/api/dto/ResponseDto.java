package com.dms.api.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDto {

  private int status;
  private LocalDateTime timestamp;
  private String message;
  private List<?> resultList;

}
