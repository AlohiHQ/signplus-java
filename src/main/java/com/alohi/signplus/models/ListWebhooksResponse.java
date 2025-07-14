package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class ListWebhooksResponse {

  @JsonProperty("webhooks")
  private JsonNullable<List<Webhook>> webhooks;

  @JsonIgnore
  public List<Webhook> getWebhooks() {
    return webhooks.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListWebhooksResponseBuilder {

    private JsonNullable<List<Webhook>> webhooks = JsonNullable.undefined();

    @JsonProperty("webhooks")
    public ListWebhooksResponseBuilder webhooks(List<Webhook> value) {
      if (value == null) {
        throw new IllegalStateException("webhooks cannot be null");
      }
      this.webhooks = JsonNullable.of(value);
      return this;
    }
  }
}
