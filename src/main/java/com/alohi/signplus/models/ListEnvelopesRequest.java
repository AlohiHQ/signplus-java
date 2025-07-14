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
public class ListEnvelopesRequest {

  /**
   * Name of the envelope
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * List of tags
   */
  @JsonProperty("tags")
  private JsonNullable<List<String>> tags;

  /**
   * Comment of the envelope
   */
  @JsonProperty("comment")
  private JsonNullable<String> comment;

  /**
   * List of envelope IDs
   */
  @JsonProperty("ids")
  private JsonNullable<List<String>> ids;

  /**
   * List of envelope statuses
   */
  @JsonProperty("statuses")
  private JsonNullable<List<EnvelopeStatus>> statuses;

  /**
   * List of folder IDs
   */
  @JsonProperty("folder_ids")
  private JsonNullable<List<String>> folderIds;

  /**
   * Whether to only list envelopes in the root folder
   */
  @JsonProperty("only_root_folder")
  private JsonNullable<Boolean> onlyRootFolder;

  /**
   * Unix timestamp of the start date
   */
  @JsonProperty("date_from")
  private JsonNullable<Long> dateFrom;

  /**
   * Unix timestamp of the end date
   */
  @JsonProperty("date_to")
  private JsonNullable<Long> dateTo;

  /**
   * Unique identifier of the user
   */
  @JsonProperty("uid")
  private JsonNullable<String> uid;

  @JsonProperty("first")
  private JsonNullable<Long> first;

  @JsonProperty("last")
  private JsonNullable<Long> last;

  @JsonProperty("after")
  private JsonNullable<String> after;

  @JsonProperty("before")
  private JsonNullable<String> before;

  /**
   * Field to order envelopes by
   */
  @JsonProperty("order_field")
  private JsonNullable<EnvelopeOrderField> orderField;

  /**
   * Whether to order envelopes in ascending order
   */
  @JsonProperty("ascending")
  private JsonNullable<Boolean> ascending;

  /**
   * Whether to include envelopes in the trash
   */
  @JsonProperty("include_trash")
  private JsonNullable<Boolean> includeTrash;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public List<String> getTags() {
    return tags.orElse(null);
  }

  @JsonIgnore
  public String getComment() {
    return comment.orElse(null);
  }

  @JsonIgnore
  public List<String> getIds() {
    return ids.orElse(null);
  }

  @JsonIgnore
  public List<EnvelopeStatus> getStatuses() {
    return statuses.orElse(null);
  }

  @JsonIgnore
  public List<String> getFolderIds() {
    return folderIds.orElse(null);
  }

  @JsonIgnore
  public Boolean getOnlyRootFolder() {
    return onlyRootFolder.orElse(null);
  }

  @JsonIgnore
  public Long getDateFrom() {
    return dateFrom.orElse(null);
  }

  @JsonIgnore
  public Long getDateTo() {
    return dateTo.orElse(null);
  }

  @JsonIgnore
  public String getUid() {
    return uid.orElse(null);
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
  public EnvelopeOrderField getOrderField() {
    return orderField.orElse(null);
  }

  @JsonIgnore
  public Boolean getAscending() {
    return ascending.orElse(null);
  }

  @JsonIgnore
  public Boolean getIncludeTrash() {
    return includeTrash.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListEnvelopesRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public ListEnvelopesRequestBuilder name(String value) {
      if (value == null) {
        throw new IllegalStateException("name cannot be null");
      }
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> tags = JsonNullable.undefined();

    @JsonProperty("tags")
    public ListEnvelopesRequestBuilder tags(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("tags cannot be null");
      }
      this.tags = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> comment = JsonNullable.undefined();

    @JsonProperty("comment")
    public ListEnvelopesRequestBuilder comment(String value) {
      if (value == null) {
        throw new IllegalStateException("comment cannot be null");
      }
      this.comment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> ids = JsonNullable.undefined();

    @JsonProperty("ids")
    public ListEnvelopesRequestBuilder ids(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("ids cannot be null");
      }
      this.ids = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<EnvelopeStatus>> statuses = JsonNullable.undefined();

    @JsonProperty("statuses")
    public ListEnvelopesRequestBuilder statuses(List<EnvelopeStatus> value) {
      if (value == null) {
        throw new IllegalStateException("statuses cannot be null");
      }
      this.statuses = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> folderIds = JsonNullable.undefined();

    @JsonProperty("folder_ids")
    public ListEnvelopesRequestBuilder folderIds(List<String> value) {
      if (value == null) {
        throw new IllegalStateException("folderIds cannot be null");
      }
      this.folderIds = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> onlyRootFolder = JsonNullable.undefined();

    @JsonProperty("only_root_folder")
    public ListEnvelopesRequestBuilder onlyRootFolder(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("onlyRootFolder cannot be null");
      }
      this.onlyRootFolder = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> dateFrom = JsonNullable.undefined();

    @JsonProperty("date_from")
    public ListEnvelopesRequestBuilder dateFrom(Long value) {
      if (value == null) {
        throw new IllegalStateException("dateFrom cannot be null");
      }
      this.dateFrom = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> dateTo = JsonNullable.undefined();

    @JsonProperty("date_to")
    public ListEnvelopesRequestBuilder dateTo(Long value) {
      if (value == null) {
        throw new IllegalStateException("dateTo cannot be null");
      }
      this.dateTo = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> uid = JsonNullable.undefined();

    @JsonProperty("uid")
    public ListEnvelopesRequestBuilder uid(String value) {
      if (value == null) {
        throw new IllegalStateException("uid cannot be null");
      }
      this.uid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> first = JsonNullable.undefined();

    @JsonProperty("first")
    public ListEnvelopesRequestBuilder first(Long value) {
      if (value == null) {
        throw new IllegalStateException("first cannot be null");
      }
      this.first = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> last = JsonNullable.undefined();

    @JsonProperty("last")
    public ListEnvelopesRequestBuilder last(Long value) {
      if (value == null) {
        throw new IllegalStateException("last cannot be null");
      }
      this.last = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> after = JsonNullable.undefined();

    @JsonProperty("after")
    public ListEnvelopesRequestBuilder after(String value) {
      if (value == null) {
        throw new IllegalStateException("after cannot be null");
      }
      this.after = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> before = JsonNullable.undefined();

    @JsonProperty("before")
    public ListEnvelopesRequestBuilder before(String value) {
      if (value == null) {
        throw new IllegalStateException("before cannot be null");
      }
      this.before = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<EnvelopeOrderField> orderField = JsonNullable.undefined();

    @JsonProperty("order_field")
    public ListEnvelopesRequestBuilder orderField(EnvelopeOrderField value) {
      if (value == null) {
        throw new IllegalStateException("orderField cannot be null");
      }
      this.orderField = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> ascending = JsonNullable.undefined();

    @JsonProperty("ascending")
    public ListEnvelopesRequestBuilder ascending(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("ascending cannot be null");
      }
      this.ascending = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> includeTrash = JsonNullable.undefined();

    @JsonProperty("include_trash")
    public ListEnvelopesRequestBuilder includeTrash(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("includeTrash cannot be null");
      }
      this.includeTrash = JsonNullable.of(value);
      return this;
    }
  }
}
