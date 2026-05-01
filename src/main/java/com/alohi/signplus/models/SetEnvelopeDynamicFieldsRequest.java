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
public class SetEnvelopeDynamicFieldsRequest {

  @JsonProperty("dynamic_fields")
  private JsonNullable<List<DynamicFields>> dynamicFields;

  @JsonIgnore
  public List<DynamicFields> getDynamicFields() {
    return dynamicFields.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetEnvelopeDynamicFieldsRequestBuilder {

    private JsonNullable<List<DynamicFields>> dynamicFields = JsonNullable.undefined();

    @JsonProperty("dynamic_fields")
    public SetEnvelopeDynamicFieldsRequestBuilder dynamicFields(List<DynamicFields> value) {
      this.dynamicFields = JsonNullable.of(value);
      return this;
    }
  }
}
