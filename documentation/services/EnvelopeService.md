# EnvelopeService

A list of all methods in the `EnvelopeService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description         |
| :-------------------------------- | :------------------ |
| [createEnvelope](#createenvelope) | Create new envelope |

## createEnvelope

Create new envelope

- HTTP Method: `POST`
- Endpoint: `/envelope`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [CreateEnvelopeParameters](../models/CreateEnvelopeParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.CreateEnvelopeParameters;
import com.alohi.signplus.models.CreateEnvelopeRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    CreateEnvelopeRequest createEnvelopeRequest = CreateEnvelopeRequest.builder()
      .name("7ox22")
      .legalityLevel("SES")
      .expiresAt(5681D)
      .comment("string")
      .sandbox(false)
      .build();

    CreateEnvelopeParameters requestParameters = CreateEnvelopeParameters.builder()
      .accept("application/json")
      .requestBody(createEnvelopeRequest)
      .build();

    Object response = signplus.envelope.createEnvelope(requestParameters);

    System.out.println(response);
  }
}

```
