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
public class ListEnvelopesResponse {

  /**
   * Whether there is a next page
   */
  @JsonProperty("has_next_page")
  private JsonNullable<Boolean> hasNextPage;

  /**
   * Whether there is a previous page
   */
  @JsonProperty("has_previous_page")
  private JsonNullable<Boolean> hasPreviousPage;

  @JsonProperty("envelopes")
  private JsonNullable<List<Envelope>> envelopes;

  @JsonIgnore
  public Boolean getHasNextPage() {
    return hasNextPage.orElse(null);
  }

  @JsonIgnore
  public Boolean getHasPreviousPage() {
    return hasPreviousPage.orElse(null);
  }

  @JsonIgnore
  public List<Envelope> getEnvelopes() {
    return envelopes.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class ListEnvelopesResponseBuilder {

    private JsonNullable<Boolean> hasNextPage = JsonNullable.undefined();

    @JsonProperty("has_next_page")
    public ListEnvelopesResponseBuilder hasNextPage(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("hasNextPage cannot be null");
      }
      this.hasNextPage = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> hasPreviousPage = JsonNullable.undefined();

    @JsonProperty("has_previous_page")
    public ListEnvelopesResponseBuilder hasPreviousPage(Boolean value) {
      if (value == null) {
        throw new IllegalStateException("hasPreviousPage cannot be null");
      }
      this.hasPreviousPage = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<Envelope>> envelopes = JsonNullable.undefined();

    @JsonProperty("envelopes")
    public ListEnvelopesResponseBuilder envelopes(List<Envelope> value) {
      if (value == null) {
        throw new IllegalStateException("envelopes cannot be null");
      }
      this.envelopes = JsonNullable.of(value);
      return this;
    }
  }
}
