package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Money amount
 */
@ApiModel(description = "Money amount")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class MoneyAmount   {
  @JsonProperty("value")
  private Float value = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("tax_included")
  private Boolean taxIncluded = false;

  public MoneyAmount value(Float value) {
    this.value = value;
    return this;
  }

  /**
   * Amount value
   * @return value
  **/
  @ApiModelProperty(required = true, value = "Amount value")
  @NotNull


  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }

  public MoneyAmount currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Currency code in which the amount is expressed. ISO 4217
   * @return currency
  **/
  @ApiModelProperty(required = true, value = "Currency code in which the amount is expressed. ISO 4217")
  @NotNull


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public MoneyAmount taxIncluded(Boolean taxIncluded) {
    this.taxIncluded = taxIncluded;
    return this;
  }

  /**
   * true if the amount includes government taxes
   * @return taxIncluded
  **/
  @ApiModelProperty(value = "true if the amount includes government taxes")


  public Boolean isTaxIncluded() {
    return taxIncluded;
  }

  public void setTaxIncluded(Boolean taxIncluded) {
    this.taxIncluded = taxIncluded;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoneyAmount moneyAmount = (MoneyAmount) o;
    return Objects.equals(this.value, moneyAmount.value) &&
        Objects.equals(this.currency, moneyAmount.currency) &&
        Objects.equals(this.taxIncluded, moneyAmount.taxIncluded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, currency, taxIncluded);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoneyAmount {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    taxIncluded: ").append(toIndentedString(taxIncluded)).append("\n");
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

