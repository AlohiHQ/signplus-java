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
public class ListEnvelopesRequest {

  /**
   * Name of the envelope
   */
  private String name;

  /**
   * List of tags
   */
  private List<String> tags;

  /**
   * Comment of the envelope
   */
  private String comment;

  /**
   * List of envelope IDs
   */
  private List<String> ids;

  /**
   * List of envelope statuses
   */
  private List<EnvelopeStatus> statuses;

  /**
   * List of folder IDs
   */
  @JsonProperty("folder_ids")
  private List<String> folderIds;

  /**
   * Whether to only list envelopes in the root folder
   */
  @JsonProperty("only_root_folder")
  private Boolean onlyRootFolder;

  /**
   * Unix timestamp of the start date
   */
  @JsonProperty("date_from")
  private Long dateFrom;

  /**
   * Unix timestamp of the end date
   */
  @JsonProperty("date_to")
  private Long dateTo;

  /**
   * Unique identifier of the user
   */
  private String uid;

  private Long first;

  private Long last;

  private String after;

  private String before;

  /**
   * Field to order envelopes by
   */
  @JsonProperty("order_field")
  private EnvelopeOrderField orderField;

  /**
   * Whether to order envelopes in ascending order
   */
  private Boolean ascending;

  /**
   * Whether to include envelopes in the trash
   */
  @JsonProperty("include_trash")
  private Boolean includeTrash;
}
