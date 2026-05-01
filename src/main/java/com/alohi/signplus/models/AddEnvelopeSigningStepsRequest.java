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

  @JsonProperty("signing_steps")
  private JsonNullable<List<AddEnvelopeSigningStepsRequestSigningSteps>> signingSteps;

  @JsonIgnore
  public List<AddEnvelopeSigningStepsRequestSigningSteps> getSigningSteps() {
    return signingSteps.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddEnvelopeSigningStepsRequestBuilder {

    private JsonNullable<List<AddEnvelopeSigningStepsRequestSigningSteps>> signingSteps =
      JsonNullable.undefined();

    @JsonProperty("signing_steps")
    public AddEnvelopeSigningStepsRequestBuilder signingSteps(
      List<AddEnvelopeSigningStepsRequestSigningSteps> value
    ) {
      this.signingSteps = JsonNullable.of(value);
      return this;
    }
  }
}
