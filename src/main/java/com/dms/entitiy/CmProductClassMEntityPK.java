package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmProductClassMEntityPK implements Serializable {

  private String productClsId;
  private String plantId;

  @Column(name = "PRODUCT_CLS_ID")
  @Id
  public String getProductClsId() {
    return productClsId;
  }

  public void setProductClsId(String productClsId) {
    this.productClsId = productClsId;
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
    CmProductClassMEntityPK that = (CmProductClassMEntityPK) o;
    return Objects.equals(productClsId, that.productClsId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productClsId, plantId);
  }
}
