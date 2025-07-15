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
public class EnvelopeNotification {

  /**
   * Subject of the notification
   */
  @JsonProperty("subject")
  private JsonNullable<String> subject;

  /**
   * Message of the notification
   */
  @JsonProperty("message")
  private JsonNullable<String> message;

  /**
   * Interval in days to send reminder
   */
  @JsonProperty("reminder_interval")
  private JsonNullable<Long> reminderInterval;

  @JsonIgnore
  public String getSubject() {
    return subject.orElse(null);
  }

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  @JsonIgnore
  public Long getReminderInterval() {
    return reminderInterval.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class EnvelopeNotificationBuilder {

    private JsonNullable<String> subject = JsonNullable.undefined();

    @JsonProperty("subject")
    public EnvelopeNotificationBuilder subject(String value) {
      if (value == null) {
        throw new IllegalStateException("subject cannot be null");
      }
      this.subject = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> message = JsonNullable.undefined();

    @JsonProperty("message")
    public EnvelopeNotificationBuilder message(String value) {
      if (value == null) {
        throw new IllegalStateException("message cannot be null");
      }
      this.message = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> reminderInterval = JsonNullable.undefined();

    @JsonProperty("reminder_interval")
    public EnvelopeNotificationBuilder reminderInterval(Long value) {
      if (value == null) {
        throw new IllegalStateException("reminderInterval cannot be null");
      }
      this.reminderInterval = JsonNullable.of(value);
      return this;
    }
  }
}
