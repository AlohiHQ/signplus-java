package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class Template {

  /**
   * Unique identifier of the template
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Name of the template
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Comment for the template
   */
  @JsonProperty("comment")
  private JsonNullable<String> comment;

  /**
   * Total number of pages in the template
   */
  @JsonProperty("pages")
  private JsonNullable<Long> pages;

  /**
   * Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes)
   */
  @JsonProperty("legality_level")
  private JsonNullable<EnvelopeLegalityLevel> legalityLevel;

  /**
   * Unix timestamp of the creation date
   */
  @JsonProperty("created_at")
  private JsonNullable<Long> createdAt;

  /**
   * Unix timestamp of the last modification date
   */
  @JsonProperty("updated_at")
  private JsonNullable<Long> updatedAt;

  /**
   * Expiration delay added to the current time when an envelope is created from this template
   */
  @JsonProperty("expiration_delay")
  private JsonNullable<Long> expirationDelay;

  /**
   * Number of recipients in the envelope
   */
  @JsonProperty("num_recipients")
  private JsonNullable<Long> numRecipients;

  @JsonProperty("signing_steps")
  private JsonNullable<List<TemplateSigningStep>> signingSteps;

  @JsonProperty("documents")
  private JsonNullable<List<Document>> documents;

  @JsonProperty("notification")
  private JsonNullable<EnvelopeNotification> notification;

  /**
   * List of dynamic fields
   */
  @JsonProperty("dynamic_fields")
  private JsonNullable<List<String>> dynamicFields;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getComment() {
    return comment.orElse(null);
  }

  @JsonIgnore
  public Long getPages() {
    return pages.orElse(null);
  }

  @JsonIgnore
  public EnvelopeLegalityLevel getLegalityLevel() {
    return legalityLevel.orElse(null);
  }

  @JsonIgnore
  public Long getCreatedAt() {
    return createdAt.orElse(null);
  }

  @JsonIgnore
  public Long getUpdatedAt() {
    return updatedAt.orElse(null);
  }

  @JsonIgnore
  public Long getExpirationDelay() {
    return expirationDelay.orElse(null);
  }

  @JsonIgnore
  public Long getNumRecipients() {
    return numRecipients.orElse(null);
  }

  @JsonIgnore
  public List<TemplateSigningStep> getSigningSteps() {
    return signingSteps.orElse(null);
  }

  @JsonIgnore
  public List<Document> getDocuments() {
    return documents.orElse(null);
  }

  @JsonIgnore
  public EnvelopeNotification getNotification() {
    return notification.orElse(null);
  }

  @JsonIgnore
  public List<String> getDynamicFields() {
    return dynamicFields.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TemplateBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public TemplateBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public TemplateBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> comment = JsonNullable.undefined();

    @JsonProperty("comment")
    public TemplateBuilder comment(String value) {
      if (value == null) {
        throw new IllegalStateException("comment cannot be null");
      }
      this.comment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> pages = JsonNullable.undefined();

    @JsonProperty("pages")
    public TemplateBuilder pages(Long value) {
      if (value == null) {
        throw new IllegalStateException("pages cannot be null");
      }
      this.pages = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<EnvelopeLegalityLevel> legalityLevel = JsonNullable.undefined();

    @JsonProperty("legality_level")
    public TemplateBuilder legalityLevel(EnvelopeLegalityLevel value) {
      if (value == null) {
        throw new IllegalStateException("legalityLevel cannot be null");
      }
      this.legalityLevel = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> createdAt = JsonNullable.undefined();

    @JsonProperty("created_at")
    public TemplateBuilder createdAt(Long value) {
      if (value == null) {
        throw new IllegalStateException("createdAt cannot be null");
      }
      this.createdAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> updatedAt = JsonNullable.undefined();

    @JsonProperty("updated_at")
    public TemplateBuilder updatedAt(Long value) {
      if (value == null) {
        throw new IllegalStateException("updatedAt cannot be null");
      }
      this.updatedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> expirationDelay = JsonNullable.undefined();

    @JsonProperty("expiration_delay")
    public TemplateBuilder expirationDelay(Long value) {
      if (value == null) {
        throw new IllegalStateException("expirationDelay cannot be null");
      }
      this.expirationDelay = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> numRecipients = JsonNullable.undefined();

    @JsonProperty("num_recipients")
    public TemplateBuilder numRecipients(Long value) {
      if (value == null) {
        throw new IllegalStateException("numRecipients cannot be null");
      }
      this.numRecipients = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<TemplateSigningStep>> signingSteps = JsonNullable.undefined();

    @JsonProperty("signing_steps")
    public TemplateBuilder signingSteps(List<TemplateSigningStep> value) {
      if (value == null) {
        throw new IllegalStateException("signingSteps cannot be null");
      }
      this.signingSteps = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<Document>> documents = JsonNullable.undefined();

    @JsonProperty("documents")
    public TemplateBuilder documents(List<Document> value) {
      if (value == null) {
        throw new IllegalStateException("documents cannot be null");
      }
      this.documents = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<EnvelopeNotification> notification = JsonNullable.undefined();

    @JsonProperty("notification")
    public TemplateBuilder notification(EnvelopeNotification value) {
      if (value == null) {
        throw new IllegalStateException("notification cannot be null");
      }
      this.notification = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> dynamicFields = JsonNullable.undefined();

    @JsonProperty("dynamic_fields")
    public TemplateBuilder dynamicFields(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("dynamicFields cannot be null");
      }
      this.dynamicFields = JsonNullable.of(value);
      return this;
    }
  }
}
