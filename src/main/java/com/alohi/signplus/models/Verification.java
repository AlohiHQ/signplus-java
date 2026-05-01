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
public class Verification {

  @JsonProperty("type")
  private JsonNullable<String> type;

  @JsonProperty("value")
  private JsonNullable<String> value;

  @JsonIgnore
  public String getType() {
    return type.orElse(null);
  }

  @JsonIgnore
  public String getValue() {
    return value.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class VerificationBuilder {

    private JsonNullable<String> type = JsonNullable.undefined();

    @JsonProperty("type")
    public VerificationBuilder type(String value) {
      this.type = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> value = JsonNullable.undefined();

    @JsonProperty("value")
    public VerificationBuilder value(String value) {
      this.value = JsonNullable.of(value);
      return this;
    }
  }
}
