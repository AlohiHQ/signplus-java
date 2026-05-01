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
public class AddEnvelopeAnnotationRequest {

  @JsonProperty("document_id")
  private JsonNullable<String> documentId;

  @JsonProperty("page")
  private JsonNullable<Double> page;

  @JsonProperty("x")
  private JsonNullable<Double> x;

  @JsonProperty("y")
  private JsonNullable<Double> y;

  @JsonProperty("width")
  private JsonNullable<Double> width;

  @JsonProperty("height")
  private JsonNullable<Double> height;

  @JsonProperty("type")
  private JsonNullable<String> type;

  @JsonProperty("recipient_id")
  private JsonNullable<String> recipientId;

  @JsonProperty("required")
  private JsonNullable<Boolean> required;

  @JsonProperty("signature")
  private JsonNullable<AddEnvelopeAnnotationRequestSignature> signature;

  @JsonProperty("initials")
  private JsonNullable<AddEnvelopeAnnotationRequestInitials> initials;

  @JsonProperty("text")
  private JsonNullable<AddEnvelopeAnnotationRequestText> text;

  @JsonProperty("datetime")
  private JsonNullable<AddEnvelopeAnnotationRequestDatetime> datetime;

  @JsonProperty("checkbox")
  private JsonNullable<AddEnvelopeAnnotationRequestCheckbox> checkbox;

  @JsonIgnore
  public String getDocumentId() {
    return documentId.orElse(null);
  }

  @JsonIgnore
  public Double getPage() {
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
  public String getType() {
    return type.orElse(null);
  }

  @JsonIgnore
  public String getRecipientId() {
    return recipientId.orElse(null);
  }

  @JsonIgnore
  public Boolean getRequired() {
    return required.orElse(null);
  }

  @JsonIgnore
  public AddEnvelopeAnnotationRequestSignature getSignature() {
    return signature.orElse(null);
  }

  @JsonIgnore
  public AddEnvelopeAnnotationRequestInitials getInitials() {
    return initials.orElse(null);
  }

  @JsonIgnore
  public AddEnvelopeAnnotationRequestText getText() {
    return text.orElse(null);
  }

  @JsonIgnore
  public AddEnvelopeAnnotationRequestDatetime getDatetime() {
    return datetime.orElse(null);
  }

  @JsonIgnore
  public AddEnvelopeAnnotationRequestCheckbox getCheckbox() {
    return checkbox.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddEnvelopeAnnotationRequestBuilder {

    private JsonNullable<String> documentId = JsonNullable.undefined();

    @JsonProperty("document_id")
    public AddEnvelopeAnnotationRequestBuilder documentId(String value) {
      this.documentId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> page = JsonNullable.undefined();

    @JsonProperty("page")
    public AddEnvelopeAnnotationRequestBuilder page(Double value) {
      this.page = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> x = JsonNullable.undefined();

    @JsonProperty("x")
    public AddEnvelopeAnnotationRequestBuilder x(Double value) {
      this.x = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> y = JsonNullable.undefined();

    @JsonProperty("y")
    public AddEnvelopeAnnotationRequestBuilder y(Double value) {
      this.y = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> width = JsonNullable.undefined();

    @JsonProperty("width")
    public AddEnvelopeAnnotationRequestBuilder width(Double value) {
      this.width = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> height = JsonNullable.undefined();

    @JsonProperty("height")
    public AddEnvelopeAnnotationRequestBuilder height(Double value) {
      this.height = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> type = JsonNullable.undefined();

    @JsonProperty("type")
    public AddEnvelopeAnnotationRequestBuilder type(String value) {
      this.type = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> recipientId = JsonNullable.undefined();

    @JsonProperty("recipient_id")
    public AddEnvelopeAnnotationRequestBuilder recipientId(String value) {
      this.recipientId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> required = JsonNullable.undefined();

    @JsonProperty("required")
    public AddEnvelopeAnnotationRequestBuilder required(Boolean value) {
      this.required = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddEnvelopeAnnotationRequestSignature> signature =
      JsonNullable.undefined();

    @JsonProperty("signature")
    public AddEnvelopeAnnotationRequestBuilder signature(
      AddEnvelopeAnnotationRequestSignature value
    ) {
      this.signature = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddEnvelopeAnnotationRequestInitials> initials = JsonNullable.undefined();

    @JsonProperty("initials")
    public AddEnvelopeAnnotationRequestBuilder initials(
      AddEnvelopeAnnotationRequestInitials value
    ) {
      this.initials = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddEnvelopeAnnotationRequestText> text = JsonNullable.undefined();

    @JsonProperty("text")
    public AddEnvelopeAnnotationRequestBuilder text(AddEnvelopeAnnotationRequestText value) {
      this.text = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddEnvelopeAnnotationRequestDatetime> datetime = JsonNullable.undefined();

    @JsonProperty("datetime")
    public AddEnvelopeAnnotationRequestBuilder datetime(
      AddEnvelopeAnnotationRequestDatetime value
    ) {
      this.datetime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddEnvelopeAnnotationRequestCheckbox> checkbox = JsonNullable.undefined();

    @JsonProperty("checkbox")
    public AddEnvelopeAnnotationRequestBuilder checkbox(
      AddEnvelopeAnnotationRequestCheckbox value
    ) {
      this.checkbox = JsonNullable.of(value);
      return this;
    }
  }
}
