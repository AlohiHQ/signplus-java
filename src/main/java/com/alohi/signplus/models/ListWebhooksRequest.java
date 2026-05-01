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
public class ListWebhooksRequest {

  @JsonProperty("webhook_id")
  private JsonNullable<String> webhookId;

  @JsonProperty("event")
  private JsonNullable<String> event;

  @JsonIgnore
  public String getWebhookId() {
    return webhookId.orElse(null);
  }

  @JsonIgnore
  public String getEvent() {
    return event.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListWebhooksRequestBuilder {

    private JsonNullable<String> webhookId = JsonNullable.undefined();

    @JsonProperty("webhook_id")
    public ListWebhooksRequestBuilder webhookId(String value) {
      this.webhookId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> event = JsonNullable.undefined();

    @JsonProperty("event")
    public ListWebhooksRequestBuilder event(String value) {
      this.event = JsonNullable.of(value);
      return this;
    }
  }
}
