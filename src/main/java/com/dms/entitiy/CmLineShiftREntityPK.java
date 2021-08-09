package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmLineShiftREntityPK implements Serializable {

  private String lineId;
  private String shiftId;
  private String plantId;

  @Column(name = "LINE_ID")
  @Id
  public String getLineId() {
    return lineId;
  }

  public void setLineId(String lineId) {
    this.lineId = lineId;
  }

  @Column(name = "SHIFT_ID")
  @Id
  public String getShiftId() {
    return shiftId;
  }

  public void setShiftId(String shiftId) {
    this.shiftId = shiftId;
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
    CmLineShiftREntityPK that = (CmLineShiftREntityPK) o;
    return Objects.equals(lineId, that.lineId) &&
        Objects.equals(shiftId, that.shiftId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lineId, shiftId, plantId);
  }
}
