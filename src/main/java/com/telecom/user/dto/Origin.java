package com.telecom.user.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Origin for which the quota applies
 */
public enum Origin {
  
  HOME("home"),
  
  ROAMING("roaming"),
  
  EU("EU");

  private String value;

  Origin(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Origin fromValue(String text) {
    for (Origin b : Origin.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

