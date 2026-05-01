# Void_Service

A list of all methods in the `Void_Service` service. Click on the method name to view detailed information about that method.

| Methods                       | Description   |
| :---------------------------- | :------------ |
| [voidEnvelope](#voidenvelope) | Void envelope |

## voidEnvelope

Void envelope

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/void`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| envelopeId        | String                                                        | ✅       |                           |
| requestParameters | [VoidEnvelopeParameters](../models/VoidEnvelopeParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.VoidEnvelopeParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    VoidEnvelopeParameters requestParameters = VoidEnvelopeParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.void_.voidEnvelope("envelope_id", requestParameters);

    System.out.println(response);
  }
}

```
