package com.dms.entitiy;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "CM_LINE_M", schema = "dbo")
@IdClass(CmLineMEntityPK.class)
public class CmLineMEntity {

  private String lineId;
  private String lineNm;
  private String parentLineId;
  private BigDecimal seq;
  private String pmsYn;
  private String wgtYn;
  private String ifYn;
  private String ifId;
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
  @Column(name = "LINE_ID")
  public String getLineId() {
    return lineId;
  }

  public void setLineId(String lineId) {
    this.lineId = lineId;
  }

  @Basic
  @Column(name = "LINE_NM")
  public String getLineNm() {
    return lineNm;
  }

  public void setLineNm(String lineNm) {
    this.lineNm = lineNm;
  }

  @Basic
  @Column(name = "PARENT_LINE_ID")
  public String getParentLineId() {
    return parentLineId;
  }

  public void setParentLineId(String parentLineId) {
    this.parentLineId = parentLineId;
  }

  @Basic
  @Column(name = "SEQ")
  public BigDecimal getSeq() {
    return seq;
  }

  public void setSeq(BigDecimal seq) {
    this.seq = seq;
  }

  @Basic
  @Column(name = "PMS_YN")
  public String getPmsYn() {
    return pmsYn;
  }

  public void setPmsYn(String pmsYn) {
    this.pmsYn = pmsYn;
  }

  @Basic
  @Column(name = "WGT_YN")
  public String getWgtYn() {
    return wgtYn;
  }

  public void setWgtYn(String wgtYn) {
    this.wgtYn = wgtYn;
  }

  @Basic
  @Column(name = "IF_YN")
  public String getIfYn() {
    return ifYn;
  }

  public void setIfYn(String ifYn) {
    this.ifYn = ifYn;
  }

  @Basic
  @Column(name = "IF_ID")
  public String getIfId() {
    return ifId;
  }

  public void setIfId(String ifId) {
    this.ifId = ifId;
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
    CmLineMEntity that = (CmLineMEntity) o;
    return Objects.equals(lineId, that.lineId) &&
        Objects.equals(lineNm, that.lineNm) &&
        Objects.equals(parentLineId, that.parentLineId) &&
        Objects.equals(seq, that.seq) &&
        Objects.equals(pmsYn, that.pmsYn) &&
        Objects.equals(wgtYn, that.wgtYn) &&
        Objects.equals(ifYn, that.ifYn) &&
        Objects.equals(ifId, that.ifId) &&
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
        .hash(lineId, lineNm, parentLineId, seq, pmsYn, wgtYn, ifYn, ifId, plantId, description,
            useYn, createDt, createUserId, updateDt, updateUserId, api, tid);
  }
}
