package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class SetEnvelopeAttachmentsPlaceholdersRequest {

  @JsonProperty("placeholders")
  private JsonNullable<List<SetEnvelopeAttachmentsPlaceholdersRequestPlaceholders>> placeholders;

  @JsonIgnore
  public List<SetEnvelopeAttachmentsPlaceholdersRequestPlaceholders> getPlaceholders() {
    return placeholders.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetEnvelopeAttachmentsPlaceholdersRequestBuilder {

    private JsonNullable<List<SetEnvelopeAttachmentsPlaceholdersRequestPlaceholders>> placeholders =
      JsonNullable.undefined();

    @JsonProperty("placeholders")
    public SetEnvelopeAttachmentsPlaceholdersRequestBuilder placeholders(
      List<SetEnvelopeAttachmentsPlaceholdersRequestPlaceholders> value
    ) {
      this.placeholders = JsonNullable.of(value);
      return this;
    }
  }
}
