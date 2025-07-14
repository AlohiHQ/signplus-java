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
public class AddEnvelopeDocumentRequest {

  /**
   * File to upload in binary format
   */
  @JsonProperty("file")
  private JsonNullable<byte[]> file;

  @JsonIgnore
  public byte[] getFile() {
    return file.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddEnvelopeDocumentRequestBuilder {

    private JsonNullable<byte[]> file = JsonNullable.undefined();

    @JsonProperty("file")
    public AddEnvelopeDocumentRequestBuilder file(byte[] value) {
      if (value == null) {
        throw new IllegalStateException("file cannot be null");
      }
      this.file = JsonNullable.of(value);
      return this;
    }
  }
}
