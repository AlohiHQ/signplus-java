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
public class ListTemplateAnnotationsResponse {

  @JsonProperty("annotations")
  private JsonNullable<List<Annotation>> annotations;

  @JsonIgnore
  public List<Annotation> getAnnotations() {
    return annotations.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListTemplateAnnotationsResponseBuilder {

    private JsonNullable<List<Annotation>> annotations = JsonNullable.undefined();

    @JsonProperty("annotations")
    public ListTemplateAnnotationsResponseBuilder annotations(List<Annotation> value) {
      if (value == null) {
        throw new IllegalStateException("annotations cannot be null");
      }
      this.annotations = JsonNullable.of(value);
      return this;
    }
  }
}
