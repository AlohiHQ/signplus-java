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
public class SetEnvelopeNotificationRequest {

  @JsonProperty("subject")
  private JsonNullable<String> subject;

  @JsonProperty("message")
  private JsonNullable<String> message;

  @JsonProperty("reminder_interval")
  private JsonNullable<String> reminderInterval;

  @JsonIgnore
  public String getSubject() {
    return subject.orElse(null);
  }

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  @JsonIgnore
  public String getReminderInterval() {
    return reminderInterval.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetEnvelopeNotificationRequestBuilder {

    private JsonNullable<String> subject = JsonNullable.undefined();

    @JsonProperty("subject")
    public SetEnvelopeNotificationRequestBuilder subject(String value) {
      this.subject = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> message = JsonNullable.undefined();

    @JsonProperty("message")
    public SetEnvelopeNotificationRequestBuilder message(String value) {
      this.message = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> reminderInterval = JsonNullable.undefined();

    @JsonProperty("reminder_interval")
    public SetEnvelopeNotificationRequestBuilder reminderInterval(String value) {
      this.reminderInterval = JsonNullable.of(value);
      return this;
    }
  }
}
