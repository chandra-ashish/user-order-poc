package com.telecom.user.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets OrderStatus
 */
public enum OrderStatus {
  
  PENDING("pending"),
  
  CONFIRMED("confirmed"),
  
  REJECTED("rejected");

  private String value;

  OrderStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OrderStatus fromValue(String text) {
    for (OrderStatus b : OrderStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

