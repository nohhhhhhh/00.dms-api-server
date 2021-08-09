package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmMenuMEntityPK implements Serializable {

  private String menuId;
  private String plantId;

  @Column(name = "MENU_ID")
  @Id
  public String getMenuId() {
    return menuId;
  }

  public void setMenuId(String menuId) {
    this.menuId = menuId;
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
    CmMenuMEntityPK that = (CmMenuMEntityPK) o;
    return Objects.equals(menuId, that.menuId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(menuId, plantId);
  }
}
