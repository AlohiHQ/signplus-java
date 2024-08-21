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
public class Page {

  /**
   * Width of the page in pixels
   */
  private Long width;

  /**
   * Height of the page in pixels
   */
  private Long height;
}
