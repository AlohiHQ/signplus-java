# TemplateTemplateIdAnnotationService

A list of all methods in the `TemplateTemplateIdAnnotationService` service. Click on the method name to view detailed information about that method.

| Methods                                         | Description             |
| :---------------------------------------------- | :---------------------- |
| [addTemplateAnnotation](#addtemplateannotation) | Add template annotation |

## addTemplateAnnotation

Add template annotation

- HTTP Method: `POST`
- Endpoint: `/template/{template_id}/annotation`

**Parameters**

| Name              | Type                                                                            | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------ | :------- | :------------------------ |
| templateId        | String                                                                          | ✅       |                           |
| requestParameters | [AddTemplateAnnotationParameters](../models/AddTemplateAnnotationParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.AddTemplateAnnotationParameters;
import com.alohi.signplus.models.AddTemplateAnnotationRequest;
import com.alohi.signplus.models.AddTemplateAnnotationRequestCheckbox;
import com.alohi.signplus.models.AddTemplateAnnotationRequestDatetime;
import com.alohi.signplus.models.AddTemplateAnnotationRequestInitials;
import com.alohi.signplus.models.AddTemplateAnnotationRequestSignature;
import com.alohi.signplus.models.AddTemplateAnnotationRequestText;
import com.alohi.signplus.models.DatetimeFont2;
import com.alohi.signplus.models.TextFont2;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    AddTemplateAnnotationRequestSignature addTemplateAnnotationRequestSignature =
      AddTemplateAnnotationRequestSignature.builder().id("<string>").build();

    AddTemplateAnnotationRequestInitials addTemplateAnnotationRequestInitials =
      AddTemplateAnnotationRequestInitials.builder().id("<string>").build();

    TextFont2 textFont2 = TextFont2.builder()
      .family("SANS")
      .italic("<boolean>")
      .bold("<boolean>")
      .build();

    AddTemplateAnnotationRequestText addTemplateAnnotationRequestText =
      AddTemplateAnnotationRequestText.builder()
        .size("<number>")
        .color("<number>")
        .value("<string>")
        .tooltip("<string>")
        .dynamicFieldName("<string>")
        .font(textFont2)
        .build();

    DatetimeFont2 datetimeFont2 = DatetimeFont2.builder()
      .family("UNKNOWN")
      .italic("<boolean>")
      .bold("<boolean>")
      .build();

    AddTemplateAnnotationRequestDatetime addTemplateAnnotationRequestDatetime =
      AddTemplateAnnotationRequestDatetime.builder()
        .size("<number>")
        .font(datetimeFont2)
        .color("<string>")
        .autoFill("<boolean>")
        .timezone("<string>")
        .timestamp("<integer>")
        .format("YMD_NUMERIC_SLASH")
        .build();

    AddTemplateAnnotationRequestCheckbox addTemplateAnnotationRequestCheckbox =
      AddTemplateAnnotationRequestCheckbox.builder()
        .checked("<boolean>")
        .style("TIMES_SQUARE")
        .build();

    AddTemplateAnnotationRequest addTemplateAnnotationRequest =
      AddTemplateAnnotationRequest.builder()
        .documentId("<string>")
        .page("<integer>")
        .x("<float>")
        .y("<float>")
        .width("<float>")
        .height("<float>")
        .type("INITIALS")
        .recipientId("<string>")
        .required("<boolean>")
        .signature(addTemplateAnnotationRequestSignature)
        .initials(addTemplateAnnotationRequestInitials)
        .text(addTemplateAnnotationRequestText)
        .datetime(addTemplateAnnotationRequestDatetime)
        .checkbox(addTemplateAnnotationRequestCheckbox)
        .build();

    AddTemplateAnnotationParameters requestParameters = AddTemplateAnnotationParameters.builder()
      .accept("application/json")
      .requestBody(addTemplateAnnotationRequest)
      .build();

    Object response = signplus.templateTemplateIdAnnotation.addTemplateAnnotation(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
