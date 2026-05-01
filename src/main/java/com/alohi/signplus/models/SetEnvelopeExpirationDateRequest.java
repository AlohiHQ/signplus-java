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
public class SetEnvelopeExpirationDateRequest {

  @JsonProperty("expires_at")
  private JsonNullable<Double> expiresAt;

  @JsonIgnore
  public Double getExpiresAt() {
    return expiresAt.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetEnvelopeExpirationDateRequestBuilder {

    private JsonNullable<Double> expiresAt = JsonNullable.undefined();

    @JsonProperty("expires_at")
    public SetEnvelopeExpirationDateRequestBuilder expiresAt(Double value) {
      this.expiresAt = JsonNullable.of(value);
      return this;
    }
  }
}
