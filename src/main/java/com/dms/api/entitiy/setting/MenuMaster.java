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
@Table(name = "CM_MENU_M")
@Entity
public class MenuMaster {

  @Id
  @NotNull
  private String menuId;
  private String menuNm;
  private String parentMenuId;
  private int menuLevel;
  private String menuUrl;
  private String seq;
  private String linkYn;
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
