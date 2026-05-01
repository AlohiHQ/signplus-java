# DuplicateService

A list of all methods in the `DuplicateService` service. Click on the method name to view detailed information about that method.

| Methods                                 | Description        |
| :-------------------------------------- | :----------------- |
| [duplicateEnvelope](#duplicateenvelope) | Duplicate envelope |

## duplicateEnvelope

Duplicate envelope

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/duplicate`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                  | ✅       |                           |
| requestParameters | [DuplicateEnvelopeParameters](../models/DuplicateEnvelopeParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.DuplicateEnvelopeParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    DuplicateEnvelopeParameters requestParameters = DuplicateEnvelopeParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.duplicate.duplicateEnvelope("envelope_id", requestParameters);

    System.out.println(response);
  }
}

```
