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

/**
 * Initials annotation (null if annotation is not initials)
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationInitials {

  /**
   * Unique identifier of the annotation initials
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AnnotationInitialsBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public AnnotationInitialsBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }
  }
}
