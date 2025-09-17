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
public class AttachmentPlaceholderRequest {

  /**
   * ID of the recipient
   */
  @NonNull
  @JsonProperty("recipient_id")
  private String recipientId;

  @NonNull
  private String name;

  /**
   * Whether the attachment placeholder is required
   */
  @NonNull
  private Boolean required;

  @NonNull
  private Boolean multiple;

  /**
   * ID of the attachment placeholder
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Hint of the attachment placeholder
   */
  @JsonProperty("hint")
  private JsonNullable<String> hint;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getHint() {
    return hint.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AttachmentPlaceholderRequestBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public AttachmentPlaceholderRequestBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> hint = JsonNullable.undefined();

    @JsonProperty("hint")
    public AttachmentPlaceholderRequestBuilder hint(String value) {
      if (value == null) {
        throw new IllegalStateException("hint cannot be null");
      }
      this.hint = JsonNullable.of(value);
      return this;
    }
  }
}
