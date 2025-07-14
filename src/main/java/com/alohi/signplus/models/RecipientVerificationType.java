package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Type of verification the recipient must complete before accessing the envelope.
 *
 * - `PASSCODE`: requires a code to be entered.
 * - `SMS`: sends a code via SMS.
 * - `ID_VERIFICATION`: prompts the recipient to complete an automated ID and selfie check.
 */
@Getter
@AllArgsConstructor
public enum RecipientVerificationType {
  SMS("SMS"),
  PASSCODE("PASSCODE"),
  ID_VERIFICATION("ID_VERIFICATION");

  @JsonValue
  private final String value;

  @JsonCreator
  public static RecipientVerificationType fromValue(String value) {
    return Arrays.stream(RecipientVerificationType.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
