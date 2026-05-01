# SetNotificationService

A list of all methods in the `SetNotificationService` service. Click on the method name to view detailed information about that method.

| Methods                                             | Description               |
| :-------------------------------------------------- | :------------------------ |
| [setEnvelopeNotification](#setenvelopenotification) | Set envelope notification |

## setEnvelopeNotification

Set envelope notification

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/set_notification`

**Parameters**

| Name              | Type                                                                                | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                              | ✅       |                           |
| requestParameters | [SetEnvelopeNotificationParameters](../models/SetEnvelopeNotificationParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetEnvelopeNotificationParameters;
import com.alohi.signplus.models.SetEnvelopeNotificationRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetEnvelopeNotificationRequest setEnvelopeNotificationRequest =
      SetEnvelopeNotificationRequest.builder()
        .subject("string")
        .message("string")
        .reminderInterval(4732D)
        .build();

    SetEnvelopeNotificationParameters requestParameters =
      SetEnvelopeNotificationParameters.builder()
        .accept("application/json")
        .requestBody(setEnvelopeNotificationRequest)
        .build();

    Object response = signplus.setNotification.setEnvelopeNotification(
      "envelope_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
