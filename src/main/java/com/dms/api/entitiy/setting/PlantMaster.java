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
@Table(name = "CM_PLANT_M")
@Entity
public class PlantMaster {

  @Id
  @NotNull
  private String plantId;
  private String plantNm;
  private String seq;
  private String ifYn;
  private String siteId;
  private String description;
  private String useYn;
  private String createDt;
  private String createUserId;
  private String updateDt;
  private String updateUserId;
  private String api;
  private String tid;

}
