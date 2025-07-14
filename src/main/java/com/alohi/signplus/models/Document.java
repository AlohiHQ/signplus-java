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
public class Document {

  /**
   * Unique identifier of the document
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Name of the document
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Filename of the document
   */
  @JsonProperty("filename")
  private JsonNullable<String> filename;

  /**
   * Number of pages in the document
   */
  @JsonProperty("page_count")
  private JsonNullable<Long> pageCount;

  /**
   * List of pages in the document
   */
  @JsonProperty("pages")
  private JsonNullable<List<Page>> pages;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getFilename() {
    return filename.orElse(null);
  }

  @JsonIgnore
  public Long getPageCount() {
    return pageCount.orElse(null);
  }

  @JsonIgnore
  public List<Page> getPages() {
    return pages.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class DocumentBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public DocumentBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public DocumentBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> filename = JsonNullable.undefined();

    @JsonProperty("filename")
    public DocumentBuilder filename(String value) {
      if (value == null) {
        throw new IllegalStateException("filename cannot be null");
      }
      this.filename = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> pageCount = JsonNullable.undefined();

    @JsonProperty("page_count")
    public DocumentBuilder pageCount(Long value) {
      if (value == null) {
        throw new IllegalStateException("pageCount cannot be null");
      }
      this.pageCount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<Page>> pages = JsonNullable.undefined();

    @JsonProperty("pages")
    public DocumentBuilder pages(List<Page> value) {
      if (value == null) {
        throw new IllegalStateException("pages cannot be null");
      }
      this.pages = JsonNullable.of(value);
      return this;
    }
  }
}
