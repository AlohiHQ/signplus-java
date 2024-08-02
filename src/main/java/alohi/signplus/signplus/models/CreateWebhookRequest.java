package alohi.signplus.signplus.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateWebhookRequest {

  /**
   * Event of the webhook
   */
  @NonNull
  private WebhookEvent event;

  /**
   * URL of the webhook target
   */
  @NonNull
  private String target;
}
