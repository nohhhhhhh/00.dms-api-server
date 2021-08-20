package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class EmTagClassMEntityPK implements Serializable {

  private String tagClsId;
  private String plantId;

  @Column(name = "TAG_CLS_ID")
  @Id
  public String getTagClsId() {
    return tagClsId;
  }

  public void setTagClsId(String tagClsId) {
    this.tagClsId = tagClsId;
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
    EmTagClassMEntityPK that = (EmTagClassMEntityPK) o;
    return Objects.equals(tagClsId, that.tagClsId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagClsId, plantId);
  }
}
