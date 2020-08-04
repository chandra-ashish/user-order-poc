package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Package information
 */
@ApiModel(description = "Package information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class ModelPackage   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("package_id")
  private String packageId = null;

  public ModelPackage name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the package. User Friendly field.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the package. User Friendly field.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ModelPackage packageId(String packageId) {
    this.packageId = packageId;
    return this;
  }

  /**
   * Unique package identifier
   * @return packageId
  **/
  @ApiModelProperty(required = true, value = "Unique package identifier")
  @NotNull


  public String getPackageId() {
    return packageId;
  }

  public void setPackageId(String packageId) {
    this.packageId = packageId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelPackage _package = (ModelPackage) o;
    return Objects.equals(this.name, _package.name) &&
        Objects.equals(this.packageId, _package.packageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, packageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelPackage {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    packageId: ").append(toIndentedString(packageId)).append("\n");
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

