package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Information about the product for displaying purposes.
 */
@ApiModel(description = "Information about the product for displaying purposes.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

@JsonInclude(Include.NON_NULL)
public class Description   {
  @JsonProperty("text")
  private String text = null;

  @JsonProperty("url")
  private String url = null;

  /**
   * Category of the description. This field is used to provide further info about displaying of the description text:  - 'general': Default value for any description without specific category.  - 'dates': Information about dates, related with the life-cycle of the product (e.g: contractual information about renowation conditions)  - 'promotion': Information about product acquisition conditions, such as if special price is being applied and for how long, or if data quota is duplicated during first three months.
   */
  public enum CategoryEnum {
    GENERAL("general"),
    
    DATES("dates"),
    
    PROMOTION("promotion");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String text) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  
  @JsonProperty("category")
  private CategoryEnum category = null;

  public Description text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Text with information about the product. User Friendly field.
   * @return text
  **/
  @ApiModelProperty(required = true, value = "Text with information about the product. User Friendly field.")
  @NotNull


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Description url(String url) {
    this.url = url;
    return this;
  }

  /**
   * HTTPS URL
   * @return url
  **/
  @ApiModelProperty(value = "HTTPS URL")

@Pattern(regexp="^https?://.+$") 
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Description category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * Category of the description. This field is used to provide further info about displaying of the description text:  - 'general': Default value for any description without specific category.  - 'dates': Information about dates, related with the life-cycle of the product (e.g: contractual information about renowation conditions)  - 'promotion': Information about product acquisition conditions, such as if special price is being applied and for how long, or if data quota is duplicated during first three months.
   * @return category
  **/
  @ApiModelProperty(value = "Category of the description. This field is used to provide further info about displaying of the description text:  - 'general': Default value for any description without specific category.  - 'dates': Information about dates, related with the life-cycle of the product (e.g: contractual information about renowation conditions)  - 'promotion': Information about product acquisition conditions, such as if special price is being applied and for how long, or if data quota is duplicated during first three months.")


  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Description description = (Description) o;
    return Objects.equals(this.text, description.text) &&
        Objects.equals(this.url, description.url) &&
        Objects.equals(this.category, description.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, url, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Description {\n");
    
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

