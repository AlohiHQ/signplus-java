# SetCommentService

A list of all methods in the `SetCommentService` service. Click on the method name to view detailed information about that method.

| Methods                                   | Description          |
| :---------------------------------------- | :------------------- |
| [setEnvelopeComment](#setenvelopecomment) | Set envelope comment |

## setEnvelopeComment

Set envelope comment

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/set_comment`

**Parameters**

| Name              | Type                                                                      | Required | Description               |
| :---------------- | :------------------------------------------------------------------------ | :------- | :------------------------ |
| envelopeId        | String                                                                    | ✅       |                           |
| requestParameters | [SetEnvelopeCommentParameters](../models/SetEnvelopeCommentParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetEnvelopeCommentParameters;
import com.alohi.signplus.models.SetEnvelopeCommentRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetEnvelopeCommentRequest setEnvelopeCommentRequest = SetEnvelopeCommentRequest.builder()
      .comment("<string>")
      .build();

    SetEnvelopeCommentParameters requestParameters = SetEnvelopeCommentParameters.builder()
      .accept("application/json")
      .requestBody(setEnvelopeCommentRequest)
      .build();

    Object response = signplus.setComment.setEnvelopeComment("envelope_id", requestParameters);

    System.out.println(response);
  }
}

```
