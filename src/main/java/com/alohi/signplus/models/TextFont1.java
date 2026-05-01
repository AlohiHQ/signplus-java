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
public class TextFont1 {

  @JsonProperty("family")
  private JsonNullable<String> family;

  @JsonProperty("italic")
  private JsonNullable<Boolean> italic;

  @JsonProperty("bold")
  private JsonNullable<Boolean> bold;

  @JsonIgnore
  public String getFamily() {
    return family.orElse(null);
  }

  @JsonIgnore
  public Boolean getItalic() {
    return italic.orElse(null);
  }

  @JsonIgnore
  public Boolean getBold() {
    return bold.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TextFont1Builder {

    private JsonNullable<String> family = JsonNullable.undefined();

    @JsonProperty("family")
    public TextFont1Builder family(String value) {
      this.family = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> italic = JsonNullable.undefined();

    @JsonProperty("italic")
    public TextFont1Builder italic(Boolean value) {
      this.italic = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> bold = JsonNullable.undefined();

    @JsonProperty("bold")
    public TextFont1Builder bold(Boolean value) {
      this.bold = JsonNullable.of(value);
      return this;
    }
  }
}
