package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Role of the recipient (SIGNER signs the document, RECEIVES_COPY receives a copy of the document, IN_PERSON_SIGNER signs the document in person, SENDER sends the document)
 */
@Getter
@AllArgsConstructor
public enum TemplateRecipientRole {
  SIGNER("SIGNER"),
  RECEIVES_COPY("RECEIVES_COPY"),
  IN_PERSON_SIGNER("IN_PERSON_SIGNER");

  @JsonValue
  private final String value;

  @JsonCreator
  public static TemplateRecipientRole fromValue(String value) {
    return Arrays
      .stream(TemplateRecipientRole.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
