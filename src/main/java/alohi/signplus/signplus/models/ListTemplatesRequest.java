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
public class ListTemplatesRequest {

  /**
   * Name of the template
   */
  private String name;

  /**
   * List of tag templates
   */
  private List<String> tags;

  /**
   * List of templates IDs
   */
  private List<String> ids;

  private Long first;

  private Long last;

  private String after;

  private String before;

  /**
   * Field to order templates by
   */
  @JsonProperty("order_field")
  private TemplateOrderField orderField;

  /**
   * Whether to order templates in ascending order
   */
  private Boolean ascending;
}
