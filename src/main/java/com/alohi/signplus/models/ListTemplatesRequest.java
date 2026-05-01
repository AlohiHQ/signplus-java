package com.alohi.signplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class ListTemplatesRequest {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("tags")
  private JsonNullable<List<String>> tags;

  @JsonProperty("ids")
  private JsonNullable<List<String>> ids;

  @JsonProperty("first")
  private JsonNullable<Double> first;

  @JsonProperty("last")
  private JsonNullable<Double> last;

  @JsonProperty("after")
  private JsonNullable<String> after;

  @JsonProperty("before")
  private JsonNullable<String> before;

  @JsonProperty("order_field")
  private JsonNullable<String> orderField;

  @JsonProperty("ascending")
  private JsonNullable<Boolean> ascending;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public List<String> getTags() {
    return tags.orElse(null);
  }

  @JsonIgnore
  public List<String> getIds() {
    return ids.orElse(null);
  }

  @JsonIgnore
  public Double getFirst() {
    return first.orElse(null);
  }

  @JsonIgnore
  public Double getLast() {
    return last.orElse(null);
  }

  @JsonIgnore
  public String getAfter() {
    return after.orElse(null);
  }

  @JsonIgnore
  public String getBefore() {
    return before.orElse(null);
  }

  @JsonIgnore
  public String getOrderField() {
    return orderField.orElse(null);
  }

  @JsonIgnore
  public Boolean getAscending() {
    return ascending.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListTemplatesRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public ListTemplatesRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> tags = JsonNullable.undefined();

    @JsonProperty("tags")
    public ListTemplatesRequestBuilder tags(List<String> value) {
      this.tags = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> ids = JsonNullable.undefined();

    @JsonProperty("ids")
    public ListTemplatesRequestBuilder ids(List<String> value) {
      this.ids = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> first = JsonNullable.undefined();

    @JsonProperty("first")
    public ListTemplatesRequestBuilder first(Double value) {
      this.first = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> last = JsonNullable.undefined();

    @JsonProperty("last")
    public ListTemplatesRequestBuilder last(Double value) {
      this.last = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> after = JsonNullable.undefined();

    @JsonProperty("after")
    public ListTemplatesRequestBuilder after(String value) {
      this.after = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> before = JsonNullable.undefined();

    @JsonProperty("before")
    public ListTemplatesRequestBuilder before(String value) {
      this.before = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> orderField = JsonNullable.undefined();

    @JsonProperty("order_field")
    public ListTemplatesRequestBuilder orderField(String value) {
      this.orderField = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> ascending = JsonNullable.undefined();

    @JsonProperty("ascending")
    public ListTemplatesRequestBuilder ascending(Boolean value) {
      this.ascending = JsonNullable.of(value);
      return this;
    }
  }
}
