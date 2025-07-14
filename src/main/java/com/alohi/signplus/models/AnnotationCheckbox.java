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
 * Checkbox annotation (null if annotation is not a checkbox)
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class AnnotationCheckbox {

  /**
   * Whether the checkbox is checked
   */
  @JsonProperty("checked")
  private JsonNullable<Boolean> checked;

  /**
   * Style of the checkbox
   */
  @JsonProperty("style")
  private JsonNullable<AnnotationCheckboxStyle> style;

  @JsonIgnore
  public Boolean getChecked() {
    return checked.orElse(null);
  }

  @JsonIgnore
  public AnnotationCheckboxStyle getStyle() {
    return style.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AnnotationCheckboxBuilder {

    private JsonNullable<Boolean> checked = JsonNullable.undefined();

    @JsonProperty("checked")
    public AnnotationCheckboxBuilder checked(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("checked cannot be null");
      }
      this.checked = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AnnotationCheckboxStyle> style = JsonNullable.undefined();

    @JsonProperty("style")
    public AnnotationCheckboxBuilder style(AnnotationCheckboxStyle value) {
      if (value == null) {
        throw new IllegalStateException("style cannot be null");
      }
      this.style = JsonNullable.of(value);
      return this;
    }
  }
}
