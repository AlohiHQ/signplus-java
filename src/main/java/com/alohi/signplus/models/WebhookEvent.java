package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Event of the webhook
 */
@Getter
@AllArgsConstructor
public enum WebhookEvent {
  ENVELOPE_EXPIRED("ENVELOPE_EXPIRED"),
  ENVELOPE_DECLINED("ENVELOPE_DECLINED"),
  ENVELOPE_VOIDED("ENVELOPE_VOIDED"),
  ENVELOPE_COMPLETED("ENVELOPE_COMPLETED");

  @JsonValue
  private final String value;

  @JsonCreator
  public static WebhookEvent fromValue(String value) {
    return Arrays.stream(WebhookEvent.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
