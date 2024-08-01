package alohi.signplus.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Status of the envelope
 */
@Getter
@AllArgsConstructor
public enum EnvelopeStatus {
  DRAFT("DRAFT"),
  IN_PROGRESS("IN_PROGRESS"),
  COMPLETED("COMPLETED"),
  EXPIRED("EXPIRED"),
  DECLINED("DECLINED"),
  VOIDED("VOIDED"),
  PENDING("PENDING");

  @JsonValue
  private final String value;

  @JsonCreator
  public static EnvelopeStatus fromValue(String value) {
    return Arrays.stream(EnvelopeStatus.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
