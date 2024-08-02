package alohi.signplus.signplus.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Field to order templates by
 */
@Getter
@AllArgsConstructor
public enum TemplateOrderField {
  TEMPLATE_ID("TEMPLATE_ID"),
  TEMPLATE_CREATION_DATE("TEMPLATE_CREATION_DATE"),
  TEMPLATE_MODIFICATION_DATE("TEMPLATE_MODIFICATION_DATE"),
  TEMPLATE_NAME("TEMPLATE_NAME");

  @JsonValue
  private final String value;

  @JsonCreator
  public static TemplateOrderField fromValue(String value) {
    return Arrays.stream(TemplateOrderField.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
