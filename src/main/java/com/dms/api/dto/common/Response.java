package com.dms.api.dto.common;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

  private int status;
  private LocalDateTime timestamp;
  private String message;
  private Map<String, Object> data;

  public Response(int status, String message,
      Map<String, Object> data) {
    this.status = status;
    this.timestamp = LocalDateTime.now();
    this.message = message;
    this.data = data;
  }

}
