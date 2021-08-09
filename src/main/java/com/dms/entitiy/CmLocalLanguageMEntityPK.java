package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmLocalLanguageMEntityPK implements Serializable {

  private String language;
  private String languageKey;
  private String plantId;

  @Column(name = "LANGUAGE")
  @Id
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Column(name = "LANGUAGE_KEY")
  @Id
  public String getLanguageKey() {
    return languageKey;
  }

  public void setLanguageKey(String languageKey) {
    this.languageKey = languageKey;
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
    CmLocalLanguageMEntityPK that = (CmLocalLanguageMEntityPK) o;
    return Objects.equals(language, that.language) &&
        Objects.equals(languageKey, that.languageKey) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(language, languageKey, plantId);
  }
}
