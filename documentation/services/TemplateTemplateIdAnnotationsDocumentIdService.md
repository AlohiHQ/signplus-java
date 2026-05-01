# TemplateTemplateIdAnnotationsDocumentIdService

A list of all methods in the `TemplateTemplateIdAnnotationsDocumentIdService` service. Click on the method name to view detailed information about that method.

| Methods                                                           | Description                       |
| :---------------------------------------------------------------- | :-------------------------------- |
| [getDocumentTemplateAnnotations](#getdocumenttemplateannotations) | Get document template annotations |

## getDocumentTemplateAnnotations

Get document template annotations

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}/annotations/{document_id}`

**Parameters**

| Name              | Type                                                                                              | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------------------ | :------- | :------------------------ |
| templateId        | String                                                                                            | ✅       |                           |
| documentId        | String                                                                                            | ✅       |                           |
| requestParameters | [GetDocumentTemplateAnnotationsParameters](../models/GetDocumentTemplateAnnotationsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetDocumentTemplateAnnotationsParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetDocumentTemplateAnnotationsParameters requestParameters =
      GetDocumentTemplateAnnotationsParameters.builder().accept("application/json").build();

    Object response =
      signplus.templateTemplateIdAnnotationsDocumentId.getDocumentTemplateAnnotations(
        "template_id",
        "document_id",
        requestParameters
      );

    System.out.println(response);
  }
}

```
