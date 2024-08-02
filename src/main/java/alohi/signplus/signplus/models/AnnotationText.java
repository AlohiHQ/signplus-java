package alohi.signplus.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Text annotation (null if annotation is not a text)
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationText {

  /**
   * Font size of the text in pt
   */
  private Double size;

  /**
   * Text color in 32bit representation
   */
  private Double color;

  /**
   * Text content of the annotation
   */
  private String value;

  /**
   * Tooltip of the annotation
   */
  private String tooltip;

  /**
   * Name of the dynamic field
   */
  @JsonProperty("dynamic_field_name")
  private String dynamicFieldName;

  private AnnotationFont font;
}
