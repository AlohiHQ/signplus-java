package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Date annotation (null if annotation is not a date)
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationDateTime {

  /**
   * Font size of the text in pt
   */
  private Double size;

  private AnnotationFont font;

  /**
   * Color of the text in hex format
   */
  private String color;

  /**
   * Whether the date should be automatically filled
   */
  @JsonProperty("auto_fill")
  private Boolean autoFill;

  /**
   * Timezone of the date
   */
  private String timezone;

  /**
   * Unix timestamp of the date
   */
  private Long timestamp;

  /**
   * Format of the date time (DMY_NUMERIC_SLASH is day/month/year with slashes, MDY_NUMERIC_SLASH is month/day/year with slashes, YMD_NUMERIC_SLASH is year/month/day with slashes, DMY_NUMERIC_DASH_SHORT is day/month/year with dashes, DMY_NUMERIC_DASH is day/month/year with dashes, YMD_NUMERIC_DASH is year/month/day with dashes, MDY_TEXT_DASH_SHORT is month/day/year with dashes, MDY_TEXT_SPACE_SHORT is month/day/year with spaces, MDY_TEXT_SPACE is month/day/year with spaces)
   */
  private AnnotationDateTimeFormat format;
}
