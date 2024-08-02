package alohi.signplus.signplus.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Initials annotation (null if annotation is not initials)
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationInitials {

  /**
   * Unique identifier of the annotation initials
   */
  private String id;
}
