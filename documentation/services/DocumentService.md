# DocumentService

A list of all methods in the `DocumentService` service. Click on the method name to view detailed information about that method.

| Methods                                     | Description           |
| :------------------------------------------ | :-------------------- |
| [addEnvelopeDocument](#addenvelopedocument) | Add envelope document |

## addEnvelopeDocument

Add envelope document

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/document`

**Parameters**

| Name              | Type                                                                        | Required | Description                    |
| :---------------- | :-------------------------------------------------------------------------- | :------- | :----------------------------- |
| envelopeId        | String                                                                      | ✅       |                                |
| requestParameters | [AddEnvelopeDocumentParameters](../models/AddEnvelopeDocumentParameters.md) | ✅       | Request Parameters Object      |
| \_filename        | String                                                                      | ✅       | Filename for the uploaded file |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.AddEnvelopeDocumentParameters;
import com.alohi.signplus.models.AddEnvelopeDocumentRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    byte[] file = new byte[] { 0, 1, 2, 3, 4, 5 };

    AddEnvelopeDocumentRequest addEnvelopeDocumentRequest = AddEnvelopeDocumentRequest.builder()
      .file(file)
      .build();

    AddEnvelopeDocumentParameters requestParameters = AddEnvelopeDocumentParameters.builder()
      .accept("application/json")
      .requestBody(addEnvelopeDocumentRequest)
      .build();

    Object response = signplus.document.addEnvelopeDocument(
      "envelope_id",
      requestParameters,
      "filename.txt"
    );

    System.out.println(response);
  }
}

```
