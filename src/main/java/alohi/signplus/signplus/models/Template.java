package alohi.signplus.signplus.models;

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
public class Template {

  /**
   * Unique identifier of the template
   */
  private String id;

  /**
   * Name of the template
   */
  private String name;

  /**
   * Comment for the template
   */
  private String comment;

  /**
   * Total number of pages in the template
   */
  private Long pages;

  /**
   * Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes)
   */
  @JsonProperty("legality_level")
  private EnvelopeLegalityLevel legalityLevel;

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
   * Expiration delay added to the current time when an envelope is created from this template
   */
  @JsonProperty("expiration_delay")
  private Long expirationDelay;

  /**
   * Number of recipients in the envelope
   */
  @JsonProperty("num_recipients")
  private Long numRecipients;

  @JsonProperty("signing_steps")
  private List<TemplateSigningStep> signingSteps;

  private List<Document> documents;

  private EnvelopeNotification notification;

  /**
   * List of dynamic fields
   */
  @JsonProperty("dynamic_fields")
  private List<String> dynamicFields;
}
