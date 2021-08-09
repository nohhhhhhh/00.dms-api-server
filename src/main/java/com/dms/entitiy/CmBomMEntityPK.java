package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmBomMEntityPK implements Serializable {

  private String bomId;
  private String bomVer;
  private String productId;
  private String materialId;
  private String plantId;

  @Column(name = "BOM_ID")
  @Id
  public String getBomId() {
    return bomId;
  }

  public void setBomId(String bomId) {
    this.bomId = bomId;
  }

  @Column(name = "BOM_VER")
  @Id
  public String getBomVer() {
    return bomVer;
  }

  public void setBomVer(String bomVer) {
    this.bomVer = bomVer;
  }

  @Column(name = "PRODUCT_ID")
  @Id
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  @Column(name = "MATERIAL_ID")
  @Id
  public String getMaterialId() {
    return materialId;
  }

  public void setMaterialId(String materialId) {
    this.materialId = materialId;
  }

  @Column(name = "PLANT_ID")
  @Id
  public String getPlantId() {
    return plantId;
  }

  public void setPlantId(String plantId) {
    this.plantId = plantId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CmBomMEntityPK that = (CmBomMEntityPK) o;
    return Objects.equals(bomId, that.bomId) &&
        Objects.equals(bomVer, that.bomVer) &&
        Objects.equals(productId, that.productId) &&
        Objects.equals(materialId, that.materialId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bomId, bomVer, productId, materialId, plantId);
  }
}
