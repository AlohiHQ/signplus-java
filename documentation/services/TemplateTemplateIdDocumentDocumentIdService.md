# TemplateTemplateIdDocumentDocumentIdService

A list of all methods in the `TemplateTemplateIdDocumentDocumentIdService` service. Click on the method name to view detailed information about that method.

| Methods                                     | Description           |
| :------------------------------------------ | :-------------------- |
| [getTemplateDocument](#gettemplatedocument) | Get template document |

## getTemplateDocument

Get template document

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}/document/{document_id}`

**Parameters**

| Name              | Type                                                                        | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                                      | ✅       |                           |
| documentId        | String                                                                      | ✅       |                           |
| requestParameters | [GetTemplateDocumentParameters](../models/GetTemplateDocumentParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetTemplateDocumentParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetTemplateDocumentParameters requestParameters = GetTemplateDocumentParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.templateTemplateIdDocumentDocumentId.getTemplateDocument(
      "template_id",
      "document_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
