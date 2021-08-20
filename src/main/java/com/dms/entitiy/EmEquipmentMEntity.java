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
@Table(name = "EM_EQUIPMENT_M", schema = "dbo")
@IdClass(EmEquipmentMEntityPK.class)
public class EmEquipmentMEntity {

  private String equipmentId;
  private String equipmentNm;
  private String equipmentClassId;
  private String parentEquipmentId;
  private String equipmentType;
  private String equipmentLevel;
  private String lifecycleYn;
  private String lineId;
  private BigDecimal seq;
  private String ifYn;
  private String ifId;
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
  @Column(name = "EQUIPMENT_ID")
  public String getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(String equipmentId) {
    this.equipmentId = equipmentId;
  }

  @Basic
  @Column(name = "EQUIPMENT_NM")
  public String getEquipmentNm() {
    return equipmentNm;
  }

  public void setEquipmentNm(String equipmentNm) {
    this.equipmentNm = equipmentNm;
  }

  @Basic
  @Column(name = "EQUIPMENT_CLASS_ID")
  public String getEquipmentClassId() {
    return equipmentClassId;
  }

  public void setEquipmentClassId(String equipmentClassId) {
    this.equipmentClassId = equipmentClassId;
  }

  @Basic
  @Column(name = "PARENT_EQUIPMENT_ID")
  public String getParentEquipmentId() {
    return parentEquipmentId;
  }

  public void setParentEquipmentId(String parentEquipmentId) {
    this.parentEquipmentId = parentEquipmentId;
  }

  @Basic
  @Column(name = "EQUIPMENT_TYPE")
  public String getEquipmentType() {
    return equipmentType;
  }

  public void setEquipmentType(String equipmentType) {
    this.equipmentType = equipmentType;
  }

  @Basic
  @Column(name = "EQUIPMENT_LEVEL")
  public String getEquipmentLevel() {
    return equipmentLevel;
  }

  public void setEquipmentLevel(String equipmentLevel) {
    this.equipmentLevel = equipmentLevel;
  }

  @Basic
  @Column(name = "LIFECYCLE_YN")
  public String getLifecycleYn() {
    return lifecycleYn;
  }

  public void setLifecycleYn(String lifecycleYn) {
    this.lifecycleYn = lifecycleYn;
  }

  @Basic
  @Column(name = "LINE_ID")
  public String getLineId() {
    return lineId;
  }

  public void setLineId(String lineId) {
    this.lineId = lineId;
  }

  @Basic
  @Column(name = "SEQ")
  public BigDecimal getSeq() {
    return seq;
  }

  public void setSeq(BigDecimal seq) {
    this.seq = seq;
  }

  @Basic
  @Column(name = "IF_YN")
  public String getIfYn() {
    return ifYn;
  }

  public void setIfYn(String ifYn) {
    this.ifYn = ifYn;
  }

  @Basic
  @Column(name = "IF_ID")
  public String getIfId() {
    return ifId;
  }

  public void setIfId(String ifId) {
    this.ifId = ifId;
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
    EmEquipmentMEntity that = (EmEquipmentMEntity) o;
    return Objects.equals(equipmentId, that.equipmentId) &&
        Objects.equals(equipmentNm, that.equipmentNm) &&
        Objects.equals(equipmentClassId, that.equipmentClassId) &&
        Objects.equals(parentEquipmentId, that.parentEquipmentId) &&
        Objects.equals(equipmentType, that.equipmentType) &&
        Objects.equals(equipmentLevel, that.equipmentLevel) &&
        Objects.equals(lifecycleYn, that.lifecycleYn) &&
        Objects.equals(lineId, that.lineId) &&
        Objects.equals(seq, that.seq) &&
        Objects.equals(ifYn, that.ifYn) &&
        Objects.equals(ifId, that.ifId) &&
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
        .hash(equipmentId, equipmentNm, equipmentClassId, parentEquipmentId, equipmentType,
            equipmentLevel, lifecycleYn, lineId, seq, ifYn, ifId, plantId, description, useYn,
            createDt,
            createUserId, updateDt, updateUserId, api, tid);
  }
}
