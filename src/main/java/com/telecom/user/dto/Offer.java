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
@Table
public class Offer   {
  @PrimaryKey
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("identifiers")
  @Valid
  private List<String> identifiers = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("categories")
  @Valid
  private List<OfferCategory> categories = new ArrayList<OfferCategory>();

  @JsonProperty("start_date")
  private Date startDate = null;

  @JsonProperty("end_date")
  private Date endDate = null;

  @JsonProperty("prices")
  @Valid
  private List<Price> prices = new ArrayList<Price>();

  @JsonProperty("product")
  private OfferedProduct product = null;

  public Offer id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique id of the offer
   * @return id
  **/
  @ApiModelProperty(value = "Unique id of the offer")


  public UUID getId() {
	return id;
}

public void setId(UUID id) {
	this.id = id;
}


  public Offer name(String name) {
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

  public Offer identifiers(List<String> identifiers) {
    this.identifiers = identifiers;
    return this;
  }

  public Offer addIdentifiersItem(String identifiersItem) {
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

  public Offer description(String description) {
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

  public Offer categories(List<OfferCategory> categories) {
    this.categories = categories;
    return this;
  }

  public Offer addCategoriesItem(OfferCategory categoriesItem) {
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

  public Offer startDate(Date startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Time when the offer will be available to the user, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.
   * @return startDate
  **/
  @ApiModelProperty(value = "Time when the offer will be available to the user, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.")

  @Valid

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Offer endDate(Date endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Time when the offer will expire for the user, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.
   * @return endDate
  **/
  @ApiModelProperty(value = "Time when the offer will expire for the user, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.")

  @Valid

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Offer prices(List<Price> prices) {
    this.prices = prices;
    return this;
  }

  public Offer addPricesItem(Price pricesItem) {
    this.prices.add(pricesItem);
    return this;
  }

  /**
   * List of prices for this offer
   * @return prices
  **/
  @ApiModelProperty(required = true, value = "List of prices for this offer")
  @NotNull

  @Valid

  public List<Price> getPrices() {
    return prices;
  }

  public void setPrices(List<Price> prices) {
    this.prices = prices;
  }

  public Offer product(OfferedProduct product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OfferedProduct getProduct() {
    return product;
  }

  public void setProduct(OfferedProduct product) {
    this.product = product;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Offer offer = (Offer) o;
    return Objects.equals(this.id, offer.id) &&
        Objects.equals(this.name, offer.name) &&
        Objects.equals(this.identifiers, offer.identifiers) &&
        Objects.equals(this.description, offer.description) &&
        Objects.equals(this.categories, offer.categories) &&
        Objects.equals(this.startDate, offer.startDate) &&
        Objects.equals(this.endDate, offer.endDate) &&
        Objects.equals(this.prices, offer.prices) &&
        Objects.equals(this.product, offer.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, identifiers, description, categories, startDate, endDate, prices, product);
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
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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

