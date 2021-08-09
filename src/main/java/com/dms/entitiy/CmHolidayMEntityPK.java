package com.dms.entitiy;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class CmHolidayMEntityPK implements Serializable {

  private String year;
  private String month;
  private String day;
  private String lunarYn;

  @Column(name = "YEAR")
  @Id
  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  @Column(name = "MONTH")
  @Id
  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  @Column(name = "DAY")
  @Id
  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  @Column(name = "LUNAR_YN")
  @Id
  public String getLunarYn() {
    return lunarYn;
  }

  public void setLunarYn(String lunarYn) {
    this.lunarYn = lunarYn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CmHolidayMEntityPK that = (CmHolidayMEntityPK) o;
    return Objects.equals(year, that.year) &&
        Objects.equals(month, that.month) &&
        Objects.equals(day, that.day) &&
        Objects.equals(lunarYn, that.lunarYn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(year, month, day, lunarYn);
  }
}
