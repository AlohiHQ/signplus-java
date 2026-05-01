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
public class SetEnvelopeLegalityLevelRequest {

  @JsonProperty("legality_level")
  private JsonNullable<String> legalityLevel;

  @JsonIgnore
  public String getLegalityLevel() {
    return legalityLevel.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetEnvelopeLegalityLevelRequestBuilder {

    private JsonNullable<String> legalityLevel = JsonNullable.undefined();

    @JsonProperty("legality_level")
    public SetEnvelopeLegalityLevelRequestBuilder legalityLevel(String value) {
      this.legalityLevel = JsonNullable.of(value);
      return this;
    }
  }
}
