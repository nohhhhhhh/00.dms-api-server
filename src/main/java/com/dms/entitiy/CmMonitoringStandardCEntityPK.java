package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmMonitoringStandardCEntityPK implements Serializable {

  private String standardId;
  private String lineId;

  @Column(name = "STANDARD_ID")
  @Id
  public String getStandardId() {
    return standardId;
  }

  public void setStandardId(String standardId) {
    this.standardId = standardId;
  }

  @Column(name = "LINE_ID")
  @Id
  public String getLineId() {
    return lineId;
  }

  public void setLineId(String lineId) {
    this.lineId = lineId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CmMonitoringStandardCEntityPK that = (CmMonitoringStandardCEntityPK) o;
    return Objects.equals(standardId, that.standardId) &&
        Objects.equals(lineId, that.lineId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(standardId, lineId);
  }
}
