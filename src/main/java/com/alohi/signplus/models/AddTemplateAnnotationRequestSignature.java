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
public class AddTemplateAnnotationRequestSignature {

  @JsonProperty("id")
  private JsonNullable<String> id;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddTemplateAnnotationRequestSignatureBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public AddTemplateAnnotationRequestSignatureBuilder id(String value) {
      this.id = JsonNullable.of(value);
      return this;
    }
  }
}
