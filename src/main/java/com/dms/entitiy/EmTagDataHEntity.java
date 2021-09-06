package com.dms.entitiy;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "EM_TAG_DATA_H", schema = "dbo")
public class EmTagDataHEntity {

  private int sourceTbSeq;
  private String tagId;
  private Timestamp eventDt;
  private int val;
  private String defectYn;
  /*private String defectType;*/
  private String productId;
  private BigDecimal usl;
  private BigDecimal ucl;
  private BigDecimal cl;
  private BigDecimal lcl;
  private BigDecimal lsl;
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
  @Column(name = "SOURCE_TB_SEQ")
  public int getSourceTbSeq() {
    return sourceTbSeq;
  }

  public void setSourceTbSeq(int sourceTbSeq) {
    this.sourceTbSeq = sourceTbSeq;
  }

  @Basic
  @Column(name = "TAG_ID")
  public String getTagId() {
    return tagId;
  }

  public void setTagId(String tagId) {
    this.tagId = tagId;
  }

  @Basic
  @CreationTimestamp
  @Column(name = "EVENT_DT")
  public Timestamp getEventDt() {
    return eventDt;
  }

  public void setEventDt(Timestamp eventDt) {
    this.eventDt = eventDt;
  }

  @Basic
  @Column(name = "VAL")
  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  /*@Basic
  @Column(name = "DEFECT_YN")
  public String getDefectYn() {
    return defectYn;
  }

  public void setDefectYn(String defectYn) {
    this.defectYn = defectYn;
  }*/

  /*@Basic
  @Column(name = "DEFECT_TYPE")
  public String getDefectType() {
    return defectType;
  }

  public void setDefectType(String defectType) {
    this.defectType = defectType;
  }
*/
  @Basic
  @Column(name = "PRODUCT_ID")
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  @Basic
  @Column(name = "USL")
  public BigDecimal getUsl() {
    return usl;
  }

  public void setUsl(BigDecimal usl) {
    this.usl = usl;
  }

  @Basic
  @Column(name = "UCL")
  public BigDecimal getUcl() {
    return ucl;
  }

  public void setUcl(BigDecimal ucl) {
    this.ucl = ucl;
  }

  @Basic
  @Column(name = "CL")
  public BigDecimal getCl() {
    return cl;
  }

  public void setCl(BigDecimal cl) {
    this.cl = cl;
  }

  @Basic
  @Column(name = "LCL")
  public BigDecimal getLcl() {
    return lcl;
  }

  public void setLcl(BigDecimal lcl) {
    this.lcl = lcl;
  }

  @Basic
  @Column(name = "LSL")
  public BigDecimal getLsl() {
    return lsl;
  }

  public void setLsl(BigDecimal lsl) {
    this.lsl = lsl;
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
    EmTagDataHEntity that = (EmTagDataHEntity) o;
    return sourceTbSeq == that.sourceTbSeq &&
        Objects.equals(tagId, that.tagId) &&
        Objects.equals(eventDt, that.eventDt) &&
        Objects.equals(val, that.val) &&
        /*Objects.equals(defectYn, that.defectYn) &&*/
        /*Objects.equals(defectType, that.defectType) &&*/
        Objects.equals(productId, that.productId) &&
        Objects.equals(usl, that.usl) &&
        Objects.equals(ucl, that.ucl) &&
        Objects.equals(cl, that.cl) &&
        Objects.equals(lcl, that.lcl) &&
        Objects.equals(lsl, that.lsl) &&
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
        .hash(sourceTbSeq, tagId, eventDt, val, productId, usl, ucl, cl, lcl,
            lsl, plantId, description, useYn, createDt, createUserId, updateDt, updateUserId, api,
            tid);
  }
}
