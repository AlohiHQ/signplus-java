# WebhooksService

A list of all methods in the `WebhooksService` service. Click on the method name to view detailed information about that method.

| Methods                       | Description   |
| :---------------------------- | :------------ |
| [listWebhooks](#listwebhooks) | List webhooks |

## listWebhooks

List webhooks

- HTTP Method: `POST`
- Endpoint: `/webhooks`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListWebhooksParameters](../models/ListWebhooksParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.ListWebhooksParameters;
import com.alohi.signplus.models.ListWebhooksRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    ListWebhooksRequest listWebhooksRequest = ListWebhooksRequest.builder()
      .webhookId("string")
      .event("ENVELOPE_COMPLETED")
      .build();

    ListWebhooksParameters requestParameters = ListWebhooksParameters.builder()
      .accept("application/json")
      .requestBody(listWebhooksRequest)
      .build();

    Object response = signplus.webhooks.listWebhooks(requestParameters);

    System.out.println(response);
  }
}

```
