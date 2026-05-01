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
public class CreateTemplateRequest {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateTemplateRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public CreateTemplateRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }
  }
}
