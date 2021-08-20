package com.dms.entitiy;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "EM_TAG_M", schema = "dbo")
@IdClass(EmTagMEntityPK.class)
public class EmTagMEntity {

  private String tagId;
  private String tagNm;
  private String tagClsId;
  private String tagParentId;
  private String tagType;
  private String tagAttr;
  private String equipmentId;
  private String unitId;
  private BigDecimal decimalPt;
  private String ctqYn;
  private String weightYn;
  private String displayYn;
  private String manualYn;
  private String summaryYn;
  private String controlYn;
  private String commYn;
  private String commWebsckIp;
  private BigDecimal commWebsckPort;
  private String commWebsckNm;
  private String commType;
  private String commTagId;
  private String commTagAddr;
  private BigDecimal commScaleVal;
  private String commReverseYn;
  private String chartType;
  private String tableId;
  private BigDecimal seq;
  private String plantId;
  private String description;
  private String useYn;
  private Timestamp createDt;
  private String createUserId;
  private Timestamp updateDt;
  private String updateUserId;
  private String api;
  private String tid;

  @Id
  @Column(name = "TAG_ID")
  public String getTagId() {
    return tagId;
  }

  public void setTagId(String tagId) {
    this.tagId = tagId;
  }

  @Basic
  @Column(name = "TAG_NM")
  public String getTagNm() {
    return tagNm;
  }

  public void setTagNm(String tagNm) {
    this.tagNm = tagNm;
  }

  @Basic
  @Column(name = "TAG_CLS_ID")
  public String getTagClsId() {
    return tagClsId;
  }

  public void setTagClsId(String tagClsId) {
    this.tagClsId = tagClsId;
  }

  @Basic
  @Column(name = "TAG_PARENT_ID")
  public String getTagParentId() {
    return tagParentId;
  }

  public void setTagParentId(String tagParentId) {
    this.tagParentId = tagParentId;
  }

  @Basic
  @Column(name = "TAG_TYPE")
  public String getTagType() {
    return tagType;
  }

  public void setTagType(String tagType) {
    this.tagType = tagType;
  }

  @Basic
  @Column(name = "TAG_ATTR")
  public String getTagAttr() {
    return tagAttr;
  }

  public void setTagAttr(String tagAttr) {
    this.tagAttr = tagAttr;
  }

  @Basic
  @Column(name = "EQUIPMENT_ID")
  public String getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(String equipmentId) {
    this.equipmentId = equipmentId;
  }

  @Basic
  @Column(name = "UNIT_ID")
  public String getUnitId() {
    return unitId;
  }

  public void setUnitId(String unitId) {
    this.unitId = unitId;
  }

  @Basic
  @Column(name = "DECIMAL_PT")
  public BigDecimal getDecimalPt() {
    return decimalPt;
  }

  public void setDecimalPt(BigDecimal decimalPt) {
    this.decimalPt = decimalPt;
  }

  @Basic
  @Column(name = "CTQ_YN")
  public String getCtqYn() {
    return ctqYn;
  }

  public void setCtqYn(String ctqYn) {
    this.ctqYn = ctqYn;
  }

  @Basic
  @Column(name = "WEIGHT_YN")
  public String getWeightYn() {
    return weightYn;
  }

  public void setWeightYn(String weightYn) {
    this.weightYn = weightYn;
  }

  @Basic
  @Column(name = "DISPLAY_YN")
  public String getDisplayYn() {
    return displayYn;
  }

  public void setDisplayYn(String displayYn) {
    this.displayYn = displayYn;
  }

  @Basic
  @Column(name = "MANUAL_YN")
  public String getManualYn() {
    return manualYn;
  }

  public void setManualYn(String manualYn) {
    this.manualYn = manualYn;
  }

  @Basic
  @Column(name = "SUMMARY_YN")
  public String getSummaryYn() {
    return summaryYn;
  }

  public void setSummaryYn(String summaryYn) {
    this.summaryYn = summaryYn;
  }

  @Basic
  @Column(name = "CONTROL_YN")
  public String getControlYn() {
    return controlYn;
  }

  public void setControlYn(String controlYn) {
    this.controlYn = controlYn;
  }

  @Basic
  @Column(name = "COMM_YN")
  public String getCommYn() {
    return commYn;
  }

  public void setCommYn(String commYn) {
    this.commYn = commYn;
  }

  @Basic
  @Column(name = "COMM_WEBSCK_IP")
  public String getCommWebsckIp() {
    return commWebsckIp;
  }

  public void setCommWebsckIp(String commWebsckIp) {
    this.commWebsckIp = commWebsckIp;
  }

  @Basic
  @Column(name = "COMM_WEBSCK_PORT")
  public BigDecimal getCommWebsckPort() {
    return commWebsckPort;
  }

