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
@Table(name = "CM_MATERIAL_CLASS_M", schema = "dbo")
@IdClass(CmMaterialClassMEntityPK.class)
public class CmMaterialClassMEntity {

  private String materialClsId;
  private String materialClsNm;
  private String materialClsType;
  private int seq;
  private String plantId;
  private String description;
  private String useYn;
  private Date createDt;
  private String createUserId;
  private Date updateDt;
  private String updateUserId;
  private String api;
  private String tid;

  @Id
  @Column(name = "MATERIAL_CLS_ID")
  public String getMaterialClsId() {
    return materialClsId;
  }

  public void setMaterialClsId(String materialClsId) {
    this.materialClsId = materialClsId;
  }

  @Basic
  @Column(name = "MATERIAL_CLS_NM")
  public String getMaterialClsNm() {
    return materialClsNm;
  }

  public void setMaterialClsNm(String materialClsNm) {
    this.materialClsNm = materialClsNm;
  }

  @Basic
  @Column(name = "MATERIAL_CLS_TYPE")
  public String getMaterialClsType() {
    return materialClsType;
  }

  public void setMaterialClsType(String materialClsType) {
    this.materialClsType = materialClsType;
  }

  @Basic
  @Column(name = "SEQ")
  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CmMaterialClassMEntity that = (CmMaterialClassMEntity) o;
    return Objects.equals(materialClsId, that.materialClsId) &&
        Objects.equals(materialClsNm, that.materialClsNm) &&
        Objects.equals(materialClsType, that.materialClsType) &&
        Objects.equals(seq, that.seq) &&
        Objects.equals(plantId, that.plantId) &&
        Objects.equals(description, that.description) &&
        Objects.equals(useYn, that.useYn) &&
        Objects.equals(createDt, that.createDt) &&
        Objects.equals(createUserId, that.createUserId) &&
        Objects.equals(updateDt, that.updateDt) &&
        Objects.equals(updateUserId, that.updateUserId) &&
        Objects.equals(api, that.api) &&
        Objects.equals(tid, that.tid);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(materialClsId, materialClsNm, materialClsType, seq, plantId, description, useYn,
            createDt, createUserId, updateDt, updateUserId, api, tid);
  }
}
