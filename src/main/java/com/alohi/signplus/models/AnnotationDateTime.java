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

/**
 * Date annotation (null if annotation is not a date)
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationDateTime {

  /**
   * Font size of the text in pt
   */
  @JsonProperty("size")
  private JsonNullable<Double> size;

  @JsonProperty("font")
  private JsonNullable<AnnotationFont> font;

  /**
   * Color of the text in hex format
   */
  @JsonProperty("color")
  private JsonNullable<String> color;

  /**
   * Whether the date should be automatically filled
   */
  @JsonProperty("auto_fill")
  private JsonNullable<Boolean> autoFill;

  /**
   * Timezone of the date
   */
  @JsonProperty("timezone")
  private JsonNullable<String> timezone;

  /**
   * Unix timestamp of the date
   */
  @JsonProperty("timestamp")
  private JsonNullable<Long> timestamp;

  /**
   * Format of the date time (DMY_NUMERIC_SLASH is day/month/year with slashes, MDY_NUMERIC_SLASH is month/day/year with slashes, YMD_NUMERIC_SLASH is year/month/day with slashes, DMY_NUMERIC_DASH_SHORT is day/month/year with dashes, DMY_NUMERIC_DASH is day/month/year with dashes, YMD_NUMERIC_DASH is year/month/day with dashes, MDY_TEXT_DASH_SHORT is month/day/year with dashes, MDY_TEXT_SPACE_SHORT is month/day/year with spaces, MDY_TEXT_SPACE is month/day/year with spaces)
   */
  @JsonProperty("format")
  private JsonNullable<AnnotationDateTimeFormat> format;

  @JsonIgnore
  public Double getSize() {
    return size.orElse(null);
  }

  @JsonIgnore
  public AnnotationFont getFont() {
    return font.orElse(null);
  }

  @JsonIgnore
  public String getColor() {
    return color.orElse(null);
  }

  @JsonIgnore
  public Boolean getAutoFill() {
    return autoFill.orElse(null);
  }

  @JsonIgnore
  public String getTimezone() {
    return timezone.orElse(null);
  }

  @JsonIgnore
  public Long getTimestamp() {
    return timestamp.orElse(null);
  }

  @JsonIgnore
  public AnnotationDateTimeFormat getFormat() {
    return format.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AnnotationDateTimeBuilder {

    private JsonNullable<Double> size = JsonNullable.undefined();

    @JsonProperty("size")
    public AnnotationDateTimeBuilder size(Double value) {
      if (value == null) {
        throw new IllegalStateException("size cannot be null");
      }
      this.size = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationFont> font = JsonNullable.undefined();

    @JsonProperty("font")
    public AnnotationDateTimeBuilder font(AnnotationFont value) {
      if (value == null) {
        throw new IllegalStateException("font cannot be null");
      }
      this.font = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> color = JsonNullable.undefined();

    @JsonProperty("color")
    public AnnotationDateTimeBuilder color(String value) {
      if (value == null) {
        throw new IllegalStateException("color cannot be null");
      }
      this.color = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> autoFill = JsonNullable.undefined();

    @JsonProperty("auto_fill")
    public AnnotationDateTimeBuilder autoFill(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("autoFill cannot be null");
      }
      this.autoFill = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> timezone = JsonNullable.undefined();

    @JsonProperty("timezone")
    public AnnotationDateTimeBuilder timezone(String value) {
      if (value == null) {
        throw new IllegalStateException("timezone cannot be null");
      }
      this.timezone = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> timestamp = JsonNullable.undefined();

    @JsonProperty("timestamp")
    public AnnotationDateTimeBuilder timestamp(Long value) {
      if (value == null) {
        throw new IllegalStateException("timestamp cannot be null");
      }
      this.timestamp = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationDateTimeFormat> format = JsonNullable.undefined();

    @JsonProperty("format")
    public AnnotationDateTimeBuilder format(AnnotationDateTimeFormat value) {
      if (value == null) {
        throw new IllegalStateException("format cannot be null");
      }
      this.format = JsonNullable.of(value);
      return this;
    }
  }
}
