# TemplateTemplateIdDocumentsService

A list of all methods in the `TemplateTemplateIdDocumentsService` service. Click on the method name to view detailed information about that method.

| Methods                                       | Description            |
| :-------------------------------------------- | :--------------------- |
| [getTemplateDocuments](#gettemplatedocuments) | Get template documents |

## getTemplateDocuments

Get template documents

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}/documents`

**Parameters**

| Name              | Type                                                                          | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                                        | ✅       |                           |
| requestParameters | [GetTemplateDocumentsParameters](../models/GetTemplateDocumentsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetTemplateDocumentsParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetTemplateDocumentsParameters requestParameters = GetTemplateDocumentsParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.templateTemplateIdDocuments.getTemplateDocuments(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
