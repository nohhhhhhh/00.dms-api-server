package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmUserAccessREntityPK implements Serializable {

  private String userId;
  private String accessId;
  private String plantId;

  @Column(name = "USER_ID")
  @Id
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Column(name = "ACCESS_ID")
  @Id
  public String getAccessId() {
    return accessId;
  }

  public void setAccessId(String accessId) {
    this.accessId = accessId;
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
    CmUserAccessREntityPK that = (CmUserAccessREntityPK) o;
    return Objects.equals(userId, that.userId) &&
        Objects.equals(accessId, that.accessId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, accessId, plantId);
  }
}
