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
@Table(name = "CM_PRODUCT_M", schema = "dbo")
@IdClass(CmProductMEntityPK.class)
public class CmProductMEntity {

  private String productId;
  private String productNm;
  private String productClsId;
  private String productSpec;
  private String productType;
  private String productGroup;
  private BigDecimal seq;
  private BigDecimal baseQty;
  private String unitCd;
  private String routeId;
  private String baseLocationId;
  private Integer expiryDay;
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
  @Column(name = "PRODUCT_ID")
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  @Basic
  @Column(name = "PRODUCT_NM")
  public String getProductNm() {
    return productNm;
  }

  public void setProductNm(String productNm) {
    this.productNm = productNm;
  }

  @Basic
  @Column(name = "PRODUCT_CLS_ID")
  public String getProductClsId() {
    return productClsId;
  }

  public void setProductClsId(String productClsId) {
    this.productClsId = productClsId;
  }

  @Basic
  @Column(name = "PRODUCT_SPEC")
  public String getProductSpec() {
    return productSpec;
  }

  public void setProductSpec(String productSpec) {
    this.productSpec = productSpec;
  }

  @Basic
  @Column(name = "PRODUCT_TYPE")
  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  @Basic
  @Column(name = "PRODUCT_GROUP")
  public String getProductGroup() {
    return productGroup;
  }

  public void setProductGroup(String productGroup) {
    this.productGroup = productGroup;
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
  @Column(name = "BASE_QTY")
  public BigDecimal getBaseQty() {
    return baseQty;
  }

  public void setBaseQty(BigDecimal baseQty) {
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
  @Column(name = "ROUTE_ID")
  public String getRouteId() {
    return routeId;
  }

  public void setRouteId(String routeId) {
    this.routeId = routeId;
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
  public Integer getExpiryDay() {
    return expiryDay;
  }

  public void setExpiryDay(Integer expiryDay) {
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
    CmProductMEntity that = (CmProductMEntity) o;
    return Objects.equals(productId, that.productId) &&
        Objects.equals(productNm, that.productNm) &&
        Objects.equals(productClsId, that.productClsId) &&
        Objects.equals(productSpec, that.productSpec) &&
        Objects.equals(productType, that.productType) &&
        Objects.equals(productGroup, that.productGroup) &&
        Objects.equals(seq, that.seq) &&
        Objects.equals(baseQty, that.baseQty) &&
        Objects.equals(unitCd, that.unitCd) &&
        Objects.equals(routeId, that.routeId) &&
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
        .hash(productId, productNm, productClsId, productSpec, productType, productGroup, seq,
            baseQty, unitCd, routeId, baseLocationId, expiryDay, ifYn, ifId, plantId, description,
            useYn, createDt, createUserId, updateDt, updateUserId, api, tid);
  }
}
