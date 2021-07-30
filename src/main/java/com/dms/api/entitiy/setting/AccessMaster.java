package com.dms.api.entitiy.setting;


import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "CM_ACCESS_M")
@Entity
public class AccessMaster {

  @Id
  @NotNull
  private String accessId;
  private String accessNm;
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