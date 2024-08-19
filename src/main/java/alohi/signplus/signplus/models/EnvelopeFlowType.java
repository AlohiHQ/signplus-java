package alohi.signplus.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Flow type of the envelope (REQUEST_SIGNATURE is a request for signature)
 */
@Getter
@AllArgsConstructor
public enum EnvelopeFlowType {
  REQUEST_SIGNATURE("REQUEST_SIGNATURE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static EnvelopeFlowType fromValue(String value) {
    return Arrays.stream(EnvelopeFlowType.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
