package com.telecom.user.model;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.telecom.user.dto.OrderError;
import com.telecom.user.dto.OrderStatus;

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

@Table("phonedetails")
public class Phonenumber   {
	 @PrimaryKey
	 @Column("id")
  @JsonProperty("id")
  private String id = null;

  @Column("user_id")
  @JsonProperty("user_id")
  private String userId = null;
  

  @Column("identifier")
  @JsonProperty("identifier")
  private String identifier = null;

  public Phonenumber id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique id of the order
   * @return id
  **/
  @ApiModelProperty(value = "Unique id of the order")



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Phonenumber userId(String userId) {
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

	 

  

  public Phonenumber identifier(String identifier) {
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

 

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Phonenumber order = (Phonenumber) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.userId, order.userId) &&
        Objects.equals(this.identifier, order.identifier) ;
  }

  


@Override
  public int hashCode() {
    return Objects.hash(id, userId, identifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
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

