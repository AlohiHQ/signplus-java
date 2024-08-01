package alohi.signplus.signplus.models;

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
public class CreateEnvelopeFromTemplateRequest {

  /**
   * Name of the envelope
   */
  private String name;

  /**
   * Comment for the envelope
   */
  private String comment;

  /**
   * Whether the envelope is created in sandbox mode
   */
  private Boolean sandbox;
}
