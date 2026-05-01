# SettingsService

A list of all methods in the `SettingsService` service. Click on the method name to view detailed information about that method.

| Methods                                                           | Description                      |
| :---------------------------------------------------------------- | :------------------------------- |
| [setEnvelopeAttachmentsSettings](#setenvelopeattachmentssettings) | Set envelope attachment settings |

## setEnvelopeAttachmentsSettings

Set envelope attachment settings

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/attachments/settings`

**Parameters**

| Name              | Type                                                                                              | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------------------ | :------- | :------------------------ |
| envelopeId        | String                                                                                            | ✅       |                           |
| requestParameters | [SetEnvelopeAttachmentsSettingsParameters](../models/SetEnvelopeAttachmentsSettingsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetEnvelopeAttachmentsSettingsParameters;
import com.alohi.signplus.models.SetEnvelopeAttachmentsSettingsRequest;
import com.alohi.signplus.models.SetEnvelopeAttachmentsSettingsRequestSettings;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetEnvelopeAttachmentsSettingsRequestSettings setEnvelopeAttachmentsSettingsRequestSettings =
      SetEnvelopeAttachmentsSettingsRequestSettings.builder().visibleToRecipients(false).build();

    SetEnvelopeAttachmentsSettingsRequest setEnvelopeAttachmentsSettingsRequest =
      SetEnvelopeAttachmentsSettingsRequest.builder()
        .settings(setEnvelopeAttachmentsSettingsRequestSettings)
        .build();

    SetEnvelopeAttachmentsSettingsParameters requestParameters =
      SetEnvelopeAttachmentsSettingsParameters.builder()
        .accept("application/json")
        .requestBody(setEnvelopeAttachmentsSettingsRequest)
        .build();

    Object response = signplus.settings.setEnvelopeAttachmentsSettings(
      "envelope_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
