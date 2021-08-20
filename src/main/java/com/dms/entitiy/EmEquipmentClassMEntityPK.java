package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class EmEquipmentClassMEntityPK implements Serializable {

  private String equipmentClassId;
  private String plantId;

  @Column(name = "EQUIPMENT_CLASS_ID")
  @Id
  public String getEquipmentClassId() {
    return equipmentClassId;
  }

  public void setEquipmentClassId(String equipmentClassId) {
    this.equipmentClassId = equipmentClassId;
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
    EmEquipmentClassMEntityPK that = (EmEquipmentClassMEntityPK) o;
    return Objects.equals(equipmentClassId, that.equipmentClassId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(equipmentClassId, plantId);
  }
}
