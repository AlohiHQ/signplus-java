package alohi.signplus.signplus.models;

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
public class CreateEnvelopeRequest {

  /**
   * Name of the envelope
   */
  @NonNull
  private String name;

  /**
   * Flow type of the envelope (REQUEST_SIGNATURE is a request for signature)
   */
  @NonNull
  @JsonProperty("flow_type")
  private EnvelopeFlowType flowType;

  /**
   * Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes)
   */
  @NonNull
  @JsonProperty("legality_level")
  private EnvelopeLegalityLevel legalityLevel;

  /**
   * Unix timestamp of the expiration date
   */
  @JsonProperty("expires_at")
  private Long expiresAt;

  /**
   * Comment for the envelope
   */
  private String comment;

  /**
   * Whether the envelope is created in sandbox mode
   */
  private Boolean sandbox;
}
