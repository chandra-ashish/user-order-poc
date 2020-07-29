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

public class PhoneNumbers   {

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("identifiers")
  @Valid
  private List<String> identifiers = null;

  public PhoneNumbers userId(String userId) {
	    this.userId = userId;
	    return this;
	  }
  
  

  public String getUserId() {
	return userId;
}



public void setUserId(String userId) {
	this.userId = userId;
}



public PhoneNumbers identifiers(List<String> identifiers) {
    this.identifiers = identifiers;
    return this;
  }

  public PhoneNumbers addIdentifiersItem(String identifiersItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneNumbers ph = (PhoneNumbers) o;
    return 
        Objects.equals(this.identifiers, ph.identifiers) &&
        Objects.equals(this.userId, ph.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, identifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneNumbers {\n");
    
    sb.append("    identifiers: ").append(toIndentedString(identifiers)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

