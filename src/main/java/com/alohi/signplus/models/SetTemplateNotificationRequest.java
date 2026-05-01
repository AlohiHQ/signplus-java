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
public class SetTemplateNotificationRequest {

  @JsonProperty("subject")
  private JsonNullable<String> subject;

  @JsonProperty("message")
  private JsonNullable<String> message;

  @JsonProperty("reminder_interval")
  private JsonNullable<Double> reminderInterval;

  @JsonIgnore
  public String getSubject() {
    return subject.orElse(null);
  }

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  @JsonIgnore
  public Double getReminderInterval() {
    return reminderInterval.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SetTemplateNotificationRequestBuilder {

    private JsonNullable<String> subject = JsonNullable.undefined();

    @JsonProperty("subject")
    public SetTemplateNotificationRequestBuilder subject(String value) {
      this.subject = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> message = JsonNullable.undefined();

    @JsonProperty("message")
    public SetTemplateNotificationRequestBuilder message(String value) {
      this.message = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> reminderInterval = JsonNullable.undefined();

    @JsonProperty("reminder_interval")
    public SetTemplateNotificationRequestBuilder reminderInterval(Double value) {
      this.reminderInterval = JsonNullable.of(value);
      return this;
    }
  }
}
