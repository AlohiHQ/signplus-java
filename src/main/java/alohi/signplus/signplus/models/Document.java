package alohi.signplus.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class Document {

  /**
   * Unique identifier of the document
   */
  private String id;

  /**
   * Name of the document
   */
  private String name;

  /**
   * Filename of the document
   */
  private String filename;

  /**
   * Number of pages in the document
   */
  @JsonProperty("page_count")
  private Long pageCount;

  /**
   * List of pages in the document
   */
  private List<Page> pages;
}
