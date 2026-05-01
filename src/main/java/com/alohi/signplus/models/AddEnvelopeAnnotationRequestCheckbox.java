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
public class AddEnvelopeAnnotationRequestCheckbox {

  @JsonProperty("checked")
  private JsonNullable<Boolean> checked;

  @JsonProperty("style")
  private JsonNullable<String> style;

  @JsonIgnore
  public Boolean getChecked() {
    return checked.orElse(null);
  }

  @JsonIgnore
  public String getStyle() {
    return style.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AddEnvelopeAnnotationRequestCheckboxBuilder {

    private JsonNullable<Boolean> checked = JsonNullable.undefined();

    @JsonProperty("checked")
    public AddEnvelopeAnnotationRequestCheckboxBuilder checked(Boolean value) {
      this.checked = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> style = JsonNullable.undefined();

    @JsonProperty("style")
    public AddEnvelopeAnnotationRequestCheckboxBuilder style(String value) {
      this.style = JsonNullable.of(value);
      return this;
    }
  }
}
