package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Field to order envelopes by
 */
@Getter
@AllArgsConstructor
public enum EnvelopeOrderField {
  CREATION_DATE("CREATION_DATE"),
  MODIFICATION_DATE("MODIFICATION_DATE"),
  NAME("NAME"),
  STATUS("STATUS"),
  LAST_DOCUMENT_CHANGE("LAST_DOCUMENT_CHANGE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static EnvelopeOrderField fromValue(String value) {
    return Arrays.stream(EnvelopeOrderField.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
