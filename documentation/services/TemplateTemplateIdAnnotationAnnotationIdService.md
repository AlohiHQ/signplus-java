# TemplateTemplateIdAnnotationAnnotationIdService

A list of all methods in the `TemplateTemplateIdAnnotationAnnotationIdService` service. Click on the method name to view detailed information about that method.

| Methods                                               | Description                |
| :---------------------------------------------------- | :------------------------- |
| [deleteTemplateAnnotation](#deletetemplateannotation) | Delete template annotation |

## deleteTemplateAnnotation

Delete template annotation

- HTTP Method: `DELETE`
- Endpoint: `/template/{template_id}/annotation/{annotation_id}`

**Parameters**

| Name         | Type   | Required | Description |
| :----------- | :----- | :------- | :---------- |
| templateId   | String | ✅       |             |
| annotationId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Object response = signplus.templateTemplateIdAnnotationAnnotationId.deleteTemplateAnnotation(
      "template_id",
      "annotation_id"
    );

    System.out.println(response);
  }
}

```
