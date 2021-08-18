package com.dms.entitiy;

import java.io.Serializable;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmPostFileCEntityPK implements Serializable {

  private int fileId;
  private int noticeId;
  private String plantId;

  @Column(name = "FILE_ID")
  @Id
  public int getFileId() {
    return fileId;
  }

  public void setFileId(int fileId) {
    this.fileId = fileId;
  }

  @Column(name = "NOTICE_ID")
  @Id
  public int getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(int noticeId) {
    this.noticeId = noticeId;
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
    CmPostFileCEntityPK that = (CmPostFileCEntityPK) o;
    return fileId == that.fileId &&
        Objects.equals(noticeId, that.noticeId) &&
        Objects.equals(plantId, that.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileId, noticeId, plantId);
  }
}
