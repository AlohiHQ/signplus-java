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
public class EnvelopeAttachments {

  @JsonProperty("settings")
  private JsonNullable<AttachmentSettings> settings;

  @JsonProperty("recipients")
  private JsonNullable<List<AttachmentPlaceholdersPerRecipient>> recipients;

  @JsonIgnore
  public AttachmentSettings getSettings() {
    return settings.orElse(null);
  }

  @JsonIgnore
  public List<AttachmentPlaceholdersPerRecipient> getRecipients() {
    return recipients.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class EnvelopeAttachmentsBuilder {

    private JsonNullable<AttachmentSettings> settings = JsonNullable.undefined();

    @JsonProperty("settings")
    public EnvelopeAttachmentsBuilder settings(AttachmentSettings value) {
      if (value == null) {
        throw new IllegalStateException("settings cannot be null");
      }
      this.settings = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<AttachmentPlaceholdersPerRecipient>> recipients =
      JsonNullable.undefined();

    @JsonProperty("recipients")
    public EnvelopeAttachmentsBuilder recipients(List<AttachmentPlaceholdersPerRecipient> value) {
      if (value == null) {
        throw new IllegalStateException("recipients cannot be null");
      }
      this.recipients = JsonNullable.of(value);
      return this;
    }
  }
}
