package com.telecom.user.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Money amount
 */
@ApiModel(description = "Money amount")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

@Table("money")
public class Money   {
	 @PrimaryKey
	 @Column("id")
  @JsonProperty("id")
  private String id = null;
	 
	@Column("value")
  @JsonProperty("value")
  private Float value = null;
  
	@Column("currency")
  @JsonProperty("currency")
  private String currency = null;

	@Column("tax_included")
  @JsonProperty("tax_included")
  private Boolean taxIncluded = false;

	  public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

public Money value(Float value) {
    this.value = value;
    return this;
  }

  /**
   * Amount value
   * @return value
   * 
   * 
  **/
  @ApiModelProperty(required = true, value = "Amount value")
  @NotNull


  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }

  public Money currency(String currency) {
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

  public Money taxIncluded(Boolean taxIncluded) {
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
    Money moneyAmount = (Money) o;
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

