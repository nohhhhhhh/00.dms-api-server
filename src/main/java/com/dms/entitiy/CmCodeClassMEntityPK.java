package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmCodeClassMEntityPK implements Serializable {

  private String codeClsId;
  private String plantId;

  @Column(name = "CODE_CLS_ID")
  @Id
  public String getCodeClsId() {
    return codeClsId;
  }

  public void setCodeClsId(String codeClsId) {
    this.codeClsId = codeClsId;
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
    CmCodeClassMEntityPK that = (CmCodeClassMEntityPK) o;
    return Objects.equals(codeClsId, that.codeClsId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeClsId, plantId);
  }
}
