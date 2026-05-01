# TemplateService

A list of all methods in the `TemplateService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description         |
| :-------------------------------- | :------------------ |
| [createTemplate](#createtemplate) | Create new template |

## createTemplate

Create new template

- HTTP Method: `POST`
- Endpoint: `/template`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [CreateTemplateParameters](../models/CreateTemplateParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.CreateTemplateParameters;
import com.alohi.signplus.models.CreateTemplateRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    CreateTemplateRequest createTemplateRequest = CreateTemplateRequest.builder()
      .name("rEATXel")
      .build();

    CreateTemplateParameters requestParameters = CreateTemplateParameters.builder()
      .accept("application/json")
      .requestBody(createTemplateRequest)
      .build();

    Object response = signplus.template.createTemplate(requestParameters);

    System.out.println(response);
  }
}

```
