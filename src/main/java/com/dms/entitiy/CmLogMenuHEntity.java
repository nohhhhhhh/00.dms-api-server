package com.dms.entitiy;

import java.sql.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_LOG_MENU_H", schema = "dbo")
public class CmLogMenuHEntity {

  private int eventSeq;
  private String userId;
  private String menuId;
  private Date eventDt;
  private String plantId;
  private String description;
  private String useYn;
  private Date createDt;
  private String createUserId;
  private Date updateDt;
  private String updateUserId;
  private String api;
  private String tid;

  @Id
  @Column(name = "EVENT_SEQ")
  public int getEventSeq() {
    return eventSeq;
  }

  public void setEventSeq(int eventSeq) {
    this.eventSeq = eventSeq;
  }

  @Basic
  @Column(name = "USER_ID")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Basic
  @Column(name = "MENU_ID")
  public String getMenuId() {
    return menuId;
  }

  public void setMenuId(String menuId) {
    this.menuId = menuId;
  }

  @Basic
  @Column(name = "EVENT_DT")
  public Date getEventDt() {
    return eventDt;
  }

  public void setEventDt(Date eventDt) {
    this.eventDt = eventDt;
  }

  @Basic
  @Column(name = "PLANT_ID")
  public String getPlantId() {
    return plantId;
  }

  public void setPlantId(String plantId) {
    this.plantId = plantId;
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
  @Column(name = "CREATE_DT")
  public Date getCreateDt() {
    return createDt;
  }

  public void setCreateDt(Date createDt) {
    this.createDt = createDt;
  }

  @Basic
  @Column(name = "CREATE_USER_ID")
  public String getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(String createUserId) {
    this.createUserId = createUserId;
  }

  @Basic
  @Column(name = "UPDATE_DT")
  public Date getUpdateDt() {
    return updateDt;
  }

  public void setUpdateDt(Date updateDt) {
    this.updateDt = updateDt;
  }

  @Basic
  @Column(name = "UPDATE_USER_ID")
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
    CmLogMenuHEntity that = (CmLogMenuHEntity) o;
    return Objects.equals(eventSeq, that.eventSeq) &&
        Objects.equals(userId, that.userId) &&
        Objects.equals(menuId, that.menuId) &&
        Objects.equals(eventDt, that.eventDt) &&
        Objects.equals(plantId, that.plantId) &&
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
        .hash(eventSeq, userId, menuId, eventDt, plantId, description, useYn, createDt,
            createUserId,
            updateDt, updateUserId, api, tid);
  }
}
