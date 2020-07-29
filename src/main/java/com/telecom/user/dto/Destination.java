package  com.telecom.user.dto;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Destinations for which the quota applies
 */
public enum Destination {
  
  TELEFONICA("telefonica"),
  
  NON_TELEFONICA("non-telefonica"),
  
  RURAL("rural"),
  
  LOCAL("local"),
  
  REGIONAL("regional"),
  
  NATIONAL("national"),
  
  INTERNATIONAL("international"),
  
  MOBILE("mobile"),
  
  LANDLINE("landline"),
  
  ANY("any");

  private String value;

  Destination(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Destination fromValue(String text) {
    for (Destination b : Destination.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

