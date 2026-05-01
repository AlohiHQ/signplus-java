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
public class CreateEnvelopeFromTemplateRequest {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("comment")
  private JsonNullable<String> comment;

  @JsonProperty("sandbox")
  private JsonNullable<Boolean> sandbox;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getComment() {
    return comment.orElse(null);
  }

  @JsonIgnore
  public Boolean getSandbox() {
    return sandbox.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateEnvelopeFromTemplateRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public CreateEnvelopeFromTemplateRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> comment = JsonNullable.undefined();

    @JsonProperty("comment")
    public CreateEnvelopeFromTemplateRequestBuilder comment(String value) {
      this.comment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> sandbox = JsonNullable.undefined();

    @JsonProperty("sandbox")
    public CreateEnvelopeFromTemplateRequestBuilder sandbox(Boolean value) {
      this.sandbox = JsonNullable.of(value);
      return this;
    }
  }
}
