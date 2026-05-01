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
public class AddEnvelopeSigningStepsRequestSigningSteps {

  @JsonProperty("recipients")
  private JsonNullable<List<SigningStepsRecipients1>> recipients;

  @JsonIgnore
  public List<SigningStepsRecipients1> getRecipients() {
    return recipients.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddEnvelopeSigningStepsRequestSigningStepsBuilder {

    private JsonNullable<List<SigningStepsRecipients1>> recipients = JsonNullable.undefined();

    @JsonProperty("recipients")
    public AddEnvelopeSigningStepsRequestSigningStepsBuilder recipients(
      List<SigningStepsRecipients1> value
    ) {
      this.recipients = JsonNullable.of(value);
      return this;
    }
  }
}
