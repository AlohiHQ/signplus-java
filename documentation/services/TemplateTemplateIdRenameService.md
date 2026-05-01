# TemplateTemplateIdRenameService

A list of all methods in the `TemplateTemplateIdRenameService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description     |
| :-------------------------------- | :-------------- |
| [renameTemplate](#renametemplate) | Rename template |

## renameTemplate

Rename template

- HTTP Method: `PUT`
- Endpoint: `/template/{template_id}/rename`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                            | ✅       |                           |
| requestParameters | [RenameTemplateParameters](../models/RenameTemplateParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.RenameTemplateParameters;
import com.alohi.signplus.models.RenameTemplateRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    RenameTemplateRequest renameTemplateRequest = RenameTemplateRequest.builder()
      .name("string")
      .build();

    RenameTemplateParameters requestParameters = RenameTemplateParameters.builder()
      .accept("application/json")
      .requestBody(renameTemplateRequest)
      .build();

    Object response = signplus.templateTemplateIdRename.renameTemplate(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
