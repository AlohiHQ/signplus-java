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
public class SetTemplateAttachmentsPlaceholdersRequest {

  @JsonProperty("placeholders")
  private JsonNullable<List<SetTemplateAttachmentsPlaceholdersRequestPlaceholders>> placeholders;

  @JsonIgnore
  public List<SetTemplateAttachmentsPlaceholdersRequestPlaceholders> getPlaceholders() {
    return placeholders.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetTemplateAttachmentsPlaceholdersRequestBuilder {

    private JsonNullable<List<SetTemplateAttachmentsPlaceholdersRequestPlaceholders>> placeholders =
      JsonNullable.undefined();

    @JsonProperty("placeholders")
    public SetTemplateAttachmentsPlaceholdersRequestBuilder placeholders(
      List<SetTemplateAttachmentsPlaceholdersRequestPlaceholders> value
    ) {
      this.placeholders = JsonNullable.of(value);
      return this;
    }
  }
}
