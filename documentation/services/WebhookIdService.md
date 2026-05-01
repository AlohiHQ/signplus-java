# WebhookIdService

A list of all methods in the `WebhookIdService` service. Click on the method name to view detailed information about that method.

| Methods                         | Description    |
| :------------------------------ | :------------- |
| [deleteWebhook](#deletewebhook) | Delete webhook |

## deleteWebhook

Delete webhook

- HTTP Method: `DELETE`
- Endpoint: `/webhook/{webhook_id}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| webhookId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Object response = signplus.webhookId.deleteWebhook("webhook_id");

    System.out.println(response);
  }
}

```
