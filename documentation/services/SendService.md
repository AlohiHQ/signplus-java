# SendService

A list of all methods in the `SendService` service. Click on the method name to view detailed information about that method.

| Methods                       | Description                 |
| :---------------------------- | :-------------------------- |
| [sendEnvelope](#sendenvelope) | Send envelope for signature |

## sendEnvelope

Send envelope for signature

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/send`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| envelopeId        | String                                                        | ✅       |                           |
| requestParameters | [SendEnvelopeParameters](../models/SendEnvelopeParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SendEnvelopeParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SendEnvelopeParameters requestParameters = SendEnvelopeParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.send.sendEnvelope("envelope_id", requestParameters);

    System.out.println(response);
  }
}

```
