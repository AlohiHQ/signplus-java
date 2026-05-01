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

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("tags")
  private JsonNullable<List<String>> tags;

  @JsonProperty("comment")
  private JsonNullable<String> comment;

  @JsonProperty("ids")
  private JsonNullable<List<String>> ids;

  @JsonProperty("statuses")
  private JsonNullable<List<String>> statuses;

  @JsonProperty("folder_ids")
  private JsonNullable<List<String>> folderIds;

  @JsonProperty("only_root_folder")
  private JsonNullable<Boolean> onlyRootFolder;

  @JsonProperty("date_from")
  private JsonNullable<Double> dateFrom;

  @JsonProperty("date_to")
  private JsonNullable<Double> dateTo;

  @JsonProperty("uid")
  private JsonNullable<String> uid;

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
  public List<String> getStatuses() {
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
  public Double getDateFrom() {
    return dateFrom.orElse(null);
  }

  @JsonIgnore
  public Double getDateTo() {
    return dateTo.orElse(null);
  }

  @JsonIgnore
  public String getUid() {
    return uid.orElse(null);
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

  @JsonIgnore
  public Boolean getIncludeTrash() {
    return includeTrash.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListEnvelopesRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public ListEnvelopesRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> tags = JsonNullable.undefined();

    @JsonProperty("tags")
    public ListEnvelopesRequestBuilder tags(List<String> value) {
      this.tags = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> comment = JsonNullable.undefined();

    @JsonProperty("comment")
    public ListEnvelopesRequestBuilder comment(String value) {
      this.comment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> ids = JsonNullable.undefined();

    @JsonProperty("ids")
    public ListEnvelopesRequestBuilder ids(List<String> value) {
      this.ids = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> statuses = JsonNullable.undefined();

    @JsonProperty("statuses")
    public ListEnvelopesRequestBuilder statuses(List<String> value) {
      this.statuses = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> folderIds = JsonNullable.undefined();

    @JsonProperty("folder_ids")
    public ListEnvelopesRequestBuilder folderIds(List<String> value) {
      this.folderIds = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> onlyRootFolder = JsonNullable.undefined();

    @JsonProperty("only_root_folder")
    public ListEnvelopesRequestBuilder onlyRootFolder(Boolean value) {
      this.onlyRootFolder = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> dateFrom = JsonNullable.undefined();

    @JsonProperty("date_from")
    public ListEnvelopesRequestBuilder dateFrom(Double value) {
      this.dateFrom = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> dateTo = JsonNullable.undefined();

    @JsonProperty("date_to")
    public ListEnvelopesRequestBuilder dateTo(Double value) {
      this.dateTo = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> uid = JsonNullable.undefined();

    @JsonProperty("uid")
    public ListEnvelopesRequestBuilder uid(String value) {
      this.uid = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> first = JsonNullable.undefined();

    @JsonProperty("first")
    public ListEnvelopesRequestBuilder first(Double value) {
      this.first = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> last = JsonNullable.undefined();

    @JsonProperty("last")
    public ListEnvelopesRequestBuilder last(Double value) {
      this.last = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> after = JsonNullable.undefined();

    @JsonProperty("after")
    public ListEnvelopesRequestBuilder after(String value) {
      this.after = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> before = JsonNullable.undefined();

    @JsonProperty("before")
    public ListEnvelopesRequestBuilder before(String value) {
      this.before = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> orderField = JsonNullable.undefined();

    @JsonProperty("order_field")
    public ListEnvelopesRequestBuilder orderField(String value) {
      this.orderField = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> ascending = JsonNullable.undefined();

    @JsonProperty("ascending")
    public ListEnvelopesRequestBuilder ascending(Boolean value) {
      this.ascending = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> includeTrash = JsonNullable.undefined();

    @JsonProperty("include_trash")
    public ListEnvelopesRequestBuilder includeTrash(Boolean value) {
      this.includeTrash = JsonNullable.of(value);
      return this;
    }
  }
}
