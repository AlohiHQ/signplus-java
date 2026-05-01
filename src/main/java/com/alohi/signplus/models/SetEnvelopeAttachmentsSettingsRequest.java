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
public class SetEnvelopeAttachmentsSettingsRequest {

  @JsonProperty("settings")
  private JsonNullable<SetEnvelopeAttachmentsSettingsRequestSettings> settings;

  @JsonIgnore
  public SetEnvelopeAttachmentsSettingsRequestSettings getSettings() {
    return settings.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetEnvelopeAttachmentsSettingsRequestBuilder {

    private JsonNullable<SetEnvelopeAttachmentsSettingsRequestSettings> settings =
      JsonNullable.undefined();

    @JsonProperty("settings")
    public SetEnvelopeAttachmentsSettingsRequestBuilder settings(
      SetEnvelopeAttachmentsSettingsRequestSettings value
    ) {
      this.settings = JsonNullable.of(value);
      return this;
    }
  }
}
