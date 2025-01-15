package com.alohi.signplus.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Webhook {

  /**
   * Unique identifier of the webhook
   */
  private String id;

  /**
   * Event of the webhook
   */
  private WebhookEvent event;

  /**
   * Target URL of the webhook
   */
  private String target;
}
