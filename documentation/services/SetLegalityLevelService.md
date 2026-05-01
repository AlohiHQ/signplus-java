# SetLegalityLevelService

A list of all methods in the `SetLegalityLevelService` service. Click on the method name to view detailed information about that method.

| Methods                                               | Description                 |
| :---------------------------------------------------- | :-------------------------- |
| [setEnvelopeLegalityLevel](#setenvelopelegalitylevel) | Set envelope legality level |

## setEnvelopeLegalityLevel

Set envelope legality level

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/set_legality_level`

**Parameters**

| Name              | Type                                                                                  | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------ | :------- | :------------------------ |
| envelopeId        | String                                                                                | ✅       |                           |
| requestParameters | [SetEnvelopeLegalityLevelParameters](../models/SetEnvelopeLegalityLevelParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetEnvelopeLegalityLevelParameters;
import com.alohi.signplus.models.SetEnvelopeLegalityLevelRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetEnvelopeLegalityLevelRequest setEnvelopeLegalityLevelRequest =
      SetEnvelopeLegalityLevelRequest.builder().legalityLevel("QES_EIDAS").build();

    SetEnvelopeLegalityLevelParameters requestParameters =
      SetEnvelopeLegalityLevelParameters.builder()
        .accept("application/json")
        .requestBody(setEnvelopeLegalityLevelRequest)
        .build();

    Object response = signplus.setLegalityLevel.setEnvelopeLegalityLevel(
      "envelope_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
