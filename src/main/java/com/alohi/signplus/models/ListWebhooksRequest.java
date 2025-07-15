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

  /**
   * ID of the webhook
   */
  @JsonProperty("webhook_id")
  private JsonNullable<String> webhookId;

  /**
   * Event of the webhook
   */
  @JsonProperty("event")
  private JsonNullable<WebhookEvent> event;

  @JsonIgnore
  public String getWebhookId() {
    return webhookId.orElse(null);
  }

  @JsonIgnore
  public WebhookEvent getEvent() {
    return event.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListWebhooksRequestBuilder {

    private JsonNullable<String> webhookId = JsonNullable.undefined();

    @JsonProperty("webhook_id")
    public ListWebhooksRequestBuilder webhookId(String value) {
      if (value == null) {
        throw new IllegalStateException("webhookId cannot be null");
      }
      this.webhookId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<WebhookEvent> event = JsonNullable.undefined();

    @JsonProperty("event")
    public ListWebhooksRequestBuilder event(WebhookEvent value) {
      if (value == null) {
        throw new IllegalStateException("event cannot be null");
      }
      this.event = JsonNullable.of(value);
      return this;
    }
  }
}
