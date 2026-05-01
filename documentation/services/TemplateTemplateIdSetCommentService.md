# TemplateTemplateIdSetCommentService

A list of all methods in the `TemplateTemplateIdSetCommentService` service. Click on the method name to view detailed information about that method.

| Methods                                   | Description          |
| :---------------------------------------- | :------------------- |
| [setTemplateComment](#settemplatecomment) | Set template comment |

## setTemplateComment

Set template comment

- HTTP Method: `PUT`
- Endpoint: `/template/{template_id}/set_comment`

**Parameters**

| Name              | Type                                                                      | Required | Description               |
| :---------------- | :------------------------------------------------------------------------ | :------- | :------------------------ |
| templateId        | String                                                                    | ✅       |                           |
| requestParameters | [SetTemplateCommentParameters](../models/SetTemplateCommentParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.SetTemplateCommentParameters;
import com.alohi.signplus.models.SetTemplateCommentRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetTemplateCommentRequest setTemplateCommentRequest = SetTemplateCommentRequest.builder()
      .comment("string")
      .build();

    SetTemplateCommentParameters requestParameters = SetTemplateCommentParameters.builder()
      .accept("application/json")
      .requestBody(setTemplateCommentRequest)
      .build();

    Object response = signplus.templateTemplateIdSetComment.setTemplateComment(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
