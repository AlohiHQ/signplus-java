package com.alohi.signplus.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class DynamicField {

  /**
   * Name of the dynamic field
   */
  private String name;

  /**
   * Value of the dynamic field
   */
  private String value;
}
