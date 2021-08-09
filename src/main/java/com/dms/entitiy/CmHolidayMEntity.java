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
@Table(name = "CM_HOLIDAY_M", schema = "dbo")
@IdClass(CmHolidayMEntityPK.class)
public class CmHolidayMEntity {

  private String year;
  private String month;
  private String day;
  private String lunarYn;
  private String holidayNm;
  private String repeatYn;
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
  @Column(name = "YEAR")
  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  @Id
  @Column(name = "MONTH")
  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  @Id
  @Column(name = "DAY")
  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  @Id
  @Column(name = "LUNAR_YN")
  public String getLunarYn() {
    return lunarYn;
  }

  public void setLunarYn(String lunarYn) {
    this.lunarYn = lunarYn;
  }

  @Basic
  @Column(name = "HOLIDAY_NM")
  public String getHolidayNm() {
    return holidayNm;
  }

  public void setHolidayNm(String holidayNm) {
    this.holidayNm = holidayNm;
  }

  @Basic
  @Column(name = "REPEAT_YN")
  public String getRepeatYn() {
    return repeatYn;
  }

  public void setRepeatYn(String repeatYn) {
    this.repeatYn = repeatYn;
  }

  @Basic
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
    CmHolidayMEntity that = (CmHolidayMEntity) o;
    return Objects.equals(year, that.year) &&
        Objects.equals(month, that.month) &&
        Objects.equals(day, that.day) &&
        Objects.equals(lunarYn, that.lunarYn) &&
        Objects.equals(holidayNm, that.holidayNm) &&
        Objects.equals(repeatYn, that.repeatYn) &&
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
        .hash(year, month, day, lunarYn, holidayNm, repeatYn, plantId, description, useYn, createDt,
            createUserId, updateDt, updateUserId, api, tid);
  }
}
