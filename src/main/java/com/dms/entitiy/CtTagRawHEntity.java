package com.dms.entitiy;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CT_TAG_RAW_H", schema = "dbo.CignDB")
public class CtTagRawHEntity {

  private int eventSequence;
  private Timestamp eventTime;
  private String eventName;
  private String itemIdentity;
  private BigDecimal itemValue;
  private String description;
  private String usable;
  private Timestamp transactionTime;
  private String transactionName;

  @Id
  @Column(name = "EventSequence")
  public int getEventSequence() {
    return eventSequence;
  }

  public void setEventSequence(int eventSequence) {
    this.eventSequence = eventSequence;
  }

  @Basic
  @Column(name = "EventTime")
  public Timestamp getEventTime() {
    return eventTime;
  }

  public void setEventTime(Timestamp eventTime) {
    this.eventTime = eventTime;
  }

  @Basic
  @Column(name = "EventName")
  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  @Basic
  @Column(name = "ItemIdentity")
  public String getItemIdentity() {
    return itemIdentity;
  }

  public void setItemIdentity(String itemIdentity) {
    this.itemIdentity = itemIdentity;
  }

  @Basic
  @Column(name = "ItemValue")
  public BigDecimal getItemValue() {
    return itemValue;
  }

  public void setItemValue(BigDecimal itemValue) {
    this.itemValue = itemValue;
  }

  @Basic
  @Column(name = "Description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "Usable")
  public String getUsable() {
    return usable;
  }

  public void setUsable(String usable) {
    this.usable = usable;
  }

  @Basic
  @Column(name = "TransactionTime")
  public Timestamp getTransactionTime() {
    return transactionTime;
  }

  public void setTransactionTime(Timestamp transactionTime) {
    this.transactionTime = transactionTime;
  }

  @Basic
  @Column(name = "TransactionName")
  public String getTransactionName() {
    return transactionName;
  }

  public void setTransactionName(String transactionName) {
    this.transactionName = transactionName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CtTagRawHEntity that = (CtTagRawHEntity) o;
    return eventSequence == that.eventSequence &&
        Objects.equals(eventTime, that.eventTime) &&
        Objects.equals(eventName, that.eventName) &&
        Objects.equals(itemIdentity, that.itemIdentity) &&
        Objects.equals(itemValue, that.itemValue) &&
        Objects.equals(description, that.description) &&
        Objects.equals(usable, that.usable) &&
        Objects.equals(transactionTime, that.transactionTime) &&
        Objects.equals(transactionName, that.transactionName);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(eventSequence, eventTime, eventName, itemIdentity, itemValue, description, usable,
            transactionTime, transactionName);
  }
}
