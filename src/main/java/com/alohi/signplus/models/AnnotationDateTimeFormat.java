package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Format of the date time (DMY_NUMERIC_SLASH is day/month/year with slashes, MDY_NUMERIC_SLASH is month/day/year with slashes, YMD_NUMERIC_SLASH is year/month/day with slashes, DMY_NUMERIC_DASH_SHORT is day/month/year with dashes, DMY_NUMERIC_DASH is day/month/year with dashes, YMD_NUMERIC_DASH is year/month/day with dashes, MDY_TEXT_DASH_SHORT is month/day/year with dashes, MDY_TEXT_SPACE_SHORT is month/day/year with spaces, MDY_TEXT_SPACE is month/day/year with spaces)
 */
@Getter
@AllArgsConstructor
public enum AnnotationDateTimeFormat {
  DMY_NUMERIC_SLASH("DMY_NUMERIC_SLASH"),
  MDY_NUMERIC_SLASH("MDY_NUMERIC_SLASH"),
  YMD_NUMERIC_SLASH("YMD_NUMERIC_SLASH"),
  DMY_NUMERIC_DASH_SHORT("DMY_NUMERIC_DASH_SHORT"),
  DMY_NUMERIC_DASH("DMY_NUMERIC_DASH"),
  YMD_NUMERIC_DASH("YMD_NUMERIC_DASH"),
  MDY_TEXT_DASH_SHORT("MDY_TEXT_DASH_SHORT"),
  MDY_TEXT_SPACE_SHORT("MDY_TEXT_SPACE_SHORT"),
  MDY_TEXT_SPACE("MDY_TEXT_SPACE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static AnnotationDateTimeFormat fromValue(String value) {
    return Arrays
      .stream(AnnotationDateTimeFormat.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
