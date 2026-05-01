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
public class SetEnvelopeAttachmentsSettingsRequestSettings {

  @JsonProperty("visible_to_recipients")
  private JsonNullable<String> visibleToRecipients;

  @JsonIgnore
  public String getVisibleToRecipients() {
    return visibleToRecipients.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetEnvelopeAttachmentsSettingsRequestSettingsBuilder {

    private JsonNullable<String> visibleToRecipients = JsonNullable.undefined();

    @JsonProperty("visible_to_recipients")
    public SetEnvelopeAttachmentsSettingsRequestSettingsBuilder visibleToRecipients(String value) {
      this.visibleToRecipients = JsonNullable.of(value);
      return this;
    }
  }
}
