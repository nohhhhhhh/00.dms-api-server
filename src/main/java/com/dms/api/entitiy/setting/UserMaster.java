package com.dms.api.entitiy.setting;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "CM_USER_M")
@Entity
public class UserMaster {

  @Id
  @NotNull
  private String userId;

  @NotNull
  private String userNm;

  private String userState;

  @NotNull
  private String userPwd;

  private String changePwdDt;

  private String email;
  private String telephone;
  private String mobile;
  private String mainMenuId;
  private String description;

  private String useYn;

  @CreationTimestamp
  private Date createDt;
  private String createUserId;
  private String updateDt;
  private String updateUserId;
  private String api;
  private String tid;

}
