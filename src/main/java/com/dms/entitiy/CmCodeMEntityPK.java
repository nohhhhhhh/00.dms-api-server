package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmCodeMEntityPK implements Serializable {

  private String codeClsId;
  private String codeId;
  private String plantId;

  @Column(name = "CODE_CLS_ID")
  @Id
  public String getCodeClsId() {
    return codeClsId;
  }

  public void setCodeClsId(String codeClsId) {
    this.codeClsId = codeClsId;
  }

  @Column(name = "CODE_ID")
  @Id
  public String getCodeId() {
    return codeId;
  }

  public void setCodeId(String codeId) {
    this.codeId = codeId;
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
    CmCodeMEntityPK that = (CmCodeMEntityPK) o;
    return Objects.equals(codeClsId, that.codeClsId) &&
        Objects.equals(codeId, that.codeId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeClsId, codeId, plantId);
  }
}
