package com.dms.entitiy;


import java.sql.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "CM_POST_FILE_C", schema = "dbo")
@IdClass(CmPostFileCEntityPK.class)
public class CmPostFileCEntity {

  private int fileId;
  private int noticeId;
  private String originFileNm;
  private String saveFileNm;
  private int downloadCnt;
  private int fileSize;
  private String fileExt;
  private String plantId;
  private String description;
  private String useYn;
  private Date createDt;
  private String createUserId;
  private Date updateDt;
  private String updateUserId;
  private String api;
  private String tid;
  private String filePath;

  @Id
  @Column(name = "FILE_ID")
  public int getFileId() {
    return fileId;
  }

  public void setFileId(int fileId) {
    this.fileId = fileId;
  }

  @Id
  @Column(name = "NOTICE_ID")
  public int getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(int noticeId) {
    this.noticeId = noticeId;
  }

  @Basic
  @Column(name = "ORIGIN_FILE_NM")
  public String getOriginFileNm() {
    return originFileNm;
  }

  public void setOriginFileNm(String originFileNm) {
    this.originFileNm = originFileNm;
  }

  @Basic
  @Column(name = "SAVE_FILE_NM")
  public String getSaveFileNm() {
    return saveFileNm;
  }

  public void setSaveFileNm(String saveFileNm) {
    this.saveFileNm = saveFileNm;
  }

  @Basic
  @Column(name = "DOWNLOAD_CNT")
  public int getDownloadCnt() {
    return downloadCnt;
  }

  public void setDownloadCnt(int downloadCnt) {
    this.downloadCnt = downloadCnt;
  }

  @Basic
  @Column(name = "FILE_SIZE")
  public int getFileSize() {
    return fileSize;
  }

  public void setFileSize(int fileSize) {
    this.fileSize = fileSize;
  }

  @Basic
  @Column(name = "FILE_EXT")
  public String getFileExt() {
    return fileExt;
  }

  public void setFileExt(String fileExt) {
    this.fileExt = fileExt;
  }

  @Id
  @Column(name = "PLANT_ID")
  public String getPlantId() {
    return plantId;
  }

  public void setPlantId(String plantId) {
    this.plantId = plantId;
  }

  @Basic
  @Column(name = "DESCRIPTION")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "USE_YN")
  public String getUseYn() {
    return useYn;
  }

  public void setUseYn(String useYn) {
    this.useYn = useYn;
  }

  @Basic
  @Column(name = "CREATE_DT")
  public Date getCreateDt() {
    return createDt;
  }

  public void setCreateDt(Date createDt) {
    this.createDt = createDt;
  }

  @Basic
  @Column(name = "CREATE_USER_ID")
  public String getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(String createUserId) {
    this.createUserId = createUserId;
  }

  @Basic
  @Column(name = "UPDATE_DT")
  public Date getUpdateDt() {
    return updateDt;
  }

  public void setUpdateDt(Date updateDt) {
    this.updateDt = updateDt;
  }

  @Basic
  @Column(name = "UPDATE_USER_ID")
  public String getUpdateUserId() {
    return updateUserId;
  }

  public void setUpdateUserId(String updateUserId) {
    this.updateUserId = updateUserId;
  }

  @Basic
  @Column(name = "API")
  public String getApi() {
    return api;
  }

  public void setApi(String api) {
    this.api = api;
  }

  @Basic
  @Column(name = "TID")
  public String getTid() {
    return tid;
  }

  public void setTid(String tid) {
    this.tid = tid;
  }

  @Basic
  @Column(name = "FILE_PATH")
  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CmPostFileCEntity that = (CmPostFileCEntity) o;
    return fileId == that.fileId &&
        Objects.equals(noticeId, that.noticeId) &&
        Objects.equals(originFileNm, that.originFileNm) &&
        Objects.equals(saveFileNm, that.saveFileNm) &&
        Objects.equals(downloadCnt, that.downloadCnt) &&
        Objects.equals(fileSize, that.fileSize) &&
        Objects.equals(fileExt, that.fileExt) &&
        Objects.equals(plantId, that.plantId) &&
        Objects.equals(description, that.description) &&
        Objects.equals(useYn, that.useYn) &&
        Objects.equals(createDt, that.createDt) &&
        Objects.equals(createUserId, that.createUserId) &&
        Objects.equals(updateDt, that.updateDt) &&
        Objects.equals(updateUserId, that.updateUserId) &&
        Objects.equals(api, that.api) &&
        Objects.equals(tid, that.tid) &&
        Objects.equals(filePath, that.filePath);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(fileId, noticeId, originFileNm, saveFileNm, downloadCnt, fileSize, fileExt, plantId,
            description, useYn, createDt, createUserId, updateDt, updateUserId, api, tid, filePath);
  }
}
