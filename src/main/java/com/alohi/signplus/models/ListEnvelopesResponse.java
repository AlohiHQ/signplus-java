package com.alohi.signplus.models;

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
public class ListEnvelopesResponse {

  /**
   * Whether there is a next page
   */
  @JsonProperty("has_next_page")
  private Boolean hasNextPage;

  /**
   * Whether there is a previous page
   */
  @JsonProperty("has_previous_page")
  private Boolean hasPreviousPage;

  private List<Envelope> envelopes;
}
