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
public class SetTemplateAttachmentsPlaceholdersParameters {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("Accept")
  private String accept;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private SetTemplateAttachmentsPlaceholdersRequest requestBody;

  // Overwrite lombok builder methods
  public static class SetTemplateAttachmentsPlaceholdersParametersBuilder {

    /**
     * Flag to track if the accept property has been set.
     */
    private boolean accept$set = false;

    /**
     * Flag to track if the requestBody property has been set.
     */
    private boolean requestBody$set = false;

    public SetTemplateAttachmentsPlaceholdersParametersBuilder accept(String accept) {
      this.accept$set = true;
      this.accept = accept;
      return this;
    }

    public SetTemplateAttachmentsPlaceholdersParametersBuilder requestBody(
      SetTemplateAttachmentsPlaceholdersRequest requestBody
    ) {
      this.requestBody$set = true;
      this.requestBody = requestBody;
      return this;
    }

    public SetTemplateAttachmentsPlaceholdersParameters build() {
      if (!accept$set) {
        throw new IllegalStateException("accept is required");
      }
      if (!requestBody$set) {
        throw new IllegalStateException("requestBody is required");
      }
      return new SetTemplateAttachmentsPlaceholdersParameters(accept, requestBody);
    }
  }
}
