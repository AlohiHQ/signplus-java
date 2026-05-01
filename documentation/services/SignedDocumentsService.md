# SignedDocumentsService

A list of all methods in the `SignedDocumentsService` service. Click on the method name to view detailed information about that method.

| Methods                                                             | Description                               |
| :------------------------------------------------------------------ | :---------------------------------------- |
| [downloadEnvelopeSignedDocuments](#downloadenvelopesigneddocuments) | Download signed documents for an envelope |

## downloadEnvelopeSignedDocuments

Download signed documents for an envelope

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/signed_documents`

**Parameters**

| Name              | Type                                                                                                | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                                              | ✅       |                           |
| requestParameters | [DownloadEnvelopeSignedDocumentsParameters](../models/DownloadEnvelopeSignedDocumentsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.DownloadEnvelopeSignedDocumentsParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    DownloadEnvelopeSignedDocumentsParameters requestParameters =
      DownloadEnvelopeSignedDocumentsParameters.builder()
        .accept("application/pdf")
        .certificateOfCompletion("true")
        .build();

    Object response = signplus.signedDocuments.downloadEnvelopeSignedDocuments(
      "envelope_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
