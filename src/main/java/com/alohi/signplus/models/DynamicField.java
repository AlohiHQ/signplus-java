package com.alohi.signplus.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
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
