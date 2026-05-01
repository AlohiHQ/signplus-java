# DocumentIdService

A list of all methods in the `DocumentIdService` service. Click on the method name to view detailed information about that method.

| Methods                                     | Description           |
| :------------------------------------------ | :-------------------- |
| [getEnvelopeDocument](#getenvelopedocument) | Get envelope document |

## getEnvelopeDocument

Get envelope document

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/document/{document_id}`

**Parameters**

| Name              | Type                                                                        | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                      | ✅       |                           |
| documentId        | String                                                                      | ✅       |                           |
| requestParameters | [GetEnvelopeDocumentParameters](../models/GetEnvelopeDocumentParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetEnvelopeDocumentParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetEnvelopeDocumentParameters requestParameters = GetEnvelopeDocumentParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.documentId.getEnvelopeDocument(
      "envelope_id",
      "document_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
