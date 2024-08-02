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
public class RecipientVerification {

  /**
   * Type of signature verification (SMS sends a code via SMS, PASSCODE requires a code to be entered)
   */
  private RecipientVerificationType type;

  private String value;
}
