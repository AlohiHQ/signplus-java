package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
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

  /**
   * Name of the envelope
   */
  @NonNull
  private String name;

  /**
   * Comment for the envelope
   */
  @JsonProperty("comment")
  private JsonNullable<String> comment;

  /**
   * Whether the envelope is created in sandbox mode
   */
  @JsonProperty("sandbox")
  private JsonNullable<Boolean> sandbox;

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

    private JsonNullable<String> comment = JsonNullable.undefined();

    @JsonProperty("comment")
    public CreateEnvelopeFromTemplateRequestBuilder comment(String value) {
      if (value == null) {
        throw new IllegalStateException("comment cannot be null");
      }
      this.comment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> sandbox = JsonNullable.undefined();

    @JsonProperty("sandbox")
    public CreateEnvelopeFromTemplateRequestBuilder sandbox(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("sandbox cannot be null");
      }
      this.sandbox = JsonNullable.of(value);
      return this;
    }
  }
}
