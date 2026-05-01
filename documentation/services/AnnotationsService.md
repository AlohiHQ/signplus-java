# AnnotationsService

A list of all methods in the `AnnotationsService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description              |
| :------------------------------------------------ | :----------------------- |
| [getEnvelopeAnnotations](#getenvelopeannotations) | Get envelope annotations |

## getEnvelopeAnnotations

Get envelope annotations

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/annotations`

**Parameters**

| Name              | Type                                                                              | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                            | ✅       |                           |
| requestParameters | [GetEnvelopeAnnotationsParameters](../models/GetEnvelopeAnnotationsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetEnvelopeAnnotationsParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetEnvelopeAnnotationsParameters requestParameters = GetEnvelopeAnnotationsParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.annotations.getEnvelopeAnnotations("envelope_id", requestParameters);

    System.out.println(response);
  }
}

```
