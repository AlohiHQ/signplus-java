# SetExpirationDateService

A list of all methods in the `SetExpirationDateService` service. Click on the method name to view detailed information about that method.

| Methods                                                 | Description                  |
| :------------------------------------------------------ | :--------------------------- |
| [setEnvelopeExpirationDate](#setenvelopeexpirationdate) | Set envelope expiration date |

## setEnvelopeExpirationDate

Set envelope expiration date

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/set_expiration_date`

**Parameters**

| Name              | Type                                                                                    | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                                  | ✅       |                           |
| requestParameters | [SetEnvelopeExpirationDateParameters](../models/SetEnvelopeExpirationDateParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetEnvelopeExpirationDateParameters;
import com.alohi.signplus.models.SetEnvelopeExpirationDateRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetEnvelopeExpirationDateRequest setEnvelopeExpirationDateRequest =
      SetEnvelopeExpirationDateRequest.builder().expiresAt("<integer>").build();

    SetEnvelopeExpirationDateParameters requestParameters =
      SetEnvelopeExpirationDateParameters.builder()
        .accept("application/json")
        .requestBody(setEnvelopeExpirationDateRequest)
        .build();

    Object response = signplus.setExpirationDate.setEnvelopeExpirationDate(
      "envelope_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
