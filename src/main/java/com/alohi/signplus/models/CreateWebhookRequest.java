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
public class CreateWebhookRequest {

  @JsonProperty("event")
  private JsonNullable<String> event;

  @JsonProperty("target")
  private JsonNullable<String> target;

  @JsonIgnore
  public String getEvent() {
    return event.orElse(null);
  }

  @JsonIgnore
  public String getTarget() {
    return target.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateWebhookRequestBuilder {

    private JsonNullable<String> event = JsonNullable.undefined();

    @JsonProperty("event")
    public CreateWebhookRequestBuilder event(String value) {
      this.event = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> target = JsonNullable.undefined();

    @JsonProperty("target")
    public CreateWebhookRequestBuilder target(String value) {
      this.target = JsonNullable.of(value);
      return this;
    }
  }
}
