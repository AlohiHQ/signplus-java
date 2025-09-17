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
public class AttachmentSettings {

  /**
   * Whether the attachment is visible to the recipients
   */
  @JsonProperty("visible_to_recipients")
  private JsonNullable<Boolean> visibleToRecipients;

  @JsonIgnore
  public Boolean getVisibleToRecipients() {
    return visibleToRecipients.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AttachmentSettingsBuilder {

    private JsonNullable<Boolean> visibleToRecipients = JsonNullable.undefined();

    @JsonProperty("visible_to_recipients")
    public AttachmentSettingsBuilder visibleToRecipients(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("visibleToRecipients cannot be null");
      }
      this.visibleToRecipients = JsonNullable.of(value);
      return this;
    }
  }
}
