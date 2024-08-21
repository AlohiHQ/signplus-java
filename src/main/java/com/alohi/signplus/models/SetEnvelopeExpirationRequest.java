package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class SetEnvelopeExpirationRequest {

  /**
   * Unix timestamp of the expiration date
   */
  @NonNull
  @JsonProperty("expires_at")
  private Long expiresAt;
}
