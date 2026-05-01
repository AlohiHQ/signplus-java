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
public class SigningStepsRecipients1 {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("email")
  private JsonNullable<String> email;

  @JsonProperty("role")
  private JsonNullable<String> role;

  @JsonProperty("id")
  private JsonNullable<String> id;

  @JsonProperty("uid")
  private JsonNullable<String> uid;

  @JsonProperty("verification")
  private JsonNullable<Verification> verification;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getEmail() {
    return email.orElse(null);
  }

  @JsonIgnore
  public String getRole() {
    return role.orElse(null);
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getUid() {
    return uid.orElse(null);
  }

  @JsonIgnore
  public Verification getVerification() {
    return verification.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SigningStepsRecipients1Builder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public SigningStepsRecipients1Builder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public SigningStepsRecipients1Builder email(String value) {
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> role = JsonNullable.undefined();

    @JsonProperty("role")
    public SigningStepsRecipients1Builder role(String value) {
      this.role = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public SigningStepsRecipients1Builder id(String value) {
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> uid = JsonNullable.undefined();

    @JsonProperty("uid")
    public SigningStepsRecipients1Builder uid(String value) {
      this.uid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Verification> verification = JsonNullable.undefined();

    @JsonProperty("verification")
    public SigningStepsRecipients1Builder verification(Verification value) {
      this.verification = JsonNullable.of(value);
      return this;
    }
  }
}
