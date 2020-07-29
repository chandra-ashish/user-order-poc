package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.telecom.user.dto.MoneyAmount;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Price information
 */
@ApiModel(description = "Price information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class Price   {
  @JsonProperty("description")
  private String description = null;

  /**
   * Type of the price
   */
  public enum TypeEnum {
    RECURRING("recurring"),
    
    USAGE("usage"),
    
    ONE_OFF("one-off");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = TypeEnum.RECURRING;

  @JsonProperty("recurring_period")
  private String recurringPeriod = null;

  @JsonProperty("period_duration")
  private String periodDuration = null;

  @JsonProperty("amount")
  private MoneyAmount amount = null;

  @JsonProperty("tax")
  private Float tax = null;

  public Price description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the price. User Friendly field.
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description of the price. User Friendly field.")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Price type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the price
   * @return type
  **/
  @ApiModelProperty(required = true, value = "Type of the price")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Price recurringPeriod(String recurringPeriod) {
    this.recurringPeriod = recurringPeriod;
    return this;
  }

  /**
   * Period between charge of the price. Applies when type equals recurring.  Additional to pre-defined values of daily, weekly, monthly, yearly, any indication of number of days or hours is possible, with format {x}-days or {x}-hours (e.g.: 7-days or 24-hours).
   * @return recurringPeriod
  **/
  @ApiModelProperty(value = "Period between charge of the price. Applies when type equals recurring.  Additional to pre-defined values of daily, weekly, monthly, yearly, any indication of number of days or hours is possible, with format {x}-days or {x}-hours (e.g.: 7-days or 24-hours).")

@Pattern(regexp="^(daily|weekly|monthly|yearly|\\d{1,4}-(days|hours))$") 
  public String getRecurringPeriod() {
    return recurringPeriod;
  }

  public void setRecurringPeriod(String recurringPeriod) {
    this.recurringPeriod = recurringPeriod;
  }

  public Price periodDuration(String periodDuration) {
    this.periodDuration = periodDuration;
    return this;
  }

  /**
   * Period for which the product will be subscribed. It does not mean that offer is available for indicated period, it means that the product will be acquired and will last for indicated period. Applies when type equals one-off or usage. For backwards compatibility, in case of recurring prices, recurring_period param is used instead.  Additional to pre-defined values of day, week, month, year, any indication of number of days or hours is possible, with format {x}-days or {x}-hours (e.g.: 7-days or 24-hours).
   * @return periodDuration
  **/
  @ApiModelProperty(value = "Period for which the product will be subscribed. It does not mean that offer is available for indicated period, it means that the product will be acquired and will last for indicated period. Applies when type equals one-off or usage. For backwards compatibility, in case of recurring prices, recurring_period param is used instead.  Additional to pre-defined values of day, week, month, year, any indication of number of days or hours is possible, with format {x}-days or {x}-hours (e.g.: 7-days or 24-hours).")

@Pattern(regexp="^(day|week|month|year|\\d{1,4}-(days|hours))$") 
  public String getPeriodDuration() {
    return periodDuration;
  }

  public void setPeriodDuration(String periodDuration) {
    this.periodDuration = periodDuration;
  }

  public Price amount(MoneyAmount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public MoneyAmount getAmount() {
    return amount;
  }

  public void setAmount(MoneyAmount amount) {
    this.amount = amount;
  }

  public Price tax(Float tax) {
    this.tax = tax;
    return this;
  }

  /**
   * porcentage factor of the taxes applied
   * @return tax
  **/
  @ApiModelProperty(required = true, value = "porcentage factor of the taxes applied")
  @NotNull


  public Float getTax() {
    return tax;
  }

  public void setTax(Float tax) {
    this.tax = tax;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Price price = (Price) o;
    return Objects.equals(this.description, price.description) &&
        Objects.equals(this.type, price.type) &&
        Objects.equals(this.recurringPeriod, price.recurringPeriod) &&
        Objects.equals(this.periodDuration, price.periodDuration) &&
        Objects.equals(this.amount, price.amount) &&
        Objects.equals(this.tax, price.tax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, type, recurringPeriod, periodDuration, amount, tax);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Price {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    recurringPeriod: ").append(toIndentedString(recurringPeriod)).append("\n");
    sb.append("    periodDuration: ").append(toIndentedString(periodDuration)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
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

