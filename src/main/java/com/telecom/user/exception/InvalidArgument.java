package com.telecom.user.exception;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * InvalidArgument
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class InvalidArgument   {
  @JsonProperty("message")
  private String message = null;

  /**
   * Client specified an invalid argument, request body or query param.
   */
  public enum CodeEnum {
    INVALID_ARGUMENT("INVALID_ARGUMENT");

    private String value;

    CodeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CodeEnum fromValue(String text) {
      for (CodeEnum b : CodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("code")
  private CodeEnum code = CodeEnum.INVALID_ARGUMENT;

  public InvalidArgument message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A human readable description of what the event represent
   * @return message
  **/
  @ApiModelProperty(required = true, value = "A human readable description of what the event represent")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public InvalidArgument code(CodeEnum code) {
    this.code = code;
    return this;
  }

  /**
   * Client specified an invalid argument, request body or query param.
   * @return code
  **/
  @ApiModelProperty(required = true, value = "Client specified an invalid argument, request body or query param.")
  @NotNull


  public CodeEnum getCode() {
    return code;
  }

  public void setCode(CodeEnum code) {
    this.code = code;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvalidArgument invalidArgument = (InvalidArgument) o;
    return Objects.equals(this.message, invalidArgument.message) &&
        Objects.equals(this.code, invalidArgument.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvalidArgument {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

