package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

  /**
   * Whether to include the certificate of completion in the downloaded file
   */
  @JsonProperty("certificate_of_completion")
  private JsonNullable<Boolean> certificateOfCompletion;

  @JsonIgnore
  public Boolean getCertificateOfCompletion() {
    return certificateOfCompletion.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class DownloadEnvelopeSignedDocumentsParametersBuilder {

    private JsonNullable<Boolean> certificateOfCompletion = JsonNullable.of(true);

    @JsonProperty("certificate_of_completion")
    public DownloadEnvelopeSignedDocumentsParametersBuilder certificateOfCompletion(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("certificateOfCompletion cannot be null");
      }
      this.certificateOfCompletion = JsonNullable.of(value);
      return this;
    }
  }
}
