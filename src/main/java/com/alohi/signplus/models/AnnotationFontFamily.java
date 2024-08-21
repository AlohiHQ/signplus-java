package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Font family of the text
 */
@Getter
@AllArgsConstructor
public enum AnnotationFontFamily {
  UNKNOWN("UNKNOWN"),
  SERIF("SERIF"),
  SANS("SANS"),
  MONO("MONO");

  @JsonValue
  private final String value;

  @JsonCreator
  public static AnnotationFontFamily fromValue(String value) {
    return Arrays
      .stream(AnnotationFontFamily.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
