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
@Table(name = "PM_PROCESS_M", schema = "dbo")
@IdClass(PmProcessMEntityPK.class)
public class PmProcessMEntity {

  private String processId;
  private String processNm;
  private String processClsId;
  private String processType;
  private BigDecimal seq;
  private String ifYn;
  private String plantId;
  private String description;
  private String useYn;
  private Timestamp createDt;
  private String createUserId;
  private Timestamp updateDt;
  private String updateUserId;
  private String api;
  private String tid;
  private String lotYn;

  @Id
  @Column(name = "PROCESS_ID")
  public String getProcessId() {
    return processId;
  }

  public void setProcessId(String processId) {
    this.processId = processId;
  }

  @Basic
  @Column(name = "PROCESS_NM")
  public String getProcessNm() {
    return processNm;
  }

  public void setProcessNm(String processNm) {
    this.processNm = processNm;
  }

  @Basic
  @Column(name = "PROCESS_CLS_ID")
  public String getProcessClsId() {
    return processClsId;
  }

  public void setProcessClsId(String processClsId) {
    this.processClsId = processClsId;
  }

  @Basic
  @Column(name = "PROCESS_TYPE")
  public String getProcessType() {
    return processType;
  }

  public void setProcessType(String processType) {
    this.processType = processType;
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
  @Column(name = "CREATE_DT", insertable = true, updatable = false, columnDefinition = "DATETIME(2)")
  public Timestamp getCreateDt() {
    return createDt;
  }

  public void setCreateDt(Timestamp createDt) {
    this.createDt = createDt;
  }

  @Basic
  @Column(name = "CREATE_USER_ID", updatable = false)
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

  @Basic
  @Column(name = "LOT_YN")
  public String getLotYn() {
    return lotYn;
  }

  public void setLotYn(String lotYn) {
    this.lotYn = lotYn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PmProcessMEntity that = (PmProcessMEntity) o;
    return Objects.equals(processId, that.processId) &&
        Objects.equals(processNm, that.processNm) &&
        Objects.equals(processClsId, that.processClsId) &&
        Objects.equals(processType, that.processType) &&
        Objects.equals(seq, that.seq) &&
        Objects.equals(ifYn, that.ifYn) &&
        Objects.equals(plantId, that.plantId) &&
        Objects.equals(description, that.description) &&
        Objects.equals(useYn, that.useYn) &&
        Objects.equals(createDt, that.createDt) &&
        Objects.equals(createUserId, that.createUserId) &&
        Objects.equals(updateDt, that.updateDt) &&
        Objects.equals(updateUserId, that.updateUserId) &&
        Objects.equals(api, that.api) &&
        Objects.equals(tid, that.tid) &&
        Objects.equals(lotYn, that.lotYn);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(processId, processNm, processClsId, processType, seq, ifYn, plantId, description,
            useYn,
            createDt, createUserId, updateDt, updateUserId, api, tid, lotYn);
  }
}
