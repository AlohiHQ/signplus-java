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
public class AttachmentPlaceholderFile {

  /**
   * ID of the file
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Name of the file
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Size of the file in bytes
   */
  @JsonProperty("size")
  private JsonNullable<Long> size;

  /**
   * MIME type of the file
   */
  @JsonProperty("mimetype")
  private JsonNullable<String> mimetype;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public Long getSize() {
    return size.orElse(null);
  }

  @JsonIgnore
  public String getMimetype() {
    return mimetype.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AttachmentPlaceholderFileBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public AttachmentPlaceholderFileBuilder id(String value) {
      if (value == null) {
        throw new IllegalStateException("id cannot be null");
      }
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public AttachmentPlaceholderFileBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> size = JsonNullable.undefined();

    @JsonProperty("size")
    public AttachmentPlaceholderFileBuilder size(Long value) {
      if (value == null) {
        throw new IllegalStateException("size cannot be null");
      }
      this.size = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> mimetype = JsonNullable.undefined();

    @JsonProperty("mimetype")
    public AttachmentPlaceholderFileBuilder mimetype(String value) {
      if (value == null) {
        throw new IllegalStateException("mimetype cannot be null");
      }
      this.mimetype = JsonNullable.of(value);
      return this;
    }
  }
}
