package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.telecom.user.dto.Descriptions;
import com.telecom.user.dto.ProductType;
import com.telecom.user.dto.SubscriptionType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Object that model a product definition
 */
@ApiModel(description = "Object that model a product definition")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class Product   {
  @JsonProperty("display_name")
  private String displayName = null;

  @JsonProperty("product_type")
  private ProductType productType = null;

  @JsonProperty("descriptions")
  private Descriptions descriptions = null;

  @JsonProperty("subscription_type")
  private SubscriptionType subscriptionType = null;


  public Product displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Name to be displayed when referring to this product. User Friendly field.
   * @return displayName
  **/
  @ApiModelProperty(required = true, value = "Name to be displayed when referring to this product. User Friendly field.")
  @NotNull


  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public Product productType(ProductType productType) {
    this.productType = productType;
    return this;
  }

  /**
   * Get productType
   * @return productType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ProductType getProductType() {
    return productType;
  }

  public void setProductType(ProductType productType) {
    this.productType = productType;
  }

  public Product descriptions(Descriptions descriptions) {
    this.descriptions = descriptions;
    return this;
  }

  /**
   * Get descriptions
   * @return descriptions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Descriptions getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(Descriptions descriptions) {
    this.descriptions = descriptions;
  }

  public Product subscriptionType(SubscriptionType subscriptionType) {
    this.subscriptionType = subscriptionType;
    return this;
  }

  /**
   * Get subscriptionType
   * @return subscriptionType
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SubscriptionType getSubscriptionType() {
    return subscriptionType;
  }

  public void setSubscriptionType(SubscriptionType subscriptionType) {
    this.subscriptionType = subscriptionType;
  }

 


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.displayName, product.displayName) &&
        Objects.equals(this.productType, product.productType) &&
        Objects.equals(this.descriptions, product.descriptions) &&
        Objects.equals(this.subscriptionType, product.subscriptionType) ;

  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, productType, descriptions, subscriptionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    descriptions: ").append(toIndentedString(descriptions)).append("\n");
    sb.append("    subscriptionType: ").append(toIndentedString(subscriptionType)).append("\n");

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

