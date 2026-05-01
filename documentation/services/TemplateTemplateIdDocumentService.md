# TemplateTemplateIdDocumentService

A list of all methods in the `TemplateTemplateIdDocumentService` service. Click on the method name to view detailed information about that method.

| Methods                                     | Description           |
| :------------------------------------------ | :-------------------- |
| [addTemplateDocument](#addtemplatedocument) | Add template document |

## addTemplateDocument

Add template document

- HTTP Method: `POST`
- Endpoint: `/template/{template_id}/document`

**Parameters**

| Name              | Type                                                                        | Required | Description                    |
| :---------------- | :-------------------------------------------------------------------------- | :------- | :----------------------------- |
| templateId        | String                                                                      | ✅       |                                |
| requestParameters | [AddTemplateDocumentParameters](../models/AddTemplateDocumentParameters.md) | ✅       | Request Parameters Object      |
| \_filename        | String                                                                      | ✅       | Filename for the uploaded file |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.AddTemplateDocumentParameters;
import com.alohi.signplus.models.AddTemplateDocumentRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    byte[] file = new byte[] { 0, 1, 2, 3, 4, 5 };

    AddTemplateDocumentRequest addTemplateDocumentRequest = AddTemplateDocumentRequest.builder()
      .file(file)
      .build();

    AddTemplateDocumentParameters requestParameters = AddTemplateDocumentParameters.builder()
      .accept("application/json")
      .requestBody(addTemplateDocumentRequest)
      .build();

    Object response = signplus.templateTemplateIdDocument.addTemplateDocument(
      "template_id",
      requestParameters,
      "filename.txt"
    );

    System.out.println(response);
  }
}

```
