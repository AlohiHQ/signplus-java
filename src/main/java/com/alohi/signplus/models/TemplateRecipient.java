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
public class TemplateRecipient {

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

  /**
   * Name of the recipient
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Email of the recipient
   */
  @JsonProperty("email")
  private JsonNullable<String> email;

  /**
   * Role of the recipient (SIGNER signs the document, RECEIVES_COPY receives a copy of the document, IN_PERSON_SIGNER signs the document in person, SENDER sends the document)
   */
  @JsonProperty("role")
  private JsonNullable<TemplateRecipientRole> role;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getUid() {
    return uid.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getEmail() {
    return email.orElse(null);
  }

  @JsonIgnore
  public TemplateRecipientRole getRole() {
    return role.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TemplateRecipientBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public TemplateRecipientBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> uid = JsonNullable.undefined();

    @JsonProperty("uid")
    public TemplateRecipientBuilder uid(String value) {
      if (value == null) {
        throw new IllegalStateException("uid cannot be null");
      }
      this.uid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public TemplateRecipientBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public TemplateRecipientBuilder email(String value) {
      if (value == null) {
        throw new IllegalStateException("email cannot be null");
      }
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<TemplateRecipientRole> role = JsonNullable.undefined();

    @JsonProperty("role")
    public TemplateRecipientBuilder role(TemplateRecipientRole value) {
      if (value == null) {
        throw new IllegalStateException("role cannot be null");
      }
      this.role = JsonNullable.of(value);
      return this;
    }
  }
}
