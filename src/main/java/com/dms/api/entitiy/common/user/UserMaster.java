package com.dms.api.entitiy.common.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "CM_USER_M")
@Entity
public class UserMaster {

  @Id
  private String userId;

  private String userNm;
  private String userState;
  private String userPwd;
  private String changePwdDt;
  private String email;
  private String telephone;
  private String mobile;
  private String mainMenuId;
  private String description;
  private String useYn;
  private String createDt;
  private String createUserId;
  private String updateDt;
  private String updateUserId;
  private String api;
  private String tid;

}
