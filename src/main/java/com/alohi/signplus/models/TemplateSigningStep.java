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
public class TemplateSigningStep {

  /**
   * List of recipients
   */
  @JsonProperty("recipients")
  private JsonNullable<List<TemplateRecipient>> recipients;

  @JsonIgnore
  public List<TemplateRecipient> getRecipients() {
    return recipients.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TemplateSigningStepBuilder {

    private JsonNullable<List<TemplateRecipient>> recipients = JsonNullable.undefined();

    @JsonProperty("recipients")
    public TemplateSigningStepBuilder recipients(List<TemplateRecipient> value) {
      if (value == null) {
        throw new IllegalStateException("recipients cannot be null");
      }
      this.recipients = JsonNullable.of(value);
      return this;
    }
  }
}
