package alohi.signplus.signplus.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Signature annotation (null if annotation is not a signature)
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationSignature {

  /**
   * Unique identifier of the annotation signature
   */
  private String id;
}
