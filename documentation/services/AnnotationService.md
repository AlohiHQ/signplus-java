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
      AddEnvelopeAnnotationRequestSignature.builder().id("string").build();

    AddEnvelopeAnnotationRequestInitials addEnvelopeAnnotationRequestInitials =
      AddEnvelopeAnnotationRequestInitials.builder().id("string").build();

    TextFont1 textFont1 = TextFont1.builder().family("SANS").italic(false).bold(false).build();

    AddEnvelopeAnnotationRequestText addEnvelopeAnnotationRequestText =
      AddEnvelopeAnnotationRequestText.builder()
        .size(6190.822136605691D)
        .color(6489.781325519173D)
        .value("string")
        .tooltip("string")
        .dynamicFieldName("string")
        .font(textFont1)
        .build();

    DatetimeFont1 datetimeFont1 = DatetimeFont1.builder()
      .family("SERIF")
      .italic(false)
      .bold(false)
      .build();

    AddEnvelopeAnnotationRequestDatetime addEnvelopeAnnotationRequestDatetime =
      AddEnvelopeAnnotationRequestDatetime.builder()
        .size(3773.1065479576364D)
        .font(datetimeFont1)
        .color("string")
        .autoFill(true)
        .timezone("string")
        .timestamp(6868D)
        .format("MDY_TEXT_SPACE_SHORT")
        .build();

    AddEnvelopeAnnotationRequestCheckbox addEnvelopeAnnotationRequestCheckbox =
      AddEnvelopeAnnotationRequestCheckbox.builder().checked(false).style("SQUARE_CHECK").build();

    AddEnvelopeAnnotationRequest addEnvelopeAnnotationRequest =
      AddEnvelopeAnnotationRequest.builder()
        .documentId("string")
        .page(6387D)
        .x(4410.13346533615D)
        .y(5148.888749329143D)
        .width(3756.0248729763225D)
        .height(4178.76189579703D)
        .type("INITIALS")
        .recipientId("string")
        .required(false)
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
