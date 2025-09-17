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
public class Envelope {

  /**
   * Unique identifier of the envelope
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Name of the envelope
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Comment for the envelope
   */
  @JsonProperty("comment")
  private JsonNullable<String> comment;

  /**
   * Total number of pages in the envelope
   */
  @JsonProperty("pages")
  private JsonNullable<Long> pages;

  /**
   * Flow type of the envelope (REQUEST_SIGNATURE is a request for signature, SIGN_MYSELF is a self-signing flow)
   */
  @JsonProperty("flow_type")
  private JsonNullable<EnvelopeFlowType> flowType;

  /**
   * Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes)
   */
  @JsonProperty("legality_level")
  private JsonNullable<EnvelopeLegalityLevel> legalityLevel;

  /**
   * Status of the envelope
   */
  @JsonProperty("status")
  private JsonNullable<EnvelopeStatus> status;

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
   * Unix timestamp of the expiration date
   */
  @JsonProperty("expires_at")
  private JsonNullable<Long> expiresAt;

  /**
   * Number of recipients in the envelope
   */
  @JsonProperty("num_recipients")
  private JsonNullable<Long> numRecipients;

  /**
   * Whether the envelope can be duplicated
   */
  @JsonProperty("is_duplicable")
  private JsonNullable<Boolean> isDuplicable;

  @JsonProperty("signing_steps")
  private JsonNullable<List<SigningStep>> signingSteps;

  @JsonProperty("documents")
  private JsonNullable<List<Document>> documents;

  @JsonProperty("notification")
  private JsonNullable<EnvelopeNotification> notification;

  @JsonProperty("attachments")
  private JsonNullable<EnvelopeAttachments> attachments;

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
  public EnvelopeFlowType getFlowType() {
    return flowType.orElse(null);
  }

  @JsonIgnore
  public EnvelopeLegalityLevel getLegalityLevel() {
    return legalityLevel.orElse(null);
  }

  @JsonIgnore
  public EnvelopeStatus getStatus() {
    return status.orElse(null);
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
  public Long getExpiresAt() {
    return expiresAt.orElse(null);
  }

  @JsonIgnore
  public Long getNumRecipients() {
    return numRecipients.orElse(null);
  }

  @JsonIgnore
  public Boolean getIsDuplicable() {
    return isDuplicable.orElse(null);
  }

  @JsonIgnore
  public List<SigningStep> getSigningSteps() {
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
  public EnvelopeAttachments getAttachments() {
    return attachments.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class EnvelopeBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public EnvelopeBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public EnvelopeBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> comment = JsonNullable.undefined();

    @JsonProperty("comment")
    public EnvelopeBuilder comment(String value) {
      if (value == null) {
        throw new IllegalStateException("comment cannot be null");
      }
      this.comment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> pages = JsonNullable.undefined();

    @JsonProperty("pages")
    public EnvelopeBuilder pages(Long value) {
      if (value == null) {
        throw new IllegalStateException("pages cannot be null");
      }
      this.pages = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<EnvelopeFlowType> flowType = JsonNullable.undefined();

    @JsonProperty("flow_type")
    public EnvelopeBuilder flowType(EnvelopeFlowType value) {
      if (value == null) {
        throw new IllegalStateException("flowType cannot be null");
      }
      this.flowType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<EnvelopeLegalityLevel> legalityLevel = JsonNullable.undefined();

    @JsonProperty("legality_level")
    public EnvelopeBuilder legalityLevel(EnvelopeLegalityLevel value) {
      if (value == null) {
        throw new IllegalStateException("legalityLevel cannot be null");
      }
      this.legalityLevel = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<EnvelopeStatus> status = JsonNullable.undefined();

    @JsonProperty("status")
    public EnvelopeBuilder status(EnvelopeStatus value) {
      if (value == null) {
        throw new IllegalStateException("status cannot be null");
      }
      this.status = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> createdAt = JsonNullable.undefined();

    @JsonProperty("created_at")
    public EnvelopeBuilder createdAt(Long value) {
      if (value == null) {
        throw new IllegalStateException("createdAt cannot be null");
      }
      this.createdAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> updatedAt = JsonNullable.undefined();

    @JsonProperty("updated_at")
    public EnvelopeBuilder updatedAt(Long value) {
      if (value == null) {
        throw new IllegalStateException("updatedAt cannot be null");
      }
      this.updatedAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> expiresAt = JsonNullable.undefined();

    @JsonProperty("expires_at")
    public EnvelopeBuilder expiresAt(Long value) {
      if (value == null) {
        throw new IllegalStateException("expiresAt cannot be null");
      }
      this.expiresAt = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> numRecipients = JsonNullable.undefined();

    @JsonProperty("num_recipients")
    public EnvelopeBuilder numRecipients(Long value) {
      if (value == null) {
        throw new IllegalStateException("numRecipients cannot be null");
      }
      this.numRecipients = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> isDuplicable = JsonNullable.undefined();

    @JsonProperty("is_duplicable")
    public EnvelopeBuilder isDuplicable(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("isDuplicable cannot be null");
      }
      this.isDuplicable = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<SigningStep>> signingSteps = JsonNullable.undefined();

    @JsonProperty("signing_steps")
    public EnvelopeBuilder signingSteps(List<SigningStep> value) {
      if (value == null) {
        throw new IllegalStateException("signingSteps cannot be null");
      }
      this.signingSteps = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<Document>> documents = JsonNullable.undefined();

    @JsonProperty("documents")
    public EnvelopeBuilder documents(List<Document> value) {
      if (value == null) {
        throw new IllegalStateException("documents cannot be null");
      }
      this.documents = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<EnvelopeNotification> notification = JsonNullable.undefined();

    @JsonProperty("notification")
    public EnvelopeBuilder notification(EnvelopeNotification value) {
      if (value == null) {
        throw new IllegalStateException("notification cannot be null");
      }
      this.notification = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<EnvelopeAttachments> attachments = JsonNullable.undefined();

    @JsonProperty("attachments")
    public EnvelopeBuilder attachments(EnvelopeAttachments value) {
      if (value == null) {
        throw new IllegalStateException("attachments cannot be null");
      }
      this.attachments = JsonNullable.of(value);
      return this;
    }
  }
}
