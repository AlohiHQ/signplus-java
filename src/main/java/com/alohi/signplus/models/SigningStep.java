package com.alohi.signplus.models;

import java.util.List;
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
public class SigningStep {

  /**
   * List of recipients
   */
  private List<Recipient> recipients;
}
