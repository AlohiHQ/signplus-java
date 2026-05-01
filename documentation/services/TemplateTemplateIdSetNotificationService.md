# TemplateTemplateIdSetNotificationService

A list of all methods in the `TemplateTemplateIdSetNotificationService` service. Click on the method name to view detailed information about that method.

| Methods                                             | Description               |
| :-------------------------------------------------- | :------------------------ |
| [setTemplateNotification](#settemplatenotification) | Set template notification |

## setTemplateNotification

Set template notification

- HTTP Method: `PUT`
- Endpoint: `/template/{template_id}/set_notification`

**Parameters**

| Name              | Type                                                                                | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                                              | ✅       |                           |
| requestParameters | [SetTemplateNotificationParameters](../models/SetTemplateNotificationParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetTemplateNotificationParameters;
import com.alohi.signplus.models.SetTemplateNotificationRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetTemplateNotificationRequest setTemplateNotificationRequest =
      SetTemplateNotificationRequest.builder()
        .subject("<string>")
        .message("<string>")
        .reminderInterval("<integer>")
        .build();

    SetTemplateNotificationParameters requestParameters =
      SetTemplateNotificationParameters.builder()
        .accept("application/json")
        .requestBody(setTemplateNotificationRequest)
        .build();

    Object response = signplus.templateTemplateIdSetNotification.setTemplateNotification(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
