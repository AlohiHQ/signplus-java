package alohi.signplus.signplus.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class SetEnvelopeDynamicFieldsRequest {

  /**
   * List of dynamic fields
   */
  @NonNull
  @JsonProperty("dynamic_fields")
  private List<DynamicField> dynamicFields;
}
