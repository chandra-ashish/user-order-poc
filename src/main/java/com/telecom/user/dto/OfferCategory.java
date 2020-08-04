package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * category of offer
 */
@ApiModel(description = "category of offer")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

@JsonInclude(Include.NON_NULL)
public class OfferCategory   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("id")
  private String id = null;

  public OfferCategory name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the category.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the category.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OfferCategory description(String description) {
    this.description = description;
    return this;
  }

  /**
   * short description of the category. User Friendly field.
   * @return description
  **/
  @ApiModelProperty(value = "short description of the category. User Friendly field.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OfferCategory id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferCategory offerCategory = (OfferCategory) o;
    return Objects.equals(this.name, offerCategory.name) &&
        Objects.equals(this.description, offerCategory.description) &&
        Objects.equals(this.id, offerCategory.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferCategory {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

