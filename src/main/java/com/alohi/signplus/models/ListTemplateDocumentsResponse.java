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
public class ListTemplateDocumentsResponse {

  @JsonProperty("documents")
  private JsonNullable<List<Document>> documents;

  @JsonIgnore
  public List<Document> getDocuments() {
    return documents.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListTemplateDocumentsResponseBuilder {

    private JsonNullable<List<Document>> documents = JsonNullable.undefined();

    @JsonProperty("documents")
    public ListTemplateDocumentsResponseBuilder documents(List<Document> value) {
      if (value == null) {
        throw new IllegalStateException("documents cannot be null");
      }
      this.documents = JsonNullable.of(value);
      return this;
    }
  }
}
