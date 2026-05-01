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
public class AddTemplateAnnotationRequestDatetime {

  @JsonProperty("size")
  private JsonNullable<String> size;

  @JsonProperty("font")
  private JsonNullable<DatetimeFont2> font;

  @JsonProperty("color")
  private JsonNullable<String> color;

  @JsonProperty("auto_fill")
  private JsonNullable<String> autoFill;

  @JsonProperty("timezone")
  private JsonNullable<String> timezone;

  @JsonProperty("timestamp")
  private JsonNullable<String> timestamp;

  @JsonProperty("format")
  private JsonNullable<String> format;

  @JsonIgnore
  public String getSize() {
    return size.orElse(null);
  }

  @JsonIgnore
  public DatetimeFont2 getFont() {
    return font.orElse(null);
  }

  @JsonIgnore
  public String getColor() {
    return color.orElse(null);
  }

  @JsonIgnore
  public String getAutoFill() {
    return autoFill.orElse(null);
  }

  @JsonIgnore
  public String getTimezone() {
    return timezone.orElse(null);
  }

  @JsonIgnore
  public String getTimestamp() {
    return timestamp.orElse(null);
  }

  @JsonIgnore
  public String getFormat() {
    return format.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddTemplateAnnotationRequestDatetimeBuilder {

    private JsonNullable<String> size = JsonNullable.undefined();

    @JsonProperty("size")
    public AddTemplateAnnotationRequestDatetimeBuilder size(String value) {
      this.size = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<DatetimeFont2> font = JsonNullable.undefined();

    @JsonProperty("font")
    public AddTemplateAnnotationRequestDatetimeBuilder font(DatetimeFont2 value) {
      this.font = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> color = JsonNullable.undefined();

    @JsonProperty("color")
    public AddTemplateAnnotationRequestDatetimeBuilder color(String value) {
      this.color = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> autoFill = JsonNullable.undefined();

    @JsonProperty("auto_fill")
    public AddTemplateAnnotationRequestDatetimeBuilder autoFill(String value) {
      this.autoFill = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> timezone = JsonNullable.undefined();

    @JsonProperty("timezone")
    public AddTemplateAnnotationRequestDatetimeBuilder timezone(String value) {
      this.timezone = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> timestamp = JsonNullable.undefined();

    @JsonProperty("timestamp")
    public AddTemplateAnnotationRequestDatetimeBuilder timestamp(String value) {
      this.timestamp = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> format = JsonNullable.undefined();

    @JsonProperty("format")
    public AddTemplateAnnotationRequestDatetimeBuilder format(String value) {
      this.format = JsonNullable.of(value);
      return this;
    }
  }
}
