package com.telecom.user.dto;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.telecom.user.dto.ModelPackage;
import java.util.ArrayList;
import org.springframework.validation.annotation.Validated;

/**
 * It applies only for product_type iptv, dth and streaming_tv; provides information on available TV packages
 */
@ApiModel(description = "It applies only for product_type iptv, dth and streaming_tv; provides information on available TV packages")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class Packages extends ArrayList<ModelPackage>  {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Packages {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

