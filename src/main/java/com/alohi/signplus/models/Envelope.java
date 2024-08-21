package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class Envelope {

  /**
   * Unique identifier of the envelope
   */
  private String id;

  /**
   * Name of the envelope
   */
  private String name;

  /**
   * Comment for the envelope
   */
  private String comment;

  /**
   * Total number of pages in the envelope
   */
  private Long pages;

  /**
   * Flow type of the envelope (REQUEST_SIGNATURE is a request for signature, SIGN_MYSELF is a self-signing flow)
   */
  @JsonProperty("flow_type")
  private EnvelopeFlowType flowType;

  /**
   * Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes)
   */
  @JsonProperty("legality_level")
  private EnvelopeLegalityLevel legalityLevel;

  /**
   * Status of the envelope
   */
  private EnvelopeStatus status;

  /**
   * Unix timestamp of the creation date
   */
  @JsonProperty("created_at")
  private Long createdAt;

  /**
   * Unix timestamp of the last modification date
   */
  @JsonProperty("updated_at")
  private Long updatedAt;

  /**
   * Unix timestamp of the expiration date
   */
  @JsonProperty("expires_at")
  private Long expiresAt;

  /**
   * Number of recipients in the envelope
   */
  @JsonProperty("num_recipients")
  private Long numRecipients;

  /**
   * Whether the envelope can be duplicated
   */
  @JsonProperty("is_duplicable")
  private Boolean isDuplicable;

  @JsonProperty("signing_steps")
  private List<SigningStep> signingSteps;

  private List<Document> documents;

  private EnvelopeNotification notification;
}
