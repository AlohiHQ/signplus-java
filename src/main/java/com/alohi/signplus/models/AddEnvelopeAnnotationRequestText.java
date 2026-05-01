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
public class AddEnvelopeAnnotationRequestText {

  @JsonProperty("size")
  private JsonNullable<Double> size;

  @JsonProperty("color")
  private JsonNullable<Double> color;

  @JsonProperty("value")
  private JsonNullable<String> value;

  @JsonProperty("tooltip")
  private JsonNullable<String> tooltip;

  @JsonProperty("dynamic_field_name")
  private JsonNullable<String> dynamicFieldName;

  @JsonProperty("font")
  private JsonNullable<TextFont1> font;

  @JsonIgnore
  public Double getSize() {
    return size.orElse(null);
  }

  @JsonIgnore
  public Double getColor() {
    return color.orElse(null);
  }

  @JsonIgnore
  public String getValue() {
    return value.orElse(null);
  }

  @JsonIgnore
  public String getTooltip() {
    return tooltip.orElse(null);
  }

  @JsonIgnore
  public String getDynamicFieldName() {
    return dynamicFieldName.orElse(null);
  }

  @JsonIgnore
  public TextFont1 getFont() {
    return font.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddEnvelopeAnnotationRequestTextBuilder {

    private JsonNullable<Double> size = JsonNullable.undefined();

    @JsonProperty("size")
    public AddEnvelopeAnnotationRequestTextBuilder size(Double value) {
      this.size = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> color = JsonNullable.undefined();

    @JsonProperty("color")
    public AddEnvelopeAnnotationRequestTextBuilder color(Double value) {
      this.color = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> value = JsonNullable.undefined();

    @JsonProperty("value")
    public AddEnvelopeAnnotationRequestTextBuilder value(String value) {
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> tooltip = JsonNullable.undefined();

    @JsonProperty("tooltip")
    public AddEnvelopeAnnotationRequestTextBuilder tooltip(String value) {
      this.tooltip = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> dynamicFieldName = JsonNullable.undefined();

    @JsonProperty("dynamic_field_name")
    public AddEnvelopeAnnotationRequestTextBuilder dynamicFieldName(String value) {
      this.dynamicFieldName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<TextFont1> font = JsonNullable.undefined();

    @JsonProperty("font")
    public AddEnvelopeAnnotationRequestTextBuilder font(TextFont1 value) {
      this.font = JsonNullable.of(value);
      return this;
    }
  }
}
