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
public class Webhook {

  /**
   * Unique identifier of the webhook
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Event of the webhook
   */
  @JsonProperty("event")
  private JsonNullable<WebhookEvent> event;

  /**
   * Target URL of the webhook
   */
  @JsonProperty("target")
  private JsonNullable<String> target;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public WebhookEvent getEvent() {
    return event.orElse(null);
  }

  @JsonIgnore
  public String getTarget() {
    return target.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class WebhookBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public WebhookBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<WebhookEvent> event = JsonNullable.undefined();

    @JsonProperty("event")
    public WebhookBuilder event(WebhookEvent value) {
      if (value == null) {
        throw new IllegalStateException("event cannot be null");
      }
      this.event = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> target = JsonNullable.undefined();

    @JsonProperty("target")
    public WebhookBuilder target(String value) {
      if (value == null) {
        throw new IllegalStateException("target cannot be null");
      }
      this.target = JsonNullable.of(value);
      return this;
    }
  }
}
