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
public class TemplateRecipient {

  /**
   * Unique identifier of the recipient
   */
  private String id;

  /**
   * Unique identifier of the user associated with the recipient
   */
  private String uid;

  /**
   * Name of the recipient
   */
  private String name;

  /**
   * Email of the recipient
   */
  private String email;

  /**
   * Role of the recipient (SIGNER signs the document, RECEIVES_COPY receives a copy of the document, IN_PERSON_SIGNER signs the document in person, SENDER sends the document)
   */
  private TemplateRecipientRole role;
}
