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
public class AddTemplateSigningStepsRequest {

  @JsonProperty("signing_steps")
  private JsonNullable<List<AddTemplateSigningStepsRequestSigningSteps>> signingSteps;

  @JsonIgnore
  public List<AddTemplateSigningStepsRequestSigningSteps> getSigningSteps() {
    return signingSteps.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddTemplateSigningStepsRequestBuilder {

    private JsonNullable<List<AddTemplateSigningStepsRequestSigningSteps>> signingSteps =
      JsonNullable.undefined();

    @JsonProperty("signing_steps")
    public AddTemplateSigningStepsRequestBuilder signingSteps(
      List<AddTemplateSigningStepsRequestSigningSteps> value
    ) {
      this.signingSteps = JsonNullable.of(value);
      return this;
    }
  }
}
