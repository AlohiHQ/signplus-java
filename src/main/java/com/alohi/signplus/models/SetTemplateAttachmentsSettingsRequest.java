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
public class SetTemplateAttachmentsSettingsRequest {

  @JsonProperty("settings")
  private JsonNullable<SetTemplateAttachmentsSettingsRequestSettings> settings;

  @JsonIgnore
  public SetTemplateAttachmentsSettingsRequestSettings getSettings() {
    return settings.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetTemplateAttachmentsSettingsRequestBuilder {

    private JsonNullable<SetTemplateAttachmentsSettingsRequestSettings> settings =
      JsonNullable.undefined();

    @JsonProperty("settings")
    public SetTemplateAttachmentsSettingsRequestBuilder settings(
      SetTemplateAttachmentsSettingsRequestSettings value
    ) {
      this.settings = JsonNullable.of(value);
      return this;
    }
  }
}
