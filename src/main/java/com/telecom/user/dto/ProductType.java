package com.telecom.user.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The type of the product
 */
public enum ProductType {
  
  MOBILE("mobile"),
  
  LANDLINE("landline"),
  
  INTERNET("internet"),
  
  IPTV("iptv"),
  
  BUNDLE("bundle"),
  
  DEVICE("device"),
  
  VOUCHER("voucher"),
  
  VALUE_ADDED_SERVICE("value_added_service"),
  
  BOLT_ON("bolt-on"),
  
  DTH("dth"),
  
  STREAMING_TV("streaming_tv");

  private String value;

  ProductType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ProductType fromValue(String text) {
    for (ProductType b : ProductType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

