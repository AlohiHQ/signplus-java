# TemplateTemplateIdAttachmentsPlaceholdersService

A list of all methods in the `TemplateTemplateIdAttachmentsPlaceholdersService` service. Click on the method name to view detailed information about that method.

| Methods                                                                   | Description                                                     |
| :------------------------------------------------------------------------ | :-------------------------------------------------------------- |
| [setTemplateAttachmentsPlaceholders](#settemplateattachmentsplaceholders) | Placeholders to be set, completely replacing the existing ones. |

## setTemplateAttachmentsPlaceholders

Placeholders to be set, completely replacing the existing ones.

- HTTP Method: `PUT`
- Endpoint: `/template/{template_id}/attachments/placeholders`

**Parameters**

| Name              | Type                                                                                                      | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                                                                    | ✅       |                           |
| requestParameters | [SetTemplateAttachmentsPlaceholdersParameters](../models/SetTemplateAttachmentsPlaceholdersParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetTemplateAttachmentsPlaceholdersParameters;
import com.alohi.signplus.models.SetTemplateAttachmentsPlaceholdersRequest;
import com.alohi.signplus.models.SetTemplateAttachmentsPlaceholdersRequestPlaceholders;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetTemplateAttachmentsPlaceholdersRequestPlaceholders setTemplateAttachmentsPlaceholdersRequestPlaceholders =
      SetTemplateAttachmentsPlaceholdersRequestPlaceholders.builder()
        .recipientId("<string>")
        .name("<string>")
        .required("<boolean>")
        .multiple("<boolean>")
        .id("<string>")
        .hint("<string>")
        .build();

    List<SetTemplateAttachmentsPlaceholdersRequestPlaceholders> placeholdersList = Arrays.asList(
      setTemplateAttachmentsPlaceholdersRequestPlaceholders
    );

    SetTemplateAttachmentsPlaceholdersRequest setTemplateAttachmentsPlaceholdersRequest =
      SetTemplateAttachmentsPlaceholdersRequest.builder().placeholders(placeholdersList).build();

    SetTemplateAttachmentsPlaceholdersParameters requestParameters =
      SetTemplateAttachmentsPlaceholdersParameters.builder()
        .accept("application/json")
        .requestBody(setTemplateAttachmentsPlaceholdersRequest)
        .build();

    Object response =
      signplus.templateTemplateIdAttachmentsPlaceholders.setTemplateAttachmentsPlaceholders(
        "template_id",
        requestParameters
      );

    System.out.println(response);
  }
}

```
