package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ListWebhooksRequest {

  /**
   * ID of the webhook
   */
  @JsonProperty("webhook_id")
  private String webhookId;

  /**
   * Event of the webhook
   */
  private WebhookEvent event;
}
