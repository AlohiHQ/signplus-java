package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Style of the checkbox
 */
@Getter
@AllArgsConstructor
public enum AnnotationCheckboxStyle {
  CIRCLE_CHECK("CIRCLE_CHECK"),
  CIRCLE_FULL("CIRCLE_FULL"),
  SQUARE_CHECK("SQUARE_CHECK"),
  SQUARE_FULL("SQUARE_FULL"),
  CHECK_MARK("CHECK_MARK"),
  TIMES_SQUARE("TIMES_SQUARE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static AnnotationCheckboxStyle fromValue(String value) {
    return Arrays
      .stream(AnnotationCheckboxStyle.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
