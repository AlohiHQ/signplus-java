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

  /**
   * Name of the template
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * List of tag templates
   */
  @JsonProperty("tags")
  private JsonNullable<List<String>> tags;

  /**
   * List of templates IDs
   */
  @JsonProperty("ids")
  private JsonNullable<List<String>> ids;

  @JsonProperty("first")
  private JsonNullable<Long> first;

  @JsonProperty("last")
  private JsonNullable<Long> last;

  @JsonProperty("after")
  private JsonNullable<String> after;

  @JsonProperty("before")
  private JsonNullable<String> before;

  /**
   * Field to order templates by
   */
  @JsonProperty("order_field")
  private JsonNullable<TemplateOrderField> orderField;

  /**
   * Whether to order templates in ascending order
   */
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
  public Long getFirst() {
    return first.orElse(null);
  }

  @JsonIgnore
  public Long getLast() {
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
  public TemplateOrderField getOrderField() {
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
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> tags = JsonNullable.undefined();

    @JsonProperty("tags")
    public ListTemplatesRequestBuilder tags(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("tags cannot be null");
      }
      this.tags = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> ids = JsonNullable.undefined();

    @JsonProperty("ids")
    public ListTemplatesRequestBuilder ids(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("ids cannot be null");
      }
      this.ids = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> first = JsonNullable.undefined();

    @JsonProperty("first")
    public ListTemplatesRequestBuilder first(Long value) {
      if (value == null) {
        throw new IllegalStateException("first cannot be null");
      }
      this.first = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> last = JsonNullable.undefined();

    @JsonProperty("last")
    public ListTemplatesRequestBuilder last(Long value) {
      if (value == null) {
        throw new IllegalStateException("last cannot be null");
      }
      this.last = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> after = JsonNullable.undefined();

    @JsonProperty("after")
    public ListTemplatesRequestBuilder after(String value) {
      if (value == null) {
        throw new IllegalStateException("after cannot be null");
      }
      this.after = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> before = JsonNullable.undefined();

    @JsonProperty("before")
    public ListTemplatesRequestBuilder before(String value) {
      if (value == null) {
        throw new IllegalStateException("before cannot be null");
      }
      this.before = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<TemplateOrderField> orderField = JsonNullable.undefined();

    @JsonProperty("order_field")
    public ListTemplatesRequestBuilder orderField(TemplateOrderField value) {
      if (value == null) {
        throw new IllegalStateException("orderField cannot be null");
      }
      this.orderField = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> ascending = JsonNullable.undefined();

    @JsonProperty("ascending")
    public ListTemplatesRequestBuilder ascending(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("ascending cannot be null");
      }
      this.ascending = JsonNullable.of(value);
      return this;
    }
  }
}
