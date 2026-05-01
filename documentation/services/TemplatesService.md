# TemplatesService

A list of all methods in the `TemplatesService` service. Click on the method name to view detailed information about that method.

| Methods                         | Description    |
| :------------------------------ | :------------- |
| [listTemplates](#listtemplates) | List templates |

## listTemplates

List templates

- HTTP Method: `POST`
- Endpoint: `/templates`

**Parameters**

| Name              | Type                                                            | Required | Description               |
| :---------------- | :-------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListTemplatesParameters](../models/ListTemplatesParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.ListTemplatesParameters;
import com.alohi.signplus.models.ListTemplatesRequest;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    List<String> tagsList = Arrays.asList("string");

    List<String> idsList = Arrays.asList("string");

    ListTemplatesRequest listTemplatesRequest = ListTemplatesRequest.builder()
      .name("string")
      .tags(tagsList)
      .ids(idsList)
      .first(7297D)
      .last(8379D)
      .after("string")
      .before("string")
      .orderField("TEMPLATE_NAME")
      .ascending(false)
      .build();

    ListTemplatesParameters requestParameters = ListTemplatesParameters.builder()
      .accept("application/json")
      .requestBody(listTemplatesRequest)
      .build();

    Object response = signplus.templates.listTemplates(requestParameters);

    System.out.println(response);
  }
}

```
