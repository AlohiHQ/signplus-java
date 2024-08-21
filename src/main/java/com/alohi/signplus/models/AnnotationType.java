package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Type of the annotation
 */
@Getter
@AllArgsConstructor
public enum AnnotationType {
  TEXT("TEXT"),
  SIGNATURE("SIGNATURE"),
  INITIALS("INITIALS"),
  CHECKBOX("CHECKBOX"),
  DATE("DATE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static AnnotationType fromValue(String value) {
    return Arrays.stream(AnnotationType.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
