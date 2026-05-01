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
public class CreateEnvelopeRequest {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("legality_level")
  private JsonNullable<String> legalityLevel;

  @JsonProperty("expires_at")
  private JsonNullable<String> expiresAt;

  @JsonProperty("comment")
  private JsonNullable<String> comment;

  @JsonProperty("sandbox")
  private JsonNullable<Boolean> sandbox;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getLegalityLevel() {
    return legalityLevel.orElse(null);
  }

  @JsonIgnore
  public String getExpiresAt() {
    return expiresAt.orElse(null);
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
  public static class CreateEnvelopeRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public CreateEnvelopeRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> legalityLevel = JsonNullable.undefined();

    @JsonProperty("legality_level")
    public CreateEnvelopeRequestBuilder legalityLevel(String value) {
      this.legalityLevel = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> expiresAt = JsonNullable.undefined();

    @JsonProperty("expires_at")
    public CreateEnvelopeRequestBuilder expiresAt(String value) {
      this.expiresAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> comment = JsonNullable.undefined();

    @JsonProperty("comment")
    public CreateEnvelopeRequestBuilder comment(String value) {
      this.comment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> sandbox = JsonNullable.undefined();

    @JsonProperty("sandbox")
    public CreateEnvelopeRequestBuilder sandbox(Boolean value) {
      this.sandbox = JsonNullable.of(value);
      return this;
    }
  }
}
