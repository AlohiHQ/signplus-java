package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
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
  private JsonNullable<String> recipientId;

  @JsonProperty("required")
  private JsonNullable<Boolean> required;

  /**
   * Signature annotation (null if annotation is not a signature)
   */
  @JsonProperty("signature")
  private JsonNullable<AnnotationSignature> signature;

  /**
   * Initials annotation (null if annotation is not initials)
   */
  @JsonProperty("initials")
  private JsonNullable<AnnotationInitials> initials;

  /**
   * Text annotation (null if annotation is not a text)
   */
  @JsonProperty("text")
  private JsonNullable<AnnotationText> text;

  /**
   * Date annotation (null if annotation is not a date)
   */
  @JsonProperty("datetime")
  private JsonNullable<AnnotationDateTime> datetime;

  /**
   * Checkbox annotation (null if annotation is not a checkbox)
   */
  @JsonProperty("checkbox")
  private JsonNullable<AnnotationCheckbox> checkbox;

  @JsonIgnore
  public String getRecipientId() {
    return recipientId.orElse(null);
  }

  @JsonIgnore
  public Boolean getRequired() {
    return required.orElse(null);
  }

  @JsonIgnore
  public AnnotationSignature getSignature() {
    return signature.orElse(null);
  }

  @JsonIgnore
  public AnnotationInitials getInitials() {
    return initials.orElse(null);
  }

  @JsonIgnore
  public AnnotationText getText() {
    return text.orElse(null);
  }

  @JsonIgnore
  public AnnotationDateTime getDatetime() {
    return datetime.orElse(null);
  }

  @JsonIgnore
  public AnnotationCheckbox getCheckbox() {
    return checkbox.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddAnnotationRequestBuilder {

    private JsonNullable<String> recipientId = JsonNullable.undefined();

    @JsonProperty("recipient_id")
    public AddAnnotationRequestBuilder recipientId(String value) {
      if (value == null) {
        throw new IllegalStateException("recipientId cannot be null");
      }
      this.recipientId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> required = JsonNullable.undefined();

    @JsonProperty("required")
    public AddAnnotationRequestBuilder required(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("required cannot be null");
      }
      this.required = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationSignature> signature = JsonNullable.undefined();

    @JsonProperty("signature")
    public AddAnnotationRequestBuilder signature(AnnotationSignature value) {
      if (value == null) {
        throw new IllegalStateException("signature cannot be null");
      }
      this.signature = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationInitials> initials = JsonNullable.undefined();

    @JsonProperty("initials")
    public AddAnnotationRequestBuilder initials(AnnotationInitials value) {
      if (value == null) {
        throw new IllegalStateException("initials cannot be null");
      }
      this.initials = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationText> text = JsonNullable.undefined();

    @JsonProperty("text")
    public AddAnnotationRequestBuilder text(AnnotationText value) {
      if (value == null) {
        throw new IllegalStateException("text cannot be null");
      }
      this.text = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationDateTime> datetime = JsonNullable.undefined();

    @JsonProperty("datetime")
    public AddAnnotationRequestBuilder datetime(AnnotationDateTime value) {
      if (value == null) {
        throw new IllegalStateException("datetime cannot be null");
      }
      this.datetime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationCheckbox> checkbox = JsonNullable.undefined();

    @JsonProperty("checkbox")
    public AddAnnotationRequestBuilder checkbox(AnnotationCheckbox value) {
      if (value == null) {
        throw new IllegalStateException("checkbox cannot be null");
      }
      this.checkbox = JsonNullable.of(value);
      return this;
    }
  }
}
