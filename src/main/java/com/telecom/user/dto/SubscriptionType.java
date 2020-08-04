package com.telecom.user.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Specifies how the service is paid (prepaid, postpaid, etc)
 */
public enum SubscriptionType {
  
  PREPAID("prepaid"),
  
  POSTPAID("postpaid"),
  
  CONTROL("control"),
  
  HYBRID("hybrid");

  private String value;

  SubscriptionType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SubscriptionType fromValue(String text) {
    for (SubscriptionType b : SubscriptionType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

