package com.dms.entitiy;

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
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "CM_MATERIAL_M", schema = "dbo")
@IdClass(CmMaterialMEntityPK.class)
public class CmMaterialMEntity {

  private String materialId;
  private String materialNm;
  private String materialClsId;
  private String materialSpec;
  private String materialType;
  private String materialGroup;
  private int seq;
  private int baseQty;
  private String unitCd;
  private String baseLocationId;
  private int expiryDay;
  private String ifYn;
  private String ifId;
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
  @Column(name = "MATERIAL_ID")
  public String getMaterialId() {
    return materialId;
  }

  public void setMaterialId(String materialId) {
    this.materialId = materialId;
  }

  @Basic
  @Column(name = "MATERIAL_NM")
  public String getMaterialNm() {
    return materialNm;
  }

  public void setMaterialNm(String materialNm) {
    this.materialNm = materialNm;
  }

  @Basic
  @Column(name = "MATERIAL_CLS_ID")
  public String getMaterialClsId() {
    return materialClsId;
  }

  public void setMaterialClsId(String materialClsId) {
    this.materialClsId = materialClsId;
  }

  @Basic
  @Column(name = "MATERIAL_SPEC")
  public String getMaterialSpec() {
    return materialSpec;
  }

  public void setMaterialSpec(String materialSpec) {
    this.materialSpec = materialSpec;
  }

  @Basic
  @Column(name = "MATERIAL_TYPE")
  public String getMaterialType() {
    return materialType;
  }

  public void setMaterialType(String materialType) {
    this.materialType = materialType;
  }

  @Basic
  @Column(name = "MATERIAL_GROUP")
  public String getMaterialGroup() {
    return materialGroup;
  }

  public void setMaterialGroup(String materialGroup) {
    this.materialGroup = materialGroup;
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
  @Column(name = "BASE_QTY")
  public int getBaseQty() {
    return baseQty;
  }

  public void setBaseQty(int baseQty) {
    this.baseQty = baseQty;
  }

  @Basic
  @Column(name = "UNIT_CD")
  public String getUnitCd() {
    return unitCd;
  }

  public void setUnitCd(String unitCd) {
    this.unitCd = unitCd;
  }

  @Basic
  @Column(name = "BASE_LOCATION_ID")
  public String getBaseLocationId() {
    return baseLocationId;
  }

  public void setBaseLocationId(String baseLocationId) {
    this.baseLocationId = baseLocationId;
  }

  @Basic
  @Column(name = "EXPIRY_DAY")
  public int getExpiryDay() {
    return expiryDay;
  }

  public void setExpiryDay(int expiryDay) {
    this.expiryDay = expiryDay;
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
  @CreationTimestamp
  @Column(name = "CREATE_DT", insertable = true, updatable = false)
  public Timestamp getCreateDt() {
    return createDt;
  }

  public void setCreateDt(Timestamp createDt) {
    this.createDt = createDt;
  }

  @Basic
  @Column(name = "CREATE_USER_ID", insertable = true, updatable = false)
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
    CmMaterialMEntity that = (CmMaterialMEntity) o;
    return Objects.equals(materialId, that.materialId) &&
        Objects.equals(materialNm, that.materialNm) &&
        Objects.equals(materialClsId, that.materialClsId) &&
        Objects.equals(materialSpec, that.materialSpec) &&
        Objects.equals(materialType, that.materialType) &&
        Objects.equals(materialGroup, that.materialGroup) &&
        Objects.equals(seq, that.seq) &&
        Objects.equals(baseQty, that.baseQty) &&
        Objects.equals(unitCd, that.unitCd) &&
        Objects.equals(baseLocationId, that.baseLocationId) &&
        Objects.equals(expiryDay, that.expiryDay) &&
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
        .hash(materialId, materialNm, materialClsId, materialSpec, materialType, materialGroup, seq,
            baseQty, unitCd, baseLocationId, expiryDay, ifYn, ifId, plantId, description, useYn,
            createDt, createUserId, updateDt, updateUserId, api, tid);
  }
}
