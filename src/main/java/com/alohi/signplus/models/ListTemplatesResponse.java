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
public class ListTemplatesResponse {

  /**
   * Whether there is a next page
   */
  @JsonProperty("has_next_page")
  private JsonNullable<Boolean> hasNextPage;

  /**
   * Whether there is a previous page
   */
  @JsonProperty("has_previous_page")
  private JsonNullable<Boolean> hasPreviousPage;

  @JsonProperty("templates")
  private JsonNullable<List<Template>> templates;

  @JsonIgnore
  public Boolean getHasNextPage() {
    return hasNextPage.orElse(null);
  }

  @JsonIgnore
  public Boolean getHasPreviousPage() {
    return hasPreviousPage.orElse(null);
  }

  @JsonIgnore
  public List<Template> getTemplates() {
    return templates.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListTemplatesResponseBuilder {

    private JsonNullable<Boolean> hasNextPage = JsonNullable.undefined();

    @JsonProperty("has_next_page")
    public ListTemplatesResponseBuilder hasNextPage(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("hasNextPage cannot be null");
      }
      this.hasNextPage = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> hasPreviousPage = JsonNullable.undefined();

    @JsonProperty("has_previous_page")
    public ListTemplatesResponseBuilder hasPreviousPage(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("hasPreviousPage cannot be null");
      }
      this.hasPreviousPage = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<Template>> templates = JsonNullable.undefined();

    @JsonProperty("templates")
    public ListTemplatesResponseBuilder templates(List<Template> value) {
      if (value == null) {
        throw new IllegalStateException("templates cannot be null");
      }
      this.templates = JsonNullable.of(value);
      return this;
    }
  }
}
