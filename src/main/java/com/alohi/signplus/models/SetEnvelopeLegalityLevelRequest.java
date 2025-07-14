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

  /**
   * Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes)
   */
  @JsonProperty("legality_level")
  private JsonNullable<EnvelopeLegalityLevel> legalityLevel;

  @JsonIgnore
  public EnvelopeLegalityLevel getLegalityLevel() {
    return legalityLevel.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetEnvelopeLegalityLevelRequestBuilder {

    private JsonNullable<EnvelopeLegalityLevel> legalityLevel = JsonNullable.undefined();

    @JsonProperty("legality_level")
    public SetEnvelopeLegalityLevelRequestBuilder legalityLevel(EnvelopeLegalityLevel value) {
      if (value == null) {
        throw new IllegalStateException("legalityLevel cannot be null");
      }
      this.legalityLevel = JsonNullable.of(value);
      return this;
    }
  }
}
