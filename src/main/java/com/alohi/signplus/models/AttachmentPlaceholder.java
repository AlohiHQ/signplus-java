package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class AttachmentPlaceholder {

  /**
   * ID of the recipient
   */
  @JsonProperty("recipient_id")
  private JsonNullable<String> recipientId;

  /**
   * ID of the attachment placeholder
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Name of the attachment placeholder
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Hint of the attachment placeholder
   */
  @JsonProperty("hint")
  private JsonNullable<String> hint;

  /**
   * Whether the attachment placeholder is required
   */
  @JsonProperty("required")
  private JsonNullable<Boolean> required;

  /**
   * Whether the attachment placeholder can have multiple files
   */
  @JsonProperty("multiple")
  private JsonNullable<Boolean> multiple;

  @JsonProperty("files")
  private JsonNullable<List<AttachmentPlaceholderFile>> files;

  @JsonIgnore
  public String getRecipientId() {
    return recipientId.orElse(null);
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getHint() {
    return hint.orElse(null);
  }

  @JsonIgnore
  public Boolean getRequired() {
    return required.orElse(null);
  }

  @JsonIgnore
  public Boolean getMultiple() {
    return multiple.orElse(null);
  }

  @JsonIgnore
  public List<AttachmentPlaceholderFile> getFiles() {
    return files.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AttachmentPlaceholderBuilder {

    private JsonNullable<String> recipientId = JsonNullable.undefined();

    @JsonProperty("recipient_id")
    public AttachmentPlaceholderBuilder recipientId(String value) {
      if (value == null) {
        throw new IllegalStateException("recipientId cannot be null");
      }
      this.recipientId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public AttachmentPlaceholderBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public AttachmentPlaceholderBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> hint = JsonNullable.undefined();

    @JsonProperty("hint")
    public AttachmentPlaceholderBuilder hint(String value) {
      if (value == null) {
        throw new IllegalStateException("hint cannot be null");
      }
      this.hint = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> required = JsonNullable.undefined();

    @JsonProperty("required")
    public AttachmentPlaceholderBuilder required(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("required cannot be null");
      }
      this.required = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> multiple = JsonNullable.undefined();

    @JsonProperty("multiple")
    public AttachmentPlaceholderBuilder multiple(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("multiple cannot be null");
      }
      this.multiple = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<AttachmentPlaceholderFile>> files = JsonNullable.undefined();

    @JsonProperty("files")
    public AttachmentPlaceholderBuilder files(List<AttachmentPlaceholderFile> value) {
      if (value == null) {
        throw new IllegalStateException("files cannot be null");
      }
      this.files = JsonNullable.of(value);
      return this;
    }
  }
}
