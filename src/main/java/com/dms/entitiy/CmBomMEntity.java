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
@Table(name = "CM_BOM_M", schema = "dbo")
@IdClass(CmBomMEntityPK.class)
public class CmBomMEntity {

  private String bomId;
  private String bomType;
  private String bomVer;
  private String productId;
  private String materialId;
  private String parentId;
  private BigDecimal qty;
  private String unitCd;
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
  @Column(name = "BOM_ID")
  public String getBomId() {
    return bomId;
  }

  public void setBomId(String bomId) {
    this.bomId = bomId;
  }

  @Basic
  @Column(name = "BOM_TYPE")
  public String getBomType() {
    return bomType;
  }

  public void setBomType(String bomType) {
    this.bomType = bomType;
  }

  @Id
  @Column(name = "BOM_VER")
  public String getBomVer() {
    return bomVer;
  }

  public void setBomVer(String bomVer) {
    this.bomVer = bomVer;
  }

  @Id
  @Column(name = "PRODUCT_ID")
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  @Id
  @Column(name = "MATERIAL_ID")
  public String getMaterialId() {
    return materialId;
  }

  public void setMaterialId(String materialId) {
    this.materialId = materialId;
  }

  @Basic
  @Column(name = "PARENT_ID")
  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  @Basic
  @Column(name = "QTY")
  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  @Basic
  @Column(name = "UNIT_CD")
  public String getUnitCd() {
    return unitCd;
  }

  public void setUnitCd(String unitCd) {
    this.unitCd = unitCd;
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
    CmBomMEntity that = (CmBomMEntity) o;
    return Objects.equals(bomId, that.bomId) &&
        Objects.equals(bomType, that.bomType) &&
        Objects.equals(bomVer, that.bomVer) &&
        Objects.equals(productId, that.productId) &&
        Objects.equals(materialId, that.materialId) &&
        Objects.equals(parentId, that.parentId) &&
        Objects.equals(qty, that.qty) &&
        Objects.equals(unitCd, that.unitCd) &&
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
        .hash(bomId, bomType, bomVer, productId, materialId, parentId, qty, unitCd, plantId,
            description, useYn, createDt, createUserId, updateDt, updateUserId, api, tid);
  }
}
