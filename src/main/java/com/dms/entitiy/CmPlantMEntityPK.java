package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmPlantMEntityPK implements Serializable {

  private String plantId;
  private String siteId;

  @Column(name = "PLANT_ID")
  @Id
  public String getPlantId() {
    return plantId;
  }

  public void setPlantId(String plantId) {
    this.plantId = plantId;
  }

  @Column(name = "SITE_ID")
  @Id
  public String getSiteId() {
    return siteId;
  }

  public void setSiteId(String siteId) {
    this.siteId = siteId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CmPlantMEntityPK that = (CmPlantMEntityPK) o;
    return Objects.equals(plantId, that.plantId) &&
        Objects.equals(siteId, that.siteId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plantId, siteId);
  }
}
