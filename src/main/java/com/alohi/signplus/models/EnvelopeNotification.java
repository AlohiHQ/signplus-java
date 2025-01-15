package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

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
  private String subject;

  /**
   * Message of the notification
   */
  private String message;

  /**
   * Interval in days to send reminder
   */
  @JsonProperty("reminder_interval")
  private Long reminderInterval;
}
