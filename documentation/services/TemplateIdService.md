# TemplateIdService

A list of all methods in the `TemplateIdService` service. Click on the method name to view detailed information about that method.

| Methods                                                   | Description                       |
| :-------------------------------------------------------- | :-------------------------------- |
| [createEnvelopeFromTemplate](#createenvelopefromtemplate) | Create new envelope from template |

## createEnvelopeFromTemplate

Create new envelope from template

- HTTP Method: `POST`
- Endpoint: `/envelope/from_template/{template_id}`

**Parameters**

| Name              | Type                                                                                      | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                                                    | ✅       |                           |
| requestParameters | [CreateEnvelopeFromTemplateParameters](../models/CreateEnvelopeFromTemplateParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.CreateEnvelopeFromTemplateParameters;
import com.alohi.signplus.models.CreateEnvelopeFromTemplateRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest =
      CreateEnvelopeFromTemplateRequest.builder()
        .name("dwL1t")
        .comment("string")
        .sandbox(false)
        .build();

    CreateEnvelopeFromTemplateParameters requestParameters =
      CreateEnvelopeFromTemplateParameters.builder()
        .accept("application/json")
        .requestBody(createEnvelopeFromTemplateRequest)
        .build();

    Object response = signplus.templateId.createEnvelopeFromTemplate(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
