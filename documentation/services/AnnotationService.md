# AnnotationService

A list of all methods in the `AnnotationService` service. Click on the method name to view detailed information about that method.

| Methods                                         | Description             |
| :---------------------------------------------- | :---------------------- |
| [addEnvelopeAnnotation](#addenvelopeannotation) | Add envelope annotation |

## addEnvelopeAnnotation

Add envelope annotation

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/annotation`

**Parameters**

| Name              | Type                                                                            | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------ | :------- | :------------------------ |
| envelopeId        | String                                                                          | ✅       |                           |
| requestParameters | [AddEnvelopeAnnotationParameters](../models/AddEnvelopeAnnotationParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.AddEnvelopeAnnotationParameters;
import com.alohi.signplus.models.AddEnvelopeAnnotationRequest;
import com.alohi.signplus.models.AddEnvelopeAnnotationRequestCheckbox;
import com.alohi.signplus.models.AddEnvelopeAnnotationRequestDatetime;
import com.alohi.signplus.models.AddEnvelopeAnnotationRequestInitials;
import com.alohi.signplus.models.AddEnvelopeAnnotationRequestSignature;
import com.alohi.signplus.models.AddEnvelopeAnnotationRequestText;
import com.alohi.signplus.models.DatetimeFont1;
import com.alohi.signplus.models.TextFont1;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    AddEnvelopeAnnotationRequestSignature addEnvelopeAnnotationRequestSignature =
      AddEnvelopeAnnotationRequestSignature.builder().id("<string>").build();

    AddEnvelopeAnnotationRequestInitials addEnvelopeAnnotationRequestInitials =
      AddEnvelopeAnnotationRequestInitials.builder().id("<string>").build();

    TextFont1 textFont1 = TextFont1.builder()
      .family("SANS")
      .italic("<boolean>")
      .bold("<boolean>")
      .build();

    AddEnvelopeAnnotationRequestText addEnvelopeAnnotationRequestText =
      AddEnvelopeAnnotationRequestText.builder()
        .size("<number>")
        .color("<number>")
        .value("<string>")
        .tooltip("<string>")
        .dynamicFieldName("<string>")
        .font(textFont1)
        .build();

    DatetimeFont1 datetimeFont1 = DatetimeFont1.builder()
      .family("UNKNOWN")
      .italic("<boolean>")
      .bold("<boolean>")
      .build();

    AddEnvelopeAnnotationRequestDatetime addEnvelopeAnnotationRequestDatetime =
      AddEnvelopeAnnotationRequestDatetime.builder()
        .size("<number>")
        .font(datetimeFont1)
        .color("<string>")
        .autoFill("<boolean>")
        .timezone("<string>")
        .timestamp("<integer>")
        .format("YMD_NUMERIC_SLASH")
        .build();

    AddEnvelopeAnnotationRequestCheckbox addEnvelopeAnnotationRequestCheckbox =
      AddEnvelopeAnnotationRequestCheckbox.builder()
        .checked("<boolean>")
        .style("TIMES_SQUARE")
        .build();

    AddEnvelopeAnnotationRequest addEnvelopeAnnotationRequest =
      AddEnvelopeAnnotationRequest.builder()
        .documentId("<string>")
        .page("<integer>")
        .x("<float>")
        .y("<float>")
        .width("<float>")
        .height("<float>")
        .type("INITIALS")
        .recipientId("<string>")
        .required("<boolean>")
        .signature(addEnvelopeAnnotationRequestSignature)
        .initials(addEnvelopeAnnotationRequestInitials)
        .text(addEnvelopeAnnotationRequestText)
        .datetime(addEnvelopeAnnotationRequestDatetime)
        .checkbox(addEnvelopeAnnotationRequestCheckbox)
        .build();

    AddEnvelopeAnnotationParameters requestParameters = AddEnvelopeAnnotationParameters.builder()
      .accept("application/json")
      .requestBody(addEnvelopeAnnotationRequest)
      .build();

    Object response = signplus.annotation.addEnvelopeAnnotation("envelope_id", requestParameters);

    System.out.println(response);
  }
}

```
