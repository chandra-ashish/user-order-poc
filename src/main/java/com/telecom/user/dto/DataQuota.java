package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.telecom.user.dto.CommonQuota;
import com.telecom.user.dto.Origin;
import com.telecom.user.dto.TimeBand;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Data quota information
 */
@ApiModel(description = "Data quota information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class DataQuota   {
  @JsonProperty("max")
  private BigDecimal max = null;

  @JsonProperty("time_bands")
  @Valid
  private List<TimeBand> timeBands = null;

  @JsonProperty("origins")
  @Valid
  private List<Origin> origins = null;

  /**
   * Unit used on the quota
   */
  public enum UnitEnum {
    BYTE("byte"),
    
    KILOBYTE("kilobyte"),
    
    MEGABYTE("megabyte"),
    
    GIGABYTE("gigabyte");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UnitEnum fromValue(String text) {
      for (UnitEnum b : UnitEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("unit")
  private UnitEnum unit = null;

  public DataQuota max(BigDecimal max) {
    this.max = max;
    return this;
  }

  /**
   * max units allowed by current quota. -1 is interpreted as there is no limit
   * @return max
  **/
  @ApiModelProperty(required = true, value = "max units allowed by current quota. -1 is interpreted as there is no limit")
  @NotNull

  @Valid

  public BigDecimal getMax() {
    return max;
  }

  public void setMax(BigDecimal max) {
    this.max = max;
  }

  public DataQuota timeBands(List<TimeBand> timeBands) {
    this.timeBands = timeBands;
    return this;
  }

  public DataQuota addTimeBandsItem(TimeBand timeBandsItem) {
    if (this.timeBands == null) {
      this.timeBands = new ArrayList<TimeBand>();
    }
    this.timeBands.add(timeBandsItem);
    return this;
  }

  /**
   * Get timeBands
   * @return timeBands
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TimeBand> getTimeBands() {
    return timeBands;
  }

  public void setTimeBands(List<TimeBand> timeBands) {
    this.timeBands = timeBands;
  }

  public DataQuota origins(List<Origin> origins) {
    this.origins = origins;
    return this;
  }

  public DataQuota addOriginsItem(Origin originsItem) {
    if (this.origins == null) {
      this.origins = new ArrayList<Origin>();
    }
    this.origins.add(originsItem);
    return this;
  }

  /**
   * Get origins
   * @return origins
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Origin> getOrigins() {
    return origins;
  }

  public void setOrigins(List<Origin> origins) {
    this.origins = origins;
  }

  public DataQuota unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Unit used on the quota
   * @return unit
  **/
  @ApiModelProperty(required = true, value = "Unit used on the quota")
  @NotNull


  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataQuota dataQuota = (DataQuota) o;
    return Objects.equals(this.max, dataQuota.max) &&
        Objects.equals(this.timeBands, dataQuota.timeBands) &&
        Objects.equals(this.origins, dataQuota.origins) &&
        Objects.equals(this.unit, dataQuota.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(max, timeBands, origins, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataQuota {\n");
    
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    timeBands: ").append(toIndentedString(timeBands)).append("\n");
    sb.append("    origins: ").append(toIndentedString(origins)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

