package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class GetTemplateParameters {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("Accept")
  private String accept;

  // Overwrite lombok builder methods
  public static class GetTemplateParametersBuilder {

    /**
     * Flag to track if the accept property has been set.
     */
    private boolean accept$set = false;

    public GetTemplateParametersBuilder accept(String accept) {
      this.accept$set = true;
      this.accept = accept;
      return this;
    }

    public GetTemplateParameters build() {
      if (!accept$set) {
        throw new IllegalStateException("accept is required");
      }
      return new GetTemplateParameters(accept);
    }
  }
}
