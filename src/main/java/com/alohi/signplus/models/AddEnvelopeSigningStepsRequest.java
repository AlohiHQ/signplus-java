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
public class AddEnvelopeSigningStepsRequest {

  /**
   * List of signing steps
   */
  @JsonProperty("signing_steps")
  private JsonNullable<List<SigningStep>> signingSteps;

  @JsonIgnore
  public List<SigningStep> getSigningSteps() {
    return signingSteps.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddEnvelopeSigningStepsRequestBuilder {

    private JsonNullable<List<SigningStep>> signingSteps = JsonNullable.undefined();

    @JsonProperty("signing_steps")
    public AddEnvelopeSigningStepsRequestBuilder signingSteps(List<SigningStep> value) {
      if (value == null) {
        throw new IllegalStateException("signingSteps cannot be null");
      }
      this.signingSteps = JsonNullable.of(value);
      return this;
    }
  }
}
