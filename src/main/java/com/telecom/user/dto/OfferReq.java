package com.telecom.user.dto;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.telecom.user.dto.OfferCategory;
import com.telecom.user.dto.OfferedProduct;
import com.telecom.user.dto.Price;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Offer object
 */
@ApiModel(description = "Offer object")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")
@Table("offer")
public class OfferReq   {
  @PrimaryKey
  @JsonProperty("id")
  private String id = null;

  @Column("name")
  @JsonProperty("name")
  private String name = null;
  
  @Column("identifiers")
  @JsonProperty("identifiers")
  @Valid
  private List<String> identifiers = null;
  
  @Column("description")
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("categories")
  @Valid
  private List<OfferCategory> categories = new ArrayList<OfferCategory>();

  @Column("start_date")
  @JsonProperty("start_date")
  private String startDate = null;

  @Column("end_date")
  @JsonProperty("end_date")
  private String endDate = null;

  @Column("prices")
  @JsonProperty("prices")
  @Valid
  private List<String> prices = new ArrayList<String>();

  @Column("product_id")
  @JsonProperty("product_id")
  private String product_id = null;

  public OfferReq id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique id of the offer
   * @return id
  **/
  @ApiModelProperty(value = "Unique id of the offer")


  public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}


  public OfferReq name(String name) {
    this.name = name;
    return this;
  }



/**
   * Name of the offer. User Friendly field.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the offer. User Friendly field.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OfferReq identifiers(List<String> identifiers) {
    this.identifiers = identifiers;
    return this;
  }

  public OfferReq addIdentifiersItem(String identifiersItem) {
    if (this.identifiers == null) {
      this.identifiers = new ArrayList<String>();
    }
    this.identifiers.add(identifiersItem);
    return this;
  }

  /**
   * List of user identifiers (e.g. phone_numbers) that can be used to subscribe to the offer
   * @return identifiers
  **/
  @ApiModelProperty(value = "List of user identifiers (e.g. phone_numbers) that can be used to subscribe to the offer")


  public List<String> getIdentifiers() {
    return identifiers;
  }

  public void setIdentifiers(List<String> identifiers) {
    this.identifiers = identifiers;
  }

  public OfferReq description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the offer. User Friendly field.
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description of the offer. User Friendly field.")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OfferReq categories(List<OfferCategory> categories) {
	    this.categories = categories;
	    return this;
	  }

	  public OfferReq addCategoriesItem(OfferCategory categoriesItem) {
	    this.categories.add(categoriesItem);
	    return this;
	  }

	  /**
	   * List of categories for which the offer applies
	   * @return categories
	  **/
	  @ApiModelProperty(required = true, value = "List of categories for which the offer applies")
	  @NotNull

	  @Valid

	  public List<OfferCategory> getCategories() {
	    return categories;
	  }

	  public void setCategories(List<OfferCategory> categories) {
	    this.categories = categories;
	  }

  public OfferReq startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Time when the offer will be available to the user, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.
   * @return startDate
  **/
  @ApiModelProperty(value = "Time when the offer will be available to the user, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.")

  @Valid

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public OfferReq endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Time when the offer will expire for the user, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.
   * @return endDate
  **/
  @ApiModelProperty(value = "Time when the offer will expire for the user, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.")

  @Valid

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public OfferReq prices(List<String> prices) {
    this.prices = prices;
    return this;
  }

  public OfferReq addPricesItem(String pricesItem) {
    this.prices.add(pricesItem);
    return this;
  }

  /**
   * List of prices for this offer
   * @return prices
  **/
  @ApiModelProperty( value = "List of prices for this offer")


  @Valid

  public List<String> getPrices() {
    return prices;
  }

  public void setPrices(List<String> prices) {
    this.prices = prices;
  }

  public OfferReq product_id(String product_id) {
    this.product_id = product_id;
    return this;
  }

  public String getProduct_id() {
	return product_id;
}

public void setProduct_id(String product_id) {
	this.product_id = product_id;
}

/**
   * Get product
   * @return product
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferReq offer = (OfferReq) o;
    return Objects.equals(this.id, offer.id) &&
        Objects.equals(this.name, offer.name) &&
        Objects.equals(this.identifiers, offer.identifiers) &&
        Objects.equals(this.description, offer.description) &&
        Objects.equals(this.categories, offer.categories) &&
        Objects.equals(this.startDate, offer.startDate) &&
        Objects.equals(this.endDate, offer.endDate) &&
        Objects.equals(this.prices, offer.prices) &&
        Objects.equals(this.product_id, offer.product_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, identifiers, description, categories, startDate, endDate, prices, product_id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Offer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    identifiers: ").append(toIndentedString(identifiers)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    prices: ").append(toIndentedString(prices)).append("\n");
    sb.append("    product_id: ").append(toIndentedString(product_id)).append("\n");
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

