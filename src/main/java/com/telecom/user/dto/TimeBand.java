package com.telecom.user.dto;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Timebands when the quota applies
 */
public enum TimeBand {
  
  DAY("day"),
  
  NIGHT("night"),
  
  MORNING("morning"),
  
  EVENING("evening"),
  
  WEEKENDS("weekends"),
  
  WORKDAYS("workdays"),
  
  ALL("all");

  private String value;

  TimeBand(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TimeBand fromValue(String text) {
    for (TimeBand b : TimeBand.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

