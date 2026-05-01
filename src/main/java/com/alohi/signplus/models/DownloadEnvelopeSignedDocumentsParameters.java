package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class DownloadEnvelopeSignedDocumentsParameters {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("Accept")
  private String accept;

  /**
   * Whether to include the certificate of completion in the downloaded file
   */
  @JsonProperty("certificate_of_completion")
  private JsonNullable<String> certificateOfCompletion;

  @JsonIgnore
  public String getCertificateOfCompletion() {
    return certificateOfCompletion.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class DownloadEnvelopeSignedDocumentsParametersBuilder {

    /**
     * Flag to track if the accept property has been set.
     */
    private boolean accept$set = false;

    public DownloadEnvelopeSignedDocumentsParametersBuilder accept(String accept) {
      this.accept$set = true;
      this.accept = accept;
      return this;
    }

    private JsonNullable<String> certificateOfCompletion = JsonNullable.undefined();

    @JsonProperty("certificate_of_completion")
    public DownloadEnvelopeSignedDocumentsParametersBuilder certificateOfCompletion(String value) {
      this.certificateOfCompletion = JsonNullable.of(value);
      return this;
    }

    public DownloadEnvelopeSignedDocumentsParameters build() {
      if (!accept$set) {
        throw new IllegalStateException("accept is required");
      }
      return new DownloadEnvelopeSignedDocumentsParameters(accept, certificateOfCompletion);
    }
  }
}
