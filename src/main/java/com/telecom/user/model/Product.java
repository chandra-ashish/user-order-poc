package com.telecom.user.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Object that model a product definition
 */
@ApiModel(description = "Object that model a product definition")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")
@Table
public class Product   {
  @PrimaryKey
  @Id
  @Column("product_id")
 @JsonProperty("product_id")
 private String product_id = null;
  
  @Column("display_name")
  @JsonProperty("display_name")
  private String displayName = null;
  
  @Column("product_type")
  @JsonProperty("product_type")
  private String productType = null;
 
  @Column("descriptions")
  @JsonProperty("descriptions")
  private Map<String ,String> descriptions = null;

  @Column("subscription_type")
  @JsonProperty("subscription_type")
  private String subscriptionType = null;
  
  @Column("quota")
  @JsonProperty("quotaIds")
  private List<String>  quotaIds= null;

  @Column("packages")
  @JsonProperty("packages")
  private Map<String ,String> packages = null;

  
  public Product product_id(String product_id) {
	    this.product_id = product_id;
	    return this;
	  }

	  /**
	   * Name to be displayed when referring to this product. User Friendly field.
	   * @return displayName
	  **/
	  @ApiModelProperty(required = true, value = "Name to be displayed when referring to this product. User Friendly field.")
	  @NotNull

	  public String getProduct_id() {
			return product_id;
		}

		public void setProduct_id(String product_id) {
			this.product_id = product_id;
		}
	

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

  public Product productType(String productType) {
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

  public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

  public Product descriptions(Map<String ,String> descriptions) {
    this.descriptions = descriptions;
    return this;
  }

  

/**
   * Get descriptions
   * @return descriptions
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Map<String, String> getDescriptions() {
	return descriptions;
}

public void setDescriptions(Map<String, String> descriptions) {
	this.descriptions = descriptions;
}

  public Product subscriptionType(String subscriptionType) {
    this.subscriptionType = subscriptionType;
    return this;
  }


/**
   * Get subscriptionType
   * @return subscriptionType
  **/
  @ApiModelProperty(value = "")

  @Valid


  public String getSubscriptionType() {
	return subscriptionType;
}

public void setSubscriptionType(String subscriptionType) {
	this.subscriptionType = subscriptionType;
}
 


  public List<String> getQuotaIds() {
	return quotaIds;
}

public void setQuotaIds(List<String> quotaIds) {
	this.quotaIds = quotaIds;
}

public Map<String, String> getPackages() {
	return packages;
}

public void setPackages(Map<String, String> packages) {
	this.packages = packages;
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

