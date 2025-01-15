package com.alohi.signplus.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  private AnnotationFontFamily family;

  /**
   * Whether the text is italic
   */
  private Boolean italic;

  /**
   * Whether the text is bold
   */
  private Boolean bold;
}
