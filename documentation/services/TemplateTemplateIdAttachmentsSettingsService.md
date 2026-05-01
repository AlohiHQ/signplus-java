# TemplateTemplateIdAttachmentsSettingsService

A list of all methods in the `TemplateTemplateIdAttachmentsSettingsService` service. Click on the method name to view detailed information about that method.

| Methods                                                           | Description                      |
| :---------------------------------------------------------------- | :------------------------------- |
| [setTemplateAttachmentsSettings](#settemplateattachmentssettings) | Set template attachment settings |

## setTemplateAttachmentsSettings

Set template attachment settings

- HTTP Method: `PUT`
- Endpoint: `/template/{template_id}/attachments/settings`

**Parameters**

| Name              | Type                                                                                              | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------------------ | :------- | :------------------------ |
| templateId        | String                                                                                            | ✅       |                           |
| requestParameters | [SetTemplateAttachmentsSettingsParameters](../models/SetTemplateAttachmentsSettingsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetTemplateAttachmentsSettingsParameters;
import com.alohi.signplus.models.SetTemplateAttachmentsSettingsRequest;
import com.alohi.signplus.models.SetTemplateAttachmentsSettingsRequestSettings;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetTemplateAttachmentsSettingsRequestSettings setTemplateAttachmentsSettingsRequestSettings =
      SetTemplateAttachmentsSettingsRequestSettings.builder()
        .visibleToRecipients("<boolean>")
        .build();

    SetTemplateAttachmentsSettingsRequest setTemplateAttachmentsSettingsRequest =
      SetTemplateAttachmentsSettingsRequest.builder()
        .settings(setTemplateAttachmentsSettingsRequestSettings)
        .build();

    SetTemplateAttachmentsSettingsParameters requestParameters =
      SetTemplateAttachmentsSettingsParameters.builder()
        .accept("application/json")
        .requestBody(setTemplateAttachmentsSettingsRequest)
        .build();

    Object response = signplus.templateTemplateIdAttachmentsSettings.setTemplateAttachmentsSettings(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
