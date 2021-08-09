package com.dms.entitiy;

import java.sql.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "CM_MENU_M", schema = "dbo")
@IdClass(CmMenuMEntityPK.class)
public class CmMenuMEntity {

  private String menuId;
  private String menuNm;
  private String parentMenuId;
  private int menuLevel;
  private String menuUrl;
  private int seq;
  private String linkYn;
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
  @Column(name = "MENU_ID")
  public String getMenuId() {
    return menuId;
  }

  public void setMenuId(String menuId) {
    this.menuId = menuId;
  }

  @Basic
  @Column(name = "MENU_NM")
  public String getMenuNm() {
    return menuNm;
  }

  public void setMenuNm(String menuNm) {
    this.menuNm = menuNm;
  }

  @Basic
  @Column(name = "PARENT_MENU_ID")
  public String getParentMenuId() {
    return parentMenuId;
  }

  public void setParentMenuId(String parentMenuId) {
    this.parentMenuId = parentMenuId;
  }

  @Basic
  @Column(name = "MENU_LEVEL")
  public int getMenuLevel() {
    return menuLevel;
  }

  public void setMenuLevel(int menuLevel) {
    this.menuLevel = menuLevel;
  }

  @Basic
  @Column(name = "MENU_URL")
  public String getMenuUrl() {
    return menuUrl;
  }

  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
  }

  @Basic
  @Column(name = "SEQ")
  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  @Basic
  @Column(name = "LINK_YN")
  public String getLinkYn() {
    return linkYn;
  }

  public void setLinkYn(String linkYn) {
    this.linkYn = linkYn;
  }

  @Id
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
    CmMenuMEntity that = (CmMenuMEntity) o;
    return Objects.equals(menuId, that.menuId) &&
        Objects.equals(menuNm, that.menuNm) &&
        Objects.equals(parentMenuId, that.parentMenuId) &&
        Objects.equals(menuLevel, that.menuLevel) &&
        Objects.equals(menuUrl, that.menuUrl) &&
        Objects.equals(seq, that.seq) &&
        Objects.equals(linkYn, that.linkYn) &&
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
        .hash(menuId, menuNm, parentMenuId, menuLevel, menuUrl, seq, linkYn, plantId, description,
            useYn, createDt, createUserId, updateDt, updateUserId, api, tid);
  }
}
