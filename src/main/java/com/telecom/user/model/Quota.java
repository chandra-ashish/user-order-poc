package com.telecom.user.model;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.validation.annotation.Validated;

/**
 * Money amount
 */
@ApiModel(description = "Money amount")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-27T08:22:02.967Z")

@Table("quota")
public class Quota   {
	 @PrimaryKey
	 @Column("id")
  @JsonProperty("id")
  private String id = null;
	 
	@Column("type")
  @JsonProperty("type")
  private String type = null;
  
	@Column("max")
  @JsonProperty("max")
  private Integer max = null;

	@Column("time_bands")
  @JsonProperty("time_bands")
  private List<String> time_bands = null;
	
	@Column("origins")
	  @JsonProperty("origins")
	  private List<String> origins = null;
	
	 @Column("unit")
	  @JsonProperty("unit")
	  private String unit = null;
	 
	 @Column("destinations")
	  @JsonProperty("destinations")
	  private List<String> destinations = null;

	  public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}



  public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Integer getMax() {
			return max;
		}

		public void setMax(Integer max) {
			this.max = max;
		}

		public List<String> getTime_bands() {
			return time_bands;
		}

		public void setTime_bands(List<String> time_bands) {
			this.time_bands = time_bands;
		}

		public List<String> getOrigins() {
			return origins;
		}

		public void setOrigins(List<String> origins) {
			this.origins = origins;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		

public List<String> getDestinations() {
			return destinations;
		}

		public void setDestinations(List<String> destinations) {
			this.destinations = destinations;
		}

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Quota queta = (Quota) o;
    return Objects.equals(this.id, queta.id) &&
        Objects.equals(this.type, queta.type) &&
        Objects.equals(this.max, queta.max) &&
        Objects.equals(this.time_bands, queta.time_bands) &&
        Objects.equals(this.origins, queta.origins) &&
        Objects.equals(this.unit, queta.unit) &&
        Objects.equals(this.destinations, queta.destinations) ;

  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, max,time_bands,origins,unit,destinations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Quota {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    time_bands: ").append(toIndentedString(time_bands)).append("\n");
    sb.append("    origins: ").append(toIndentedString(origins)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    destinations: ").append(toIndentedString(destinations)).append("\n");
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

