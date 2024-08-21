package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes)
 */
@Getter
@AllArgsConstructor
public enum EnvelopeLegalityLevel {
  SES("SES"),
  QES_EIDAS("QES_EIDAS"),
  QES_ZERTES("QES_ZERTES");

  @JsonValue
  private final String value;

  @JsonCreator
  public static EnvelopeLegalityLevel fromValue(String value) {
    return Arrays
      .stream(EnvelopeLegalityLevel.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
