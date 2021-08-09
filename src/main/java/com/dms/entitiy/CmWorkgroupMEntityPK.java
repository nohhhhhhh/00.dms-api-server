package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmWorkgroupMEntityPK implements Serializable {

  private String workgroupId;
  private String plantId;

  @Column(name = "WORKGROUP_ID")
  @Id
  public String getWorkgroupId() {
    return workgroupId;
  }

  public void setWorkgroupId(String workgroupId) {
    this.workgroupId = workgroupId;
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
    CmWorkgroupMEntityPK that = (CmWorkgroupMEntityPK) o;
    return Objects.equals(workgroupId, that.workgroupId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workgroupId, plantId);
  }
}
