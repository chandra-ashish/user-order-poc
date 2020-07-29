package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information of what offer has to be used to create the order using invoice has payment method
 */
@ApiModel(description = "Information of what offer has to be used to create the order using invoice has payment method")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class CreatePurchaseOrderByPhoneNumberInvoice   {
  @JsonProperty("offer_id")
  private String offerId = null;

  public CreatePurchaseOrderByPhoneNumberInvoice offerId(String offerId) {
    this.offerId = offerId;
    return this;
  }

  /**
   * Id of the offer related to the new order
   * @return offerId
  **/
  @ApiModelProperty(required = true, value = "Id of the offer related to the new order")
  @NotNull


  public String getOfferId() {
    return offerId;
  }

  public void setOfferId(String offerId) {
    this.offerId = offerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePurchaseOrderByPhoneNumberInvoice createPurchaseOrderByPhoneNumberInvoice = (CreatePurchaseOrderByPhoneNumberInvoice) o;
    return Objects.equals(this.offerId, createPurchaseOrderByPhoneNumberInvoice.offerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePurchaseOrderByPhoneNumberInvoice {\n");
    
    sb.append("    offerId: ").append(toIndentedString(offerId)).append("\n");
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

