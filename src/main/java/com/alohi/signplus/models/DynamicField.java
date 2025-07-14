package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class DynamicField {

  /**
   * Name of the dynamic field
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Value of the dynamic field
   */
  @JsonProperty("value")
  private JsonNullable<String> value;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getValue() {
    return value.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class DynamicFieldBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public DynamicFieldBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> value = JsonNullable.undefined();

    @JsonProperty("value")
    public DynamicFieldBuilder value(String value) {
      if (value == null) {
        throw new IllegalStateException("value cannot be null");
      }
      this.value = JsonNullable.of(value);
      return this;
    }
  }
}
