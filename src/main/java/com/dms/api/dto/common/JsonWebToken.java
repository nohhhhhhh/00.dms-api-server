package com.dms.api.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JsonWebToken {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String token;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String userName;

  public JsonWebToken(String token, String userName) {
    super();
    this.token = token;
    this.userName = userName;
  }

}
