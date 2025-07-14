package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class RecipientVerification {

  /**
   * Type of verification the recipient must complete before accessing the envelope.
   *
   * - `PASSCODE`: requires a code to be entered.
   * - `SMS`: sends a code via SMS.
   * - `ID_VERIFICATION`: prompts the recipient to complete an automated ID and selfie check.
   */
  @JsonProperty("type")
  private JsonNullable<RecipientVerificationType> type;

  /**
   * Required for `PASSCODE` and `SMS` verification.
   *
   * - `PASSCODE`: code required by the recipient to sign the document.
   * - `SMS`: recipient's phone number.
   * - `ID_VERIFICATION`: leave empty.
   */
  @JsonProperty("value")
  private JsonNullable<String> value;

  @JsonIgnore
  public RecipientVerificationType getType() {
    return type.orElse(null);
  }

  @JsonIgnore
  public String getValue() {
    return value.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class RecipientVerificationBuilder {

    private JsonNullable<RecipientVerificationType> type = JsonNullable.undefined();

    @JsonProperty("type")
    public RecipientVerificationBuilder type(RecipientVerificationType value) {
      if (value == null) {
        throw new IllegalStateException("type cannot be null");
      }
      this.type = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> value = JsonNullable.undefined();

    @JsonProperty("value")
    public RecipientVerificationBuilder value(String value) {
      if (value == null) {
        throw new IllegalStateException("value cannot be null");
      }
      this.value = JsonNullable.of(value);
      return this;
    }
  }
}
