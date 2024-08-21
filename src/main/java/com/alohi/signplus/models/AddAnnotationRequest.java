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
public class AddAnnotationRequest {

  /**
   * ID of the document
   */
  @NonNull
  @JsonProperty("document_id")
  private String documentId;

  /**
   * Page number where the annotation is placed
   */
  @NonNull
  private Long page;

  /**
   * X coordinate of the annotation (in % of the page width from 0 to 100) from the top left corner
   */
  @NonNull
  private Double x;

  /**
   * Y coordinate of the annotation (in % of the page height from 0 to 100) from the top left corner
   */
  @NonNull
  private Double y;

  /**
   * Width of the annotation (in % of the page width from 0 to 100)
   */
  @NonNull
  private Double width;

  /**
   * Height of the annotation (in % of the page height from 0 to 100)
   */
  @NonNull
  private Double height;

  /**
   * Type of the annotation
   */
  @NonNull
  private AnnotationType type;

  /**
   * ID of the recipient
   */
  @JsonProperty("recipient_id")
  private String recipientId;

  private Boolean required;

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
