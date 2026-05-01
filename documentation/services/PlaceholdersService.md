# PlaceholdersService

A list of all methods in the `PlaceholdersService` service. Click on the method name to view detailed information about that method.

| Methods                                                                   | Description                                                     |
| :------------------------------------------------------------------------ | :-------------------------------------------------------------- |
| [setEnvelopeAttachmentsPlaceholders](#setenvelopeattachmentsplaceholders) | Placeholders to be set, completely replacing the existing ones. |

## setEnvelopeAttachmentsPlaceholders

Placeholders to be set, completely replacing the existing ones.

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/attachments/placeholders`

**Parameters**

| Name              | Type                                                                                                      | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                                                    | ✅       |                           |
| requestParameters | [SetEnvelopeAttachmentsPlaceholdersParameters](../models/SetEnvelopeAttachmentsPlaceholdersParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetEnvelopeAttachmentsPlaceholdersParameters;
import com.alohi.signplus.models.SetEnvelopeAttachmentsPlaceholdersRequest;
import com.alohi.signplus.models.SetEnvelopeAttachmentsPlaceholdersRequestPlaceholders;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetEnvelopeAttachmentsPlaceholdersRequestPlaceholders setEnvelopeAttachmentsPlaceholdersRequestPlaceholders =
      SetEnvelopeAttachmentsPlaceholdersRequestPlaceholders.builder()
        .recipientId("string")
        .name("string")
        .required(false)
        .multiple(false)
        .id("string")
        .hint("string")
        .build();

    List<SetEnvelopeAttachmentsPlaceholdersRequestPlaceholders> placeholdersList = Arrays.asList(
      setEnvelopeAttachmentsPlaceholdersRequestPlaceholders
    );

    SetEnvelopeAttachmentsPlaceholdersRequest setEnvelopeAttachmentsPlaceholdersRequest =
      SetEnvelopeAttachmentsPlaceholdersRequest.builder().placeholders(placeholdersList).build();

    SetEnvelopeAttachmentsPlaceholdersParameters requestParameters =
      SetEnvelopeAttachmentsPlaceholdersParameters.builder()
        .accept("application/json")
        .requestBody(setEnvelopeAttachmentsPlaceholdersRequest)
        .build();

    Object response = signplus.placeholders.setEnvelopeAttachmentsPlaceholders(
      "envelope_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
