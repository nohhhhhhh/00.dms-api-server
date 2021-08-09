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
@Table(name = "CM_CODE_M", schema = "dbo")
@IdClass(CmCodeMEntityPK.class)
public class CmCodeMEntity {

  private String codeClsId;
  private String codeId;
  private String codeVal;
  private String codeNm;
  private String parentCodeClsId;
  private String parentCodeId;
  private String seq;
  private String plantId;
  private String description;
  private String defaultYn;
  private String useYn;
  private Date createDt;
  private String createUserId;
  private Date updateDt;
  private String updateUserId;
  private String api;
  private String tid;

  @Id
  @Column(name = "CODE_CLS_ID")
  public String getCodeClsId() {
    return codeClsId;
  }

  public void setCodeClsId(String codeClsId) {
    this.codeClsId = codeClsId;
  }

  @Id
  @Column(name = "CODE_ID")
  public String getCodeId() {
    return codeId;
  }

  public void setCodeId(String codeId) {
    this.codeId = codeId;
  }

  @Basic
  @Column(name = "CODE_VAL")
  public String getCodeVal() {
    return codeVal;
  }

  public void setCodeVal(String codeVal) {
    this.codeVal = codeVal;
  }

  @Basic
  @Column(name = "CODE_NM")
  public String getCodeNm() {
    return codeNm;
  }

  public void setCodeNm(String codeNm) {
    this.codeNm = codeNm;
  }

  @Basic
  @Column(name = "PARENT_CODE_CLS_ID")
  public String getParentCodeClsId() {
    return parentCodeClsId;
  }

  public void setParentCodeClsId(String parentCodeClsId) {
    this.parentCodeClsId = parentCodeClsId;
  }

  @Basic
  @Column(name = "PARENT_CODE_ID")
  public String getParentCodeId() {
    return parentCodeId;
  }

  public void setParentCodeId(String parentCodeId) {
    this.parentCodeId = parentCodeId;
  }

  @Basic
  @Column(name = "SEQ")
  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
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
  @Column(name = "DEFAULT_YN")
  public String getDefaultYn() {
    return defaultYn;
  }

  public void setDefaultYn(String defaultYn) {
    this.defaultYn = defaultYn;
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
    CmCodeMEntity that = (CmCodeMEntity) o;
    return Objects.equals(codeClsId, that.codeClsId) &&
        Objects.equals(codeId, that.codeId) &&
        Objects.equals(codeVal, that.codeVal) &&
        Objects.equals(codeNm, that.codeNm) &&
        Objects.equals(parentCodeClsId, that.parentCodeClsId) &&
        Objects.equals(parentCodeId, that.parentCodeId) &&
        Objects.equals(seq, that.seq) &&
        Objects.equals(plantId, that.plantId) &&
        Objects.equals(description, that.description) &&
        Objects.equals(defaultYn, that.defaultYn) &&
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
        .hash(codeClsId, codeId, codeVal, codeNm, parentCodeClsId, parentCodeId, seq, plantId,
            description, defaultYn, useYn, createDt, createUserId, updateDt, updateUserId, api,
            tid);
  }
}
