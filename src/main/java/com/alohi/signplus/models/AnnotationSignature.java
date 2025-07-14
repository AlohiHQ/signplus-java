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

/**
 * Signature annotation (null if annotation is not a signature)
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationSignature {

  /**
   * Unique identifier of the annotation signature
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AnnotationSignatureBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public AnnotationSignatureBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }
  }
}
