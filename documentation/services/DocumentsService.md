# DocumentsService

A list of all methods in the `DocumentsService` service. Click on the method name to view detailed information about that method.

| Methods                                       | Description            |
| :-------------------------------------------- | :--------------------- |
| [getEnvelopeDocuments](#getenvelopedocuments) | Get envelope documents |

## getEnvelopeDocuments

Get envelope documents

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/documents`

**Parameters**

| Name              | Type                                                                          | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                        | ✅       |                           |
| requestParameters | [GetEnvelopeDocumentsParameters](../models/GetEnvelopeDocumentsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetEnvelopeDocumentsParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetEnvelopeDocumentsParameters requestParameters = GetEnvelopeDocumentsParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.documents.getEnvelopeDocuments("envelope_id", requestParameters);

    System.out.println(response);
  }
}

```
