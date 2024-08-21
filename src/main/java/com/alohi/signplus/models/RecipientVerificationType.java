package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Type of signature verification (SMS sends a code via SMS, PASSCODE requires a code to be entered)
 */
@Getter
@AllArgsConstructor
public enum RecipientVerificationType {
  SMS("SMS"),
  PASSCODE("PASSCODE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static RecipientVerificationType fromValue(String value) {
    return Arrays
      .stream(RecipientVerificationType.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
