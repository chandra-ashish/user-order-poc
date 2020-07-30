package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.telecom.user.dto.Origin;
import com.telecom.user.dto.TimeBand;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CommonQuota
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class CommonQuota   {
  @JsonProperty("max")
  private BigDecimal max = null;

  @JsonProperty("time_bands")
  @Valid
  private List<TimeBand> timeBands = null;

  @JsonProperty("origins")
  @Valid
  private List<Origin> origins = null;

  public CommonQuota max(BigDecimal max) {
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

  public CommonQuota timeBands(List<TimeBand> timeBands) {
    this.timeBands = timeBands;
    return this;
  }

  public CommonQuota addTimeBandsItem(TimeBand timeBandsItem) {
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

  public CommonQuota origins(List<Origin> origins) {
    this.origins = origins;
    return this;
  }

  public CommonQuota addOriginsItem(Origin originsItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonQuota commonQuota = (CommonQuota) o;
    return Objects.equals(this.max, commonQuota.max) &&
        Objects.equals(this.timeBands, commonQuota.timeBands) &&
        Objects.equals(this.origins, commonQuota.origins);
  }

  @Override
  public int hashCode() {
    return Objects.hash(max, timeBands, origins);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonQuota {\n");
    
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    timeBands: ").append(toIndentedString(timeBands)).append("\n");
    sb.append("    origins: ").append(toIndentedString(origins)).append("\n");
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