  public void setCommWebsckPort(BigDecimal commWebsckPort) {
    this.commWebsckPort = commWebsckPort;
  }

  @Basic
  @Column(name = "COMM_WEBSCK_NM")
  public String getCommWebsckNm() {
    return commWebsckNm;
  }

  public void setCommWebsckNm(String commWebsckNm) {
    this.commWebsckNm = commWebsckNm;
  }

  @Basic
  @Column(name = "COMM_TYPE")
  public String getCommType() {
    return commType;
  }

  public void setCommType(String commType) {
    this.commType = commType;
  }

  @Basic
  @Column(name = "COMM_TAG_ID")
  public String getCommTagId() {
    return commTagId;
  }

  public void setCommTagId(String commTagId) {
    this.commTagId = commTagId;
  }

  @Basic
  @Column(name = "COMM_TAG_ADDR")
  public String getCommTagAddr() {
    return commTagAddr;
  }

  public void setCommTagAddr(String commTagAddr) {
    this.commTagAddr = commTagAddr;
  }

  @Basic
  @Column(name = "COMM_SCALE_VAL")
  public BigDecimal getCommScaleVal() {
    return commScaleVal;
  }

  public void setCommScaleVal(BigDecimal commScaleVal) {
    this.commScaleVal = commScaleVal;
  }

  @Basic
  @Column(name = "COMM_REVERSE_YN")
  public String getCommReverseYn() {
    return commReverseYn;
  }

  public void setCommReverseYn(String commReverseYn) {
    this.commReverseYn = commReverseYn;
  }

  @Basic
  @Column(name = "CHART_TYPE")
  public String getChartType() {
    return chartType;
  }

  public void setChartType(String chartType) {
    this.chartType = chartType;
  }

  @Basic
  @Column(name = "TABLE_ID")
  public String getTableId() {
    return tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  @Basic
  @Column(name = "SEQ")
  public BigDecimal getSeq() {
    return seq;
  }

  public void setSeq(BigDecimal seq) {
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
  @Column(name = "USE_YN")
  public String getUseYn() {
    return useYn;
  }

  public void setUseYn(String useYn) {
    this.useYn = useYn;
  }

  @Basic
  @CreationTimestamp
  @Column(name = "CREATE_DT", insertable = true, updatable = false, columnDefinition = "DATETIME(2)")
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
  @UpdateTimestamp
  @Column(name = "UPDATE_DT", insertable = false, updatable = true, columnDefinition = "DATETIME(2)")
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
    EmTagMEntity that = (EmTagMEntity) o;
    return Objects.equals(tagId, that.tagId) &&
        Objects.equals(tagNm, that.tagNm) &&
        Objects.equals(tagClsId, that.tagClsId) &&
        Objects.equals(tagParentId, that.tagParentId) &&
        Objects.equals(tagType, that.tagType) &&
        Objects.equals(tagAttr, that.tagAttr) &&
        Objects.equals(equipmentId, that.equipmentId) &&
        Objects.equals(unitId, that.unitId) &&
        Objects.equals(decimalPt, that.decimalPt) &&
        Objects.equals(ctqYn, that.ctqYn) &&
        Objects.equals(weightYn, that.weightYn) &&
        Objects.equals(displayYn, that.displayYn) &&
        Objects.equals(manualYn, that.manualYn) &&
        Objects.equals(summaryYn, that.summaryYn) &&
        Objects.equals(controlYn, that.controlYn) &&
        Objects.equals(commYn, that.commYn) &&
        Objects.equals(commWebsckIp, that.commWebsckIp) &&
        Objects.equals(commWebsckPort, that.commWebsckPort) &&
        Objects.equals(commWebsckNm, that.commWebsckNm) &&
        Objects.equals(commType, that.commType) &&
        Objects.equals(commTagId, that.commTagId) &&
        Objects.equals(commTagAddr, that.commTagAddr) &&
        Objects.equals(commScaleVal, that.commScaleVal) &&
        Objects.equals(commReverseYn, that.commReverseYn) &&
        Objects.equals(chartType, that.chartType) &&
        Objects.equals(tableId, that.tableId) &&
        Objects.equals(seq, that.seq) &&
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
        .hash(tagId, tagNm, tagClsId, tagParentId, tagType, tagAttr, equipmentId, unitId, decimalPt,
            ctqYn, weightYn, displayYn, manualYn, summaryYn, controlYn, commYn, commWebsckIp,
            commWebsckPort, commWebsckNm, commType, commTagId, commTagAddr, commScaleVal,
            commReverseYn, chartType, tableId, seq, plantId, description, useYn, createDt,
            createUserId, updateDt, updateUserId, api, tid);
  }
}
