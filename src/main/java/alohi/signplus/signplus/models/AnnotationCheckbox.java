package alohi.signplus.signplus.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Checkbox annotation (null if annotation is not a checkbox)
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationCheckbox {

  /**
   * Whether the checkbox is checked
   */
  private Boolean checked;

  /**
   * Style of the checkbox
   */
  private AnnotationCheckboxStyle style;
}
