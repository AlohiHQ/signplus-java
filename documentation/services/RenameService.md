# RenameService

A list of all methods in the `RenameService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description     |
| :-------------------------------- | :-------------- |
| [renameEnvelope](#renameenvelope) | Rename envelope |

## renameEnvelope

Rename envelope

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/rename`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                            | ✅       |                           |
| requestParameters | [RenameEnvelopeParameters](../models/RenameEnvelopeParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.RenameEnvelopeParameters;
import com.alohi.signplus.models.RenameEnvelopeRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    RenameEnvelopeRequest renameEnvelopeRequest = RenameEnvelopeRequest.builder()
      .name("string")
      .build();

    RenameEnvelopeParameters requestParameters = RenameEnvelopeParameters.builder()
      .accept("application/json")
      .requestBody(renameEnvelopeRequest)
      .build();

    Object response = signplus.rename.renameEnvelope("envelope_id", requestParameters);

    System.out.println(response);
  }
}

```
