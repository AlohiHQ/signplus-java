# TemplateTemplateIdAnnotationsService

A list of all methods in the `TemplateTemplateIdAnnotationsService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description              |
| :------------------------------------------------ | :----------------------- |
| [getTemplateAnnotations](#gettemplateannotations) | Get template annotations |

## getTemplateAnnotations

Get template annotations

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}/annotations`

**Parameters**

| Name              | Type                                                                              | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                                            | ✅       |                           |
| requestParameters | [GetTemplateAnnotationsParameters](../models/GetTemplateAnnotationsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetTemplateAnnotationsParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetTemplateAnnotationsParameters requestParameters = GetTemplateAnnotationsParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.templateTemplateIdAnnotations.getTemplateAnnotations(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
