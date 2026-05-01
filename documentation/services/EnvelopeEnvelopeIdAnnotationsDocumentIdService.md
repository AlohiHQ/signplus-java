# EnvelopeEnvelopeIdAnnotationsDocumentIdService

A list of all methods in the `EnvelopeEnvelopeIdAnnotationsDocumentIdService` service. Click on the method name to view detailed information about that method.

| Methods                                                           | Description                       |
| :---------------------------------------------------------------- | :-------------------------------- |
| [getEnvelopeDocumentAnnotations](#getenvelopedocumentannotations) | Get envelope document annotations |

## getEnvelopeDocumentAnnotations

Get envelope document annotations

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/annotations/{document_id}`

**Parameters**

| Name              | Type                                                                                              | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------------------ | :------- | :------------------------ |
| envelopeId        | String                                                                                            | ✅       |                           |
| documentId        | String                                                                                            | ✅       |                           |
| requestParameters | [GetEnvelopeDocumentAnnotationsParameters](../models/GetEnvelopeDocumentAnnotationsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetEnvelopeDocumentAnnotationsParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetEnvelopeDocumentAnnotationsParameters requestParameters =
      GetEnvelopeDocumentAnnotationsParameters.builder().accept("application/json").build();

    Object response =
      signplus.envelopeEnvelopeIdAnnotationsDocumentId.getEnvelopeDocumentAnnotations(
        "envelope_id",
        "document_id",
        requestParameters
      );

    System.out.println(response);
  }
}

```
