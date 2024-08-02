package alohi.signplus.signplus.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
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
  private String id;

  /**
   * Unique identifier of the user associated with the recipient
   */
  private String uid;

  private RecipientVerification verification;
}
