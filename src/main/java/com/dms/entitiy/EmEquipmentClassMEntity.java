package com.dms.entitiy;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "EM_EQUIPMENT_CLASS_M", schema = "dbo")
@IdClass(EmEquipmentClassMEntityPK.class)
public class EmEquipmentClassMEntity {

  private String equipmentClassId;
  private String equipmentClassNm;
  private String equipmentClassType;
  private BigDecimal seq;
  private String plantId;
  private String description;
  private String useYn;
  private Timestamp createDt;
  private String createUserId;
  private Timestamp updateDt;
  private String updateUserId;
  private String api;
  private String tid;

  @Id
  @Column(name = "EQUIPMENT_CLASS_ID")
  public String getEquipmentClassId() {
    return equipmentClassId;
  }

  public void setEquipmentClassId(String equipmentClassId) {
    this.equipmentClassId = equipmentClassId;
  }

  @Basic
  @Column(name = "EQUIPMENT_CLASS_NM")
  public String getEquipmentClassNm() {
    return equipmentClassNm;
  }

  public void setEquipmentClassNm(String equipmentClassNm) {
    this.equipmentClassNm = equipmentClassNm;
  }

  @Basic
  @Column(name = "EQUIPMENT_CLASS_TYPE")
  public String getEquipmentClassType() {
    return equipmentClassType;
  }

  public void setEquipmentClassType(String equipmentClassType) {
    this.equipmentClassType = equipmentClassType;
  }

  @Basic
  @Column(name = "SEQ")
  public BigDecimal getSeq() {
    return seq;
  }

  public void setSeq(BigDecimal seq) {
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
  @CreationTimestamp
  @Column(name = "CREATE_DT", insertable = true, updatable = false)
  public Timestamp getCreateDt() {
    return createDt;
  }

  public void setCreateDt(Timestamp createDt) {
    this.createDt = createDt;
  }

  @Basic
  @Column(name = "CREATE_USER_ID", insertable = true, updatable = false)
  public String getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(String createUserId) {
    this.createUserId = createUserId;
  }

  @Basic
  @UpdateTimestamp
  @Column(name = "UPDATE_DT", insertable = false, updatable = true, columnDefinition = "DATETIME(2)")
  public Timestamp getUpdateDt() {
    return updateDt;
  }

  public void setUpdateDt(Timestamp updateDt) {
    this.updateDt = updateDt;
  }

  @Basic
  @Column(name = "UPDATE_USER_ID", insertable = false, updatable = true)
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
    EmEquipmentClassMEntity that = (EmEquipmentClassMEntity) o;
    return Objects.equals(equipmentClassId, that.equipmentClassId) &&
        Objects.equals(equipmentClassNm, that.equipmentClassNm) &&
        Objects.equals(equipmentClassType, that.equipmentClassType) &&
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
        .hash(equipmentClassId, equipmentClassNm, equipmentClassType, seq, plantId, description,
            useYn, createDt, createUserId, updateDt, updateUserId, api, tid);
  }
}
