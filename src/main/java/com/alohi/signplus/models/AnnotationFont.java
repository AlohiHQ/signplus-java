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
public class AnnotationFont {

  /**
   * Font family of the text
   */
  @JsonProperty("family")
  private JsonNullable<AnnotationFontFamily> family;

  /**
   * Whether the text is italic
   */
  @JsonProperty("italic")
  private JsonNullable<Boolean> italic;

  /**
   * Whether the text is bold
   */
  @JsonProperty("bold")
  private JsonNullable<Boolean> bold;

  @JsonIgnore
  public AnnotationFontFamily getFamily() {
    return family.orElse(null);
  }

  @JsonIgnore
  public Boolean getItalic() {
    return italic.orElse(null);
  }

  @JsonIgnore
  public Boolean getBold() {
    return bold.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AnnotationFontBuilder {

    private JsonNullable<AnnotationFontFamily> family = JsonNullable.undefined();

    @JsonProperty("family")
    public AnnotationFontBuilder family(AnnotationFontFamily value) {
      if (value == null) {
        throw new IllegalStateException("family cannot be null");
      }
      this.family = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> italic = JsonNullable.undefined();

    @JsonProperty("italic")
    public AnnotationFontBuilder italic(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("italic cannot be null");
      }
      this.italic = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> bold = JsonNullable.undefined();

    @JsonProperty("bold")
    public AnnotationFontBuilder bold(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("bold cannot be null");
      }
      this.bold = JsonNullable.of(value);
      return this;
    }
  }
}
