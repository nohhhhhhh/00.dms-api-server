package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class PmProcessEquipmentREntityPK implements Serializable {

  private String processId;
  private String equipmentId;
  private String plantId;

  @Column(name = "PROCESS_ID")
  @Id
  public String getProcessId() {
    return processId;
  }

  public void setProcessId(String processId) {
    this.processId = processId;
  }

  @Column(name = "EQUIPMENT_ID")
  @Id
  public String getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(String equipmentId) {
    this.equipmentId = equipmentId;
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
    PmProcessEquipmentREntityPK that = (PmProcessEquipmentREntityPK) o;
    return Objects.equals(processId, that.processId) &&
        Objects.equals(equipmentId, that.equipmentId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processId, equipmentId, plantId);
  }
}
