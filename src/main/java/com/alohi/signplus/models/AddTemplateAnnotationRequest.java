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
public class AddTemplateAnnotationRequest {

  @JsonProperty("document_id")
  private JsonNullable<String> documentId;

  @JsonProperty("page")
  private JsonNullable<String> page;

  @JsonProperty("x")
  private JsonNullable<String> x;

  @JsonProperty("y")
  private JsonNullable<String> y;

  @JsonProperty("width")
  private JsonNullable<String> width;

  @JsonProperty("height")
  private JsonNullable<String> height;

  @JsonProperty("type")
  private JsonNullable<String> type;

  @JsonProperty("recipient_id")
  private JsonNullable<String> recipientId;

  @JsonProperty("required")
  private JsonNullable<String> required;

  @JsonProperty("signature")
  private JsonNullable<AddTemplateAnnotationRequestSignature> signature;

  @JsonProperty("initials")
  private JsonNullable<AddTemplateAnnotationRequestInitials> initials;

  @JsonProperty("text")
  private JsonNullable<AddTemplateAnnotationRequestText> text;

  @JsonProperty("datetime")
  private JsonNullable<AddTemplateAnnotationRequestDatetime> datetime;

  @JsonProperty("checkbox")
  private JsonNullable<AddTemplateAnnotationRequestCheckbox> checkbox;

  @JsonIgnore
  public String getDocumentId() {
    return documentId.orElse(null);
  }

  @JsonIgnore
  public String getPage() {
    return page.orElse(null);
  }

  @JsonIgnore
  public String getX() {
    return x.orElse(null);
  }

  @JsonIgnore
  public String getY() {
    return y.orElse(null);
  }

  @JsonIgnore
  public String getWidth() {
    return width.orElse(null);
  }

  @JsonIgnore
  public String getHeight() {
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
  public String getRequired() {
    return required.orElse(null);
  }

  @JsonIgnore
  public AddTemplateAnnotationRequestSignature getSignature() {
    return signature.orElse(null);
  }

  @JsonIgnore
  public AddTemplateAnnotationRequestInitials getInitials() {
    return initials.orElse(null);
  }

  @JsonIgnore
  public AddTemplateAnnotationRequestText getText() {
    return text.orElse(null);
  }

  @JsonIgnore
  public AddTemplateAnnotationRequestDatetime getDatetime() {
    return datetime.orElse(null);
  }

  @JsonIgnore
  public AddTemplateAnnotationRequestCheckbox getCheckbox() {
    return checkbox.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddTemplateAnnotationRequestBuilder {

    private JsonNullable<String> documentId = JsonNullable.undefined();

    @JsonProperty("document_id")
    public AddTemplateAnnotationRequestBuilder documentId(String value) {
      this.documentId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> page = JsonNullable.undefined();

    @JsonProperty("page")
    public AddTemplateAnnotationRequestBuilder page(String value) {
      this.page = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> x = JsonNullable.undefined();

    @JsonProperty("x")
    public AddTemplateAnnotationRequestBuilder x(String value) {
      this.x = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> y = JsonNullable.undefined();

    @JsonProperty("y")
    public AddTemplateAnnotationRequestBuilder y(String value) {
      this.y = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> width = JsonNullable.undefined();

    @JsonProperty("width")
    public AddTemplateAnnotationRequestBuilder width(String value) {
      this.width = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> height = JsonNullable.undefined();

    @JsonProperty("height")
    public AddTemplateAnnotationRequestBuilder height(String value) {
      this.height = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> type = JsonNullable.undefined();

    @JsonProperty("type")
    public AddTemplateAnnotationRequestBuilder type(String value) {
      this.type = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> recipientId = JsonNullable.undefined();

    @JsonProperty("recipient_id")
    public AddTemplateAnnotationRequestBuilder recipientId(String value) {
      this.recipientId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> required = JsonNullable.undefined();

    @JsonProperty("required")
    public AddTemplateAnnotationRequestBuilder required(String value) {
      this.required = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddTemplateAnnotationRequestSignature> signature =
      JsonNullable.undefined();

    @JsonProperty("signature")
    public AddTemplateAnnotationRequestBuilder signature(
      AddTemplateAnnotationRequestSignature value
    ) {
      this.signature = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddTemplateAnnotationRequestInitials> initials = JsonNullable.undefined();

    @JsonProperty("initials")
    public AddTemplateAnnotationRequestBuilder initials(
      AddTemplateAnnotationRequestInitials value
    ) {
      this.initials = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddTemplateAnnotationRequestText> text = JsonNullable.undefined();

    @JsonProperty("text")
    public AddTemplateAnnotationRequestBuilder text(AddTemplateAnnotationRequestText value) {
      this.text = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddTemplateAnnotationRequestDatetime> datetime = JsonNullable.undefined();

    @JsonProperty("datetime")
    public AddTemplateAnnotationRequestBuilder datetime(
      AddTemplateAnnotationRequestDatetime value
    ) {
      this.datetime = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AddTemplateAnnotationRequestCheckbox> checkbox = JsonNullable.undefined();

    @JsonProperty("checkbox")
    public AddTemplateAnnotationRequestBuilder checkbox(
      AddTemplateAnnotationRequestCheckbox value
    ) {
      this.checkbox = JsonNullable.of(value);
      return this;
    }
  }
}
