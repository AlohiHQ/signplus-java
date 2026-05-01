# DynamicFieldsService

A list of all methods in the `DynamicFieldsService` service. Click on the method name to view detailed information about that method.

| Methods                                               | Description                 |
| :---------------------------------------------------- | :-------------------------- |
| [setEnvelopeDynamicFields](#setenvelopedynamicfields) | Set envelope dynamic fields |

## setEnvelopeDynamicFields

Set envelope dynamic fields

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/dynamic_fields`

**Parameters**

| Name              | Type                                                                                  | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------ | :------- | :------------------------ |
| envelopeId        | String                                                                                | ✅       |                           |
| requestParameters | [SetEnvelopeDynamicFieldsParameters](../models/SetEnvelopeDynamicFieldsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.DynamicFields;
import com.alohi.signplus.models.SetEnvelopeDynamicFieldsParameters;
import com.alohi.signplus.models.SetEnvelopeDynamicFieldsRequest;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    DynamicFields dynamicFields = DynamicFields.builder().name("string").value("string").build();

    List<DynamicFields> dynamicFieldsList = Arrays.asList(dynamicFields);

    SetEnvelopeDynamicFieldsRequest setEnvelopeDynamicFieldsRequest =
      SetEnvelopeDynamicFieldsRequest.builder().dynamicFields(dynamicFieldsList).build();

    SetEnvelopeDynamicFieldsParameters requestParameters =
      SetEnvelopeDynamicFieldsParameters.builder()
        .accept("application/json")
        .requestBody(setEnvelopeDynamicFieldsRequest)
        .build();

    Object response = signplus.dynamicFields.setEnvelopeDynamicFields(
      "envelope_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
