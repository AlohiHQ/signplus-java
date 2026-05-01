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
public class SetTemplateAttachmentsPlaceholdersRequestPlaceholders {

  @JsonProperty("recipient_id")
  private JsonNullable<String> recipientId;

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("required")
  private JsonNullable<String> required;

  @JsonProperty("multiple")
  private JsonNullable<String> multiple;

  @JsonProperty("id")
  private JsonNullable<String> id;

  @JsonProperty("hint")
  private JsonNullable<String> hint;

  @JsonIgnore
  public String getRecipientId() {
    return recipientId.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getRequired() {
    return required.orElse(null);
  }

  @JsonIgnore
  public String getMultiple() {
    return multiple.orElse(null);
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getHint() {
    return hint.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetTemplateAttachmentsPlaceholdersRequestPlaceholdersBuilder {

    private JsonNullable<String> recipientId = JsonNullable.undefined();

    @JsonProperty("recipient_id")
    public SetTemplateAttachmentsPlaceholdersRequestPlaceholdersBuilder recipientId(String value) {
      this.recipientId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public SetTemplateAttachmentsPlaceholdersRequestPlaceholdersBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> required = JsonNullable.undefined();

    @JsonProperty("required")
    public SetTemplateAttachmentsPlaceholdersRequestPlaceholdersBuilder required(String value) {
      this.required = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> multiple = JsonNullable.undefined();

    @JsonProperty("multiple")
    public SetTemplateAttachmentsPlaceholdersRequestPlaceholdersBuilder multiple(String value) {
      this.multiple = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public SetTemplateAttachmentsPlaceholdersRequestPlaceholdersBuilder id(String value) {
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> hint = JsonNullable.undefined();

    @JsonProperty("hint")
    public SetTemplateAttachmentsPlaceholdersRequestPlaceholdersBuilder hint(String value) {
      this.hint = JsonNullable.of(value);
      return this;
    }
  }
}
