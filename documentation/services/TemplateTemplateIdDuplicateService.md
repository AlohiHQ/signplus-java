# TemplateTemplateIdDuplicateService

A list of all methods in the `TemplateTemplateIdDuplicateService` service. Click on the method name to view detailed information about that method.

| Methods                                 | Description        |
| :-------------------------------------- | :----------------- |
| [duplicateTemplate](#duplicatetemplate) | Duplicate template |

## duplicateTemplate

Duplicate template

- HTTP Method: `POST`
- Endpoint: `/template/{template_id}/duplicate`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                                  | ✅       |                           |
| requestParameters | [DuplicateTemplateParameters](../models/DuplicateTemplateParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.DuplicateTemplateParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    DuplicateTemplateParameters requestParameters = DuplicateTemplateParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.templateTemplateIdDuplicate.duplicateTemplate(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
