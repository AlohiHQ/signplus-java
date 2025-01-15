package com.alohi.signplus.models;

import java.util.List;
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
public class TemplateSigningStep {

  /**
   * List of recipients
   */
  private List<TemplateRecipient> recipients;
}
