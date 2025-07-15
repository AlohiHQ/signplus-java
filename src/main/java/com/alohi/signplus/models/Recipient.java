package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
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
public class Recipient {

  /**
   * Name of the recipient
   */
  @NonNull
  private String name;

  /**
   * Email of the recipient
   */
  @NonNull
  private String email;

  /**
   * Role of the recipient (SIGNER signs the document, RECEIVES_COPY receives a copy of the document, IN_PERSON_SIGNER signs the document in person, SENDER sends the document)
   */
  @NonNull
  private RecipientRole role;

  /**
   * Unique identifier of the recipient
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Unique identifier of the user associated with the recipient
   */
  @JsonProperty("uid")
  private JsonNullable<String> uid;

  @JsonProperty("verification")
  private JsonNullable<RecipientVerification> verification;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getUid() {
    return uid.orElse(null);
  }

  @JsonIgnore
  public RecipientVerification getVerification() {
    return verification.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class RecipientBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public RecipientBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> uid = JsonNullable.undefined();

    @JsonProperty("uid")
    public RecipientBuilder uid(String value) {
      if (value == null) {
        throw new IllegalStateException("uid cannot be null");
      }
      this.uid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<RecipientVerification> verification = JsonNullable.undefined();

    @JsonProperty("verification")
    public RecipientBuilder verification(RecipientVerification value) {
      if (value == null) {
        throw new IllegalStateException("verification cannot be null");
      }
      this.verification = JsonNullable.of(value);
      return this;
    }
  }
}
