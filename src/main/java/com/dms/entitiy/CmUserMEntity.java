package com.dms.entitiy;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "CM_USER_M", schema = "dbo")
public class CmUserMEntity {

  private String userId;
  private String userNm;
  private String userState;
  private String userPwd;
  private Timestamp changePwdDt;
  private String email;
  private String telephone;
  private String mobile;
  private String mainMenuId;
  private String description;
  private String useYn;
  private Timestamp createDt;
  private String createUserId;
  private Timestamp updateDt;
  private String updateUserId;
  private String api;
  private String tid;

  @Id
  @Column(name = "USER_ID")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Basic
  @Column(name = "USER_NM")
  public String getUserNm() {
    return userNm;
  }

  public void setUserNm(String userNm) {
    this.userNm = userNm;
  }

  @Basic
  @Column(name = "USER_STATE")
  public String getUserState() {
    return userState;
  }

  public void setUserState(String userState) {
    this.userState = userState;
  }

  @Basic
  @Column(name = "USER_PWD")
  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }

  @Basic
  @Column(name = "CHANGE_PWD_DT")
  public Timestamp getChangePwdDt() {
    return changePwdDt;
  }

  public void setChangePwdDt(Timestamp changePwdDt) {
    this.changePwdDt = changePwdDt;
  }

  @Basic
  @Column(name = "EMAIL")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Basic
  @Column(name = "TELEPHONE")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  @Basic
  @Column(name = "MOBILE")
  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  @Basic
  @Column(name = "MAIN_MENU_ID")
  public String getMainMenuId() {
    return mainMenuId;
  }

  public void setMainMenuId(String mainMenuId) {
    this.mainMenuId = mainMenuId;
  }

  @Basic
  @Column(name = "DESCRIPTION")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "USE_YN")
  public String getUseYn() {
    return useYn;
  }

  public void setUseYn(String useYn) {
    this.useYn = useYn;
  }

  @Basic
  @CreationTimestamp
  @Column(name = "CREATE_DT", insertable = true, updatable = false)
  public Timestamp getCreateDt() {
    return createDt;
  }

  public void setCreateDt(Timestamp createDt) {
    this.createDt = createDt;
  }

  @Basic
  @Column(name = "CREATE_USER_ID", updatable = false)
  public String getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(String createUserId) {
    this.createUserId = createUserId;
  }

  @Basic
  @CreationTimestamp
  @Column(name = "UPDATE_DT", insertable = false, updatable = true)
  public Timestamp getUpdateDt() {
    return updateDt;
  }

  public void setUpdateDt(Timestamp updateDt) {
    this.updateDt = updateDt;
  }

  @Basic
  @Column(name = "UPDATE_USER_ID", insertable = false, updatable = true)
  public String getUpdateUserId() {
    return updateUserId;
  }

  public void setUpdateUserId(String updateUserId) {
    this.updateUserId = updateUserId;
  }

  @Basic
  @Column(name = "API")
  public String getApi() {
    return api;
  }

  public void setApi(String api) {
    this.api = api;
  }

  @Basic
  @Column(name = "TID")
  public String getTid() {
    return tid;
  }

  public void setTid(String tid) {
    this.tid = tid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CmUserMEntity that = (CmUserMEntity) o;
    return Objects.equals(userId, that.userId) &&
        Objects.equals(userNm, that.userNm) &&
        Objects.equals(userState, that.userState) &&
        Objects.equals(userPwd, that.userPwd) &&
        Objects.equals(changePwdDt, that.changePwdDt) &&
        Objects.equals(email, that.email) &&
        Objects.equals(telephone, that.telephone) &&
        Objects.equals(mobile, that.mobile) &&
        Objects.equals(mainMenuId, that.mainMenuId) &&
        Objects.equals(description, that.description) &&
        Objects.equals(useYn, that.useYn) &&
        Objects.equals(createDt, that.createDt) &&
        Objects.equals(createUserId, that.createUserId) &&
        Objects.equals(updateDt, that.updateDt) &&
        Objects.equals(updateUserId, that.updateUserId) &&
        Objects.equals(api, that.api) &&
        Objects.equals(tid, that.tid);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(userId, userNm, userState, userPwd, changePwdDt, email, telephone, mobile, mainMenuId,
            description, useYn, createDt, createUserId, updateDt, updateUserId, api, tid);
  }
}
