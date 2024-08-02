package alohi.signplus.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Annotation {

  /**
   * Unique identifier of the annotation
   */
  private String id;

  /**
   * ID of the recipient
   */
  @JsonProperty("recipient_id")
  private String recipientId;

  /**
   * ID of the document
   */
  @JsonProperty("document_id")
  private String documentId;

  /**
   * Page number where the annotation is placed
   */
  private Long page;

  /**
   * X coordinate of the annotation (in % of the page width from 0 to 100) from the top left corner
   */
  private Double x;

  /**
   * Y coordinate of the annotation (in % of the page height from 0 to 100) from the top left corner
   */
  private Double y;

  /**
   * Width of the annotation (in % of the page width from 0 to 100)
   */
  private Double width;

  /**
   * Height of the annotation (in % of the page height from 0 to 100)
   */
  private Double height;

  /**
   * Whether the annotation is required
   */
  private Boolean required;

  /**
   * Type of the annotation
   */
  private AnnotationType type;

  /**
   * Signature annotation (null if annotation is not a signature)
   */
  private AnnotationSignature signature;

  /**
   * Initials annotation (null if annotation is not initials)
   */
  private AnnotationInitials initials;

  /**
   * Text annotation (null if annotation is not a text)
   */
  private AnnotationText text;

  /**
   * Date annotation (null if annotation is not a date)
   */
  private AnnotationDateTime datetime;

  /**
   * Checkbox annotation (null if annotation is not a checkbox)
   */
  private AnnotationCheckbox checkbox;
}
