package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.telecom.user.dto.Destination;
import com.telecom.user.dto.Origin;
import com.telecom.user.dto.TimeBand;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Voice quota information
 */
@ApiModel(description = "Voice quota information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")
@JsonInclude(Include.NON_NULL)
public class VoiceQuota   {
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
    SECOND("second"),
    
    MINUTE("minute"),
    
    HOUR("hour");

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

  @JsonProperty("destinations")
  @Valid
  private List<Destination> destinations = null;

  public VoiceQuota max(BigDecimal max) {
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

  public VoiceQuota timeBands(List<TimeBand> timeBands) {
    this.timeBands = timeBands;
    return this;
  }

  public VoiceQuota addTimeBandsItem(TimeBand timeBandsItem) {
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

  public VoiceQuota origins(List<Origin> origins) {
    this.origins = origins;
    return this;
  }

  public VoiceQuota addOriginsItem(Origin originsItem) {
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

  public VoiceQuota unit(UnitEnum unit) {
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

  public VoiceQuota destinations(List<Destination> destinations) {
    this.destinations = destinations;
    return this;
  }

  public VoiceQuota addDestinationsItem(Destination destinationsItem) {
    if (this.destinations == null) {
      this.destinations = new ArrayList<Destination>();
    }
    this.destinations.add(destinationsItem);
    return this;
  }

  /**
   * Get destinations
   * @return destinations
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Destination> getDestinations() {
    return destinations;
  }

  public void setDestinations(List<Destination> destinations) {
    this.destinations = destinations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoiceQuota voiceQuota = (VoiceQuota) o;
    return Objects.equals(this.max, voiceQuota.max) &&
        Objects.equals(this.timeBands, voiceQuota.timeBands) &&
        Objects.equals(this.origins, voiceQuota.origins) &&
        Objects.equals(this.unit, voiceQuota.unit) &&
        Objects.equals(this.destinations, voiceQuota.destinations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(max, timeBands, origins, unit, destinations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoiceQuota {\n");
    
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    timeBands: ").append(toIndentedString(timeBands)).append("\n");
    sb.append("    origins: ").append(toIndentedString(origins)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    destinations: ").append(toIndentedString(destinations)).append("\n");
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

