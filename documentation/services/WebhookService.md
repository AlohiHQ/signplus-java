# WebhookService

A list of all methods in the `WebhookService` service. Click on the method name to view detailed information about that method.

| Methods                         | Description    |
| :------------------------------ | :------------- |
| [createWebhook](#createwebhook) | Create webhook |

## createWebhook

Create webhook

- HTTP Method: `POST`
- Endpoint: `/webhook`

**Parameters**

| Name              | Type                                                            | Required | Description               |
| :---------------- | :-------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [CreateWebhookParameters](../models/CreateWebhookParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.CreateWebhookParameters;
import com.alohi.signplus.models.CreateWebhookRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    CreateWebhookRequest createWebhookRequest = CreateWebhookRequest.builder()
      .event("ENVELOPE_AUDIT_TRAIL")
      .target("string")
      .build();

    CreateWebhookParameters requestParameters = CreateWebhookParameters.builder()
      .accept("application/json")
      .requestBody(createWebhookRequest)
      .build();

    Object response = signplus.webhook.createWebhook(requestParameters);

    System.out.println(response);
  }
}

```
