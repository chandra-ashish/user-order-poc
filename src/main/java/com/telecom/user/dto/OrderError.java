package com.telecom.user.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information related to an error when trying to purchase an offer
 */
@ApiModel(description = "Information related to an error when trying to purchase an offer")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class OrderError   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("description")
  private String description = null;

  public OrderError code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Error code produces when trying to purchase an offer
   * @return code
  **/
  @ApiModelProperty(required = true, value = "Error code produces when trying to purchase an offer")
  @NotNull


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public OrderError description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Message information related to the error when trying to purchase an offer. User Friendly field.
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Message information related to the error when trying to purchase an offer. User Friendly field.")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderError orderError = (OrderError) o;
    return Objects.equals(this.code, orderError.code) &&
        Objects.equals(this.description, orderError.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderError {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

