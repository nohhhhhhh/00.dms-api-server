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
@Table(name = "CM_MONITORING_STANDARD_C", schema = "dbo")
@IdClass(CmMonitoringStandardCEntityPK.class)
public class CmMonitoringStandardCEntity {

  private String standardId;
  private String lineId;
  private String standardNm;
  private String standardVal;
  private String valDataType;
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
  @Column(name = "STANDARD_ID")
  public String getStandardId() {
    return standardId;
  }

  public void setStandardId(String standardId) {
    this.standardId = standardId;
  }

  @Id
  @Column(name = "LINE_ID")
  public String getLineId() {
    return lineId;
  }

  public void setLineId(String lineId) {
    this.lineId = lineId;
  }

  @Basic
  @Column(name = "STANDARD_NM")
  public String getStandardNm() {
    return standardNm;
  }

  public void setStandardNm(String standardNm) {
    this.standardNm = standardNm;
  }

  @Basic
  @Column(name = "STANDARD_VAL")
  public String getStandardVal() {
    return standardVal;
  }

  public void setStandardVal(String standardVal) {
    this.standardVal = standardVal;
  }

  @Basic
  @Column(name = "VAL_DATA_TYPE")
  public String getValDataType() {
    return valDataType;
  }

  public void setValDataType(String valDataType) {
    this.valDataType = valDataType;
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
    CmMonitoringStandardCEntity that = (CmMonitoringStandardCEntity) o;
    return Objects.equals(standardId, that.standardId) &&
        Objects.equals(lineId, that.lineId) &&
        Objects.equals(standardNm, that.standardNm) &&
        Objects.equals(standardVal, that.standardVal) &&
        Objects.equals(valDataType, that.valDataType) &&
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
        .hash(standardId, lineId, standardNm, standardVal, valDataType, plantId, description, useYn,
            createDt, createUserId, updateDt, updateUserId, api, tid);
  }
}
