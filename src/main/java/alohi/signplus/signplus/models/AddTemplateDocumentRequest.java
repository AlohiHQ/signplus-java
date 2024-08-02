package alohi.signplus.signplus.models;

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
public class AddTemplateDocumentRequest {

  /**
   * File to upload in binary format
   */
  private byte[] file;
}
