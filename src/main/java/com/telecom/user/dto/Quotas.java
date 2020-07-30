package com.telecom.user.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.telecom.user.dto.DataQuota;
import com.telecom.user.dto.SmsQuota;
import com.telecom.user.dto.VoiceQuota;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * It applies for product_type mobile, value_added_service and bolt-on, and provides information on available data, voice and sms quota
 */
@ApiModel(description = "It applies for product_type mobile, value_added_service and bolt-on, and provides information on available data, voice and sms quota")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

public class Quotas   {
  @JsonProperty("data")
  @Valid
  private List<DataQuota> data = null;

  @JsonProperty("voice")
  @Valid
  private List<VoiceQuota> voice = null;

  @JsonProperty("sms")
  @Valid
  private List<SmsQuota> sms = null;

  public Quotas data(List<DataQuota> data) {
    this.data = data;
    return this;
  }

  public Quotas addDataItem(DataQuota dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<DataQuota>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * list of data quotas associated to this product
   * @return data
  **/
  @ApiModelProperty(value = "list of data quotas associated to this product")

  @Valid

  public List<DataQuota> getData() {
    return data;
  }

  public void setData(List<DataQuota> data) {
    this.data = data;
  }

  public Quotas voice(List<VoiceQuota> voice) {
    this.voice = voice;
    return this;
  }

  public Quotas addVoiceItem(VoiceQuota voiceItem) {
    if (this.voice == null) {
      this.voice = new ArrayList<VoiceQuota>();
    }
    this.voice.add(voiceItem);
    return this;
  }

  /**
   * list of voice quotas associated to this product
   * @return voice
  **/
  @ApiModelProperty(value = "list of voice quotas associated to this product")

  @Valid

  public List<VoiceQuota> getVoice() {
    return voice;
  }

  public void setVoice(List<VoiceQuota> voice) {
    this.voice = voice;
  }

  public Quotas sms(List<SmsQuota> sms) {
    this.sms = sms;
    return this;
  }

  public Quotas addSmsItem(SmsQuota smsItem) {
    if (this.sms == null) {
      this.sms = new ArrayList<SmsQuota>();
    }
    this.sms.add(smsItem);
    return this;
  }

  /**
   * list of SMS quotas associated to this product
   * @return sms
  **/
  @ApiModelProperty(value = "list of SMS quotas associated to this product")

  @Valid

  public List<SmsQuota> getSms() {
    return sms;
  }

  public void setSms(List<SmsQuota> sms) {
    this.sms = sms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Quotas quotas = (Quotas) o;
    return Objects.equals(this.data, quotas.data) &&
        Objects.equals(this.voice, quotas.voice) &&
        Objects.equals(this.sms, quotas.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, voice, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Quotas {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    voice: ").append(toIndentedString(voice)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
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

