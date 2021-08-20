package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class PmProcessClassMEntityPK implements Serializable {

  private String processClsId;
  private String plantId;

  @Column(name = "PROCESS_CLS_ID")
  @Id
  public String getProcessClsId() {
    return processClsId;
  }

  public void setProcessClsId(String processClsId) {
    this.processClsId = processClsId;
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
    PmProcessClassMEntityPK that = (PmProcessClassMEntityPK) o;
    return Objects.equals(processClsId, that.processClsId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processClsId, plantId);
  }
}
