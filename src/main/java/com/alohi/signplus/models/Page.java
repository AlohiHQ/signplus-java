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
public class Page {

  /**
   * Width of the page in pixels
   */
  @JsonProperty("width")
  private JsonNullable<Long> width;

  /**
   * Height of the page in pixels
   */
  @JsonProperty("height")
  private JsonNullable<Long> height;

  @JsonIgnore
  public Long getWidth() {
    return width.orElse(null);
  }

  @JsonIgnore
  public Long getHeight() {
    return height.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PageBuilder {

    private JsonNullable<Long> width = JsonNullable.undefined();

    @JsonProperty("width")
    public PageBuilder width(Long value) {
      if (value == null) {
        throw new IllegalStateException("width cannot be null");
      }
      this.width = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> height = JsonNullable.undefined();

    @JsonProperty("height")
    public PageBuilder height(Long value) {
      if (value == null) {
        throw new IllegalStateException("height cannot be null");
      }
      this.height = JsonNullable.of(value);
      return this;
    }
  }
}
