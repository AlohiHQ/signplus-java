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
public class AddTemplateAnnotationRequestText {

  @JsonProperty("size")
  private JsonNullable<String> size;

  @JsonProperty("color")
  private JsonNullable<String> color;

  @JsonProperty("value")
  private JsonNullable<String> value;

  @JsonProperty("tooltip")
  private JsonNullable<String> tooltip;

  @JsonProperty("dynamic_field_name")
  private JsonNullable<String> dynamicFieldName;

  @JsonProperty("font")
  private JsonNullable<TextFont2> font;

  @JsonIgnore
  public String getSize() {
    return size.orElse(null);
  }

  @JsonIgnore
  public String getColor() {
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
  public TextFont2 getFont() {
    return font.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddTemplateAnnotationRequestTextBuilder {

    private JsonNullable<String> size = JsonNullable.undefined();

    @JsonProperty("size")
    public AddTemplateAnnotationRequestTextBuilder size(String value) {
      this.size = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> color = JsonNullable.undefined();

    @JsonProperty("color")
    public AddTemplateAnnotationRequestTextBuilder color(String value) {
      this.color = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> value = JsonNullable.undefined();

    @JsonProperty("value")
    public AddTemplateAnnotationRequestTextBuilder value(String value) {
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> tooltip = JsonNullable.undefined();

    @JsonProperty("tooltip")
    public AddTemplateAnnotationRequestTextBuilder tooltip(String value) {
      this.tooltip = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> dynamicFieldName = JsonNullable.undefined();

    @JsonProperty("dynamic_field_name")
    public AddTemplateAnnotationRequestTextBuilder dynamicFieldName(String value) {
      this.dynamicFieldName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<TextFont2> font = JsonNullable.undefined();

    @JsonProperty("font")
    public AddTemplateAnnotationRequestTextBuilder font(TextFont2 value) {
      this.font = JsonNullable.of(value);
      return this;
    }
  }
}
