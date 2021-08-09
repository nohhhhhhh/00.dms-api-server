package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmMaterialClassMEntityPK implements Serializable {

  private String materialClsId;
  private String plantId;

  @Column(name = "MATERIAL_CLS_ID")
  @Id
  public String getMaterialClsId() {
    return materialClsId;
  }

  public void setMaterialClsId(String materialClsId) {
    this.materialClsId = materialClsId;
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
    CmMaterialClassMEntityPK that = (CmMaterialClassMEntityPK) o;
    return Objects.equals(materialClsId, that.materialClsId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(materialClsId, plantId);
  }
}
