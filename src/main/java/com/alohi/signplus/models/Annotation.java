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
public class Annotation {

  /**
   * Unique identifier of the annotation
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * ID of the recipient
   */
  @JsonProperty("recipient_id")
  private JsonNullable<String> recipientId;

  /**
   * ID of the document
   */
  @JsonProperty("document_id")
  private JsonNullable<String> documentId;

  /**
   * Page number where the annotation is placed
   */
  @JsonProperty("page")
  private JsonNullable<Long> page;

  /**
   * X coordinate of the annotation (in % of the page width from 0 to 100) from the top left corner
   */
  @JsonProperty("x")
  private JsonNullable<Double> x;

  /**
   * Y coordinate of the annotation (in % of the page height from 0 to 100) from the top left corner
   */
  @JsonProperty("y")
  private JsonNullable<Double> y;

  /**
   * Width of the annotation (in % of the page width from 0 to 100)
   */
  @JsonProperty("width")
  private JsonNullable<Double> width;

  /**
   * Height of the annotation (in % of the page height from 0 to 100)
   */
  @JsonProperty("height")
  private JsonNullable<Double> height;

  /**
   * Whether the annotation is required
   */
  @JsonProperty("required")
  private JsonNullable<Boolean> required;

  /**
   * Type of the annotation
   */
  @JsonProperty("type")
  private JsonNullable<AnnotationType> type;

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
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getRecipientId() {
    return recipientId.orElse(null);
  }

  @JsonIgnore
  public String getDocumentId() {
    return documentId.orElse(null);
  }

  @JsonIgnore
  public Long getPage() {
    return page.orElse(null);
  }

  @JsonIgnore
  public Double getX() {
    return x.orElse(null);
  }

  @JsonIgnore
  public Double getY() {
    return y.orElse(null);
  }

  @JsonIgnore
  public Double getWidth() {
    return width.orElse(null);
  }

  @JsonIgnore
  public Double getHeight() {
    return height.orElse(null);
  }

  @JsonIgnore
  public Boolean getRequired() {
    return required.orElse(null);
  }

  @JsonIgnore
  public AnnotationType getType() {
    return type.orElse(null);
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
  public static class AnnotationBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public AnnotationBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> recipientId = JsonNullable.undefined();

    @JsonProperty("recipient_id")
    public AnnotationBuilder recipientId(String value) {
      if (value == null) {
        throw new IllegalStateException("recipientId cannot be null");
      }
      this.recipientId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> documentId = JsonNullable.undefined();

    @JsonProperty("document_id")
    public AnnotationBuilder documentId(String value) {
      if (value == null) {
        throw new IllegalStateException("documentId cannot be null");
      }
      this.documentId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> page = JsonNullable.undefined();

    @JsonProperty("page")
    public AnnotationBuilder page(Long value) {
      if (value == null) {
        throw new IllegalStateException("page cannot be null");
      }
      this.page = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> x = JsonNullable.undefined();

    @JsonProperty("x")
    public AnnotationBuilder x(Double value) {
      if (value == null) {
        throw new IllegalStateException("x cannot be null");
      }
      this.x = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> y = JsonNullable.undefined();

    @JsonProperty("y")
    public AnnotationBuilder y(Double value) {
      if (value == null) {
        throw new IllegalStateException("y cannot be null");
      }
      this.y = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> width = JsonNullable.undefined();

    @JsonProperty("width")
    public AnnotationBuilder width(Double value) {
      if (value == null) {
        throw new IllegalStateException("width cannot be null");
      }
      this.width = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> height = JsonNullable.undefined();

    @JsonProperty("height")
    public AnnotationBuilder height(Double value) {
      if (value == null) {
        throw new IllegalStateException("height cannot be null");
      }
      this.height = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> required = JsonNullable.undefined();

    @JsonProperty("required")
    public AnnotationBuilder required(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("required cannot be null");
      }
      this.required = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationType> type = JsonNullable.undefined();

    @JsonProperty("type")
    public AnnotationBuilder type(AnnotationType value) {
      if (value == null) {
        throw new IllegalStateException("type cannot be null");
      }
      this.type = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationSignature> signature = JsonNullable.undefined();

    @JsonProperty("signature")
    public AnnotationBuilder signature(AnnotationSignature value) {
      if (value == null) {
        throw new IllegalStateException("signature cannot be null");
      }
      this.signature = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationInitials> initials = JsonNullable.undefined();

    @JsonProperty("initials")
    public AnnotationBuilder initials(AnnotationInitials value) {
      if (value == null) {
        throw new IllegalStateException("initials cannot be null");
      }
      this.initials = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationText> text = JsonNullable.undefined();

    @JsonProperty("text")
    public AnnotationBuilder text(AnnotationText value) {
      if (value == null) {
        throw new IllegalStateException("text cannot be null");
      }
      this.text = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationDateTime> datetime = JsonNullable.undefined();

    @JsonProperty("datetime")
    public AnnotationBuilder datetime(AnnotationDateTime value) {
      if (value == null) {
        throw new IllegalStateException("datetime cannot be null");
      }
      this.datetime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationCheckbox> checkbox = JsonNullable.undefined();

    @JsonProperty("checkbox")
    public AnnotationBuilder checkbox(AnnotationCheckbox value) {
      if (value == null) {
        throw new IllegalStateException("checkbox cannot be null");
      }
      this.checkbox = JsonNullable.of(value);
      return this;
    }
  }
}
