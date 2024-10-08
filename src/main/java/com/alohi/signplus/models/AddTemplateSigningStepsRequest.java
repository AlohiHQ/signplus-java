package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class AddTemplateSigningStepsRequest {

  /**
   * List of signing steps
   */
  @NonNull
  @JsonProperty("signing_steps")
  private List<TemplateSigningStep> signingSteps;
}
