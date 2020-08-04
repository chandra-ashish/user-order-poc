package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Information related to an error when trying to purchase an offer
 */
@ApiModel(description = "Information related to an error when trying to purchase an offer")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class OrderPayment   {
  @JsonProperty("order_id")
  private String orderId = null;

  @JsonProperty("description")
  private String description = null;
  
  @JsonProperty("identifier")
  private String identifier = null;
 
  @JsonProperty("coreelatorId")
  private String coreelatorId = null;
  

  public OrderPayment description(String description) {
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


  public String getOrderId() {
	return orderId;
}

public void setOrderId(String orderId) {
	this.orderId = orderId;
}

public String getIdentifier() {
	return identifier;
}

public void setIdentifier(String identifier) {
	this.identifier = identifier;
}


public String getCoreelatorId() {
	return coreelatorId;
}

public void setCoreelatorId(String coreelatorId) {
	this.coreelatorId = coreelatorId;
}

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderPayment orderError = (OrderPayment) o;
    return Objects.equals(this.orderId, orderError.orderId) &&
    		Objects.equals(this.identifier, orderError.identifier) &&
        Objects.equals(this.description, orderError.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId,identifier, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderPayment {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
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

