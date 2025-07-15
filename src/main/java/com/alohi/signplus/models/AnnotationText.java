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
 * Text annotation (null if annotation is not a text)
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationText {

  /**
   * Font size of the text in pt
   */
  @JsonProperty("size")
  private JsonNullable<Double> size;

  /**
   * Text color in 32bit representation
   */
  @JsonProperty("color")
  private JsonNullable<Double> color;

  /**
   * Text content of the annotation
   */
  @JsonProperty("value")
  private JsonNullable<String> value;

  /**
   * Tooltip of the annotation
   */
  @JsonProperty("tooltip")
  private JsonNullable<String> tooltip;

  /**
   * Name of the dynamic field
   */
  @JsonProperty("dynamic_field_name")
  private JsonNullable<String> dynamicFieldName;

  @JsonProperty("font")
  private JsonNullable<AnnotationFont> font;

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
  public AnnotationFont getFont() {
    return font.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AnnotationTextBuilder {

    private JsonNullable<Double> size = JsonNullable.undefined();

    @JsonProperty("size")
    public AnnotationTextBuilder size(Double value) {
      if (value == null) {
        throw new IllegalStateException("size cannot be null");
      }
      this.size = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> color = JsonNullable.undefined();

    @JsonProperty("color")
    public AnnotationTextBuilder color(Double value) {
      if (value == null) {
        throw new IllegalStateException("color cannot be null");
      }
      this.color = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> value = JsonNullable.undefined();

    @JsonProperty("value")
    public AnnotationTextBuilder value(String value) {
      if (value == null) {
        throw new IllegalStateException("value cannot be null");
      }
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> tooltip = JsonNullable.undefined();

    @JsonProperty("tooltip")
    public AnnotationTextBuilder tooltip(String value) {
      if (value == null) {
        throw new IllegalStateException("tooltip cannot be null");
      }
      this.tooltip = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> dynamicFieldName = JsonNullable.undefined();

    @JsonProperty("dynamic_field_name")
    public AnnotationTextBuilder dynamicFieldName(String value) {
      if (value == null) {
        throw new IllegalStateException("dynamicFieldName cannot be null");
      }
      this.dynamicFieldName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationFont> font = JsonNullable.undefined();

    @JsonProperty("font")
    public AnnotationTextBuilder font(AnnotationFont value) {
      if (value == null) {
        throw new IllegalStateException("font cannot be null");
      }
      this.font = JsonNullable.of(value);
      return this;
    }
  }
}
