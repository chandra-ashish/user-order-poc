package com.telecom.user.model;

import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information related to an order
 */
@ApiModel(description = "Information related to an order")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

@Table("order_detail")
public class Order   {
	 @PrimaryKey
	 @Column("id")
  @JsonProperty("id")
  private String id = null;

  @Column("offer_id")
  @JsonProperty("offer_id")
  private String offerId = null;
  
  @Column("user_id")
  @JsonProperty("user_id")
  private String userId = null;
  
  @Column("product_id")
  @JsonProperty("product_id")
  private String productId = null;

  @Column("identifier")
  @JsonProperty("identifier")
  private String identifier = null;
 
  @Column("creation_date")
  @JsonProperty("creation_date")
  private String creationDate = null;
  
  @Column("order_type")
  @JsonProperty("type")
  private String type = null;

  @Column("status")
  @JsonProperty("status")
  private String status = null;
  
  @Column("error")
  @JsonProperty("error")
  private Map<String ,String> error = null;

  public Order id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique id of the order
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique id of the order")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Order offerId(String offerId) {
    this.offerId = offerId;
    return this;
  }

  /**
   * Id of the purchased offer
   * @return offerId
  **/
  @ApiModelProperty(value = "Id of the purchased offer")


  public String getOfferId() {
    return offerId;
  }

  public void setOfferId(String offerId) {
    this.offerId = offerId;
  }
  
  public Order userId(String userId) {
	    this.userId = userId;
	    return this;
	  }

	  /**
	   * Id of the purchased offer
	   * @return userId
	  **/
	  @ApiModelProperty(value = "Id of the purchased offer")
   
	  public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

	 

  public Order productId(String productId) {
    this.productId = productId;
    return this;
  }

  
/**
   * Id of the subscribed product this order relates to
   * @return productId
  **/
  @ApiModelProperty(value = "Id of the subscribed product this order relates to")


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Order identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * user identifer (e.g. phone number) associated to the order
   * @return identifier
  **/
  @ApiModelProperty(value = "user identifer (e.g. phone number) associated to the order")


  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public Order creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Time when the order was created, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.
   * @return creationDate
  **/
  @ApiModelProperty(required = true, value = "Time when the order was created, in ISO-8601 extended local date format. Time-offset from UTC may be used to match local OB time.")
  @NotNull

  @Valid

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public Order type(String type) {
    this.type = type;
    return this;
  }
  
  /**
   * type of the order
   * @return type
  **/
  @ApiModelProperty(required = true, value = "type of the order")
  @NotNull
  public void setType(String type) {
		this.type = type;
	}
	  public String getType() {
			return type;
		}
  
  public Order status(String status) {
    this.status = status;
    return this;
  }



/**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Order error(Map<String, String> error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  **/
  @ApiModelProperty(value = "")

  @Valid
  public Map<String, String> getError() {
		return error;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}
 


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.offerId, order.offerId) &&
        Objects.equals(this.userId, order.userId) &&
        Objects.equals(this.productId, order.productId) &&
        Objects.equals(this.identifier, order.identifier) &&
        Objects.equals(this.creationDate, order.creationDate) &&
        Objects.equals(this.type, order.type) &&
        Objects.equals(this.status, order.status) &&
        Objects.equals(this.error, order.error);
  }

  


@Override
  public int hashCode() {
    return Objects.hash(id, offerId, userId,productId, identifier, creationDate, type, status, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    offerId: ").append(toIndentedString(offerId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

