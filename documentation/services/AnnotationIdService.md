# AnnotationIdService

A list of all methods in the `AnnotationIdService` service. Click on the method name to view detailed information about that method.

| Methods                                               | Description                |
| :---------------------------------------------------- | :------------------------- |
| [deleteEnvelopeAnnotation](#deleteenvelopeannotation) | Delete envelope annotation |

## deleteEnvelopeAnnotation

Delete envelope annotation

- HTTP Method: `DELETE`
- Endpoint: `/envelope/{envelope_id}/annotation/{annotation_id}`

**Parameters**

| Name         | Type   | Required | Description |
| :----------- | :----- | :------- | :---------- |
| envelopeId   | String | ✅       |             |
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

    Object response = signplus.annotationId.deleteEnvelopeAnnotation(
      "envelope_id",
      "annotation_id"
    );

    System.out.println(response);
  }
}

```
