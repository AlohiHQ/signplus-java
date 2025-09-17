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
public class AttachmentPlaceholdersPerRecipient {

  /**
   * ID of the recipient
   */
  @JsonProperty("recipient_id")
  private JsonNullable<String> recipientId;

  /**
   * Name of the recipient
   */
  @JsonProperty("recipient_name")
  private JsonNullable<String> recipientName;

  @JsonProperty("placeholders")
  private JsonNullable<List<AttachmentPlaceholder>> placeholders;

  @JsonIgnore
  public String getRecipientId() {
    return recipientId.orElse(null);
  }

  @JsonIgnore
  public String getRecipientName() {
    return recipientName.orElse(null);
  }

  @JsonIgnore
  public List<AttachmentPlaceholder> getPlaceholders() {
    return placeholders.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AttachmentPlaceholdersPerRecipientBuilder {

    private JsonNullable<String> recipientId = JsonNullable.undefined();

    @JsonProperty("recipient_id")
    public AttachmentPlaceholdersPerRecipientBuilder recipientId(String value) {
      if (value == null) {
        throw new IllegalStateException("recipientId cannot be null");
      }
      this.recipientId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> recipientName = JsonNullable.undefined();

    @JsonProperty("recipient_name")
    public AttachmentPlaceholdersPerRecipientBuilder recipientName(String value) {
      if (value == null) {
        throw new IllegalStateException("recipientName cannot be null");
      }
      this.recipientName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<AttachmentPlaceholder>> placeholders = JsonNullable.undefined();

    @JsonProperty("placeholders")
    public AttachmentPlaceholdersPerRecipientBuilder placeholders(List<AttachmentPlaceholder> value) {
      if (value == null) {
        throw new IllegalStateException("placeholders cannot be null");
      }
      this.placeholders = JsonNullable.of(value);
      return this;
    }
  }
}
