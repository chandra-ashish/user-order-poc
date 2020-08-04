package com.telecom.user.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.validation.annotation.Validated;

/**
 * Information related to an order
 */
@ApiModel(description = "Information related to an order")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

@Table("users")
public class User   {
	 @PrimaryKey
  @Column("user_id")
  @JsonProperty("user_id")
  private String user_id = null;
  
  @Column("role")
  @JsonProperty("role")
  private String role = null;



  public User userId(String user_id) {
	    this.user_id = user_id;
	    return this;
	  }

	  /**
	   * Id of the purchased offer
	   * @return userId
	  **/
	  @ApiModelProperty(value = "Id of the purchased offer")
   
	  public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
	
  public String getRole() {
	return role;
}



public void setRole(String role) {
	this.role = role;
}

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User order = (User) o;
    return
        Objects.equals(this.user_id, order.user_id) &&
        Objects.equals(this.role, order.role) ;
  }

  


@Override
  public int hashCode() {
    return Objects.hash(user_id, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
  
    sb.append("    userId: ").append(toIndentedString(user_id)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

