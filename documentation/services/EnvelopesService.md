# EnvelopesService

A list of all methods in the `EnvelopesService` service. Click on the method name to view detailed information about that method.

| Methods                         | Description    |
| :------------------------------ | :------------- |
| [listEnvelopes](#listenvelopes) | List envelopes |

## listEnvelopes

List envelopes

- HTTP Method: `POST`
- Endpoint: `/envelopes`

**Parameters**

| Name              | Type                                                            | Required | Description               |
| :---------------- | :-------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListEnvelopesParameters](../models/ListEnvelopesParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.ListEnvelopesParameters;
import com.alohi.signplus.models.ListEnvelopesRequest;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    List<String> tagsList = Arrays.asList("<string>");

    List<String> idsList = Arrays.asList("<string>");

    List<String> statusesList = Arrays.asList("PENDING");

    List<String> folderIdsList = Arrays.asList("<string>");

    ListEnvelopesRequest listEnvelopesRequest = ListEnvelopesRequest.builder()
      .name("<string>")
      .tags(tagsList)
      .comment("<string>")
      .ids(idsList)
      .statuses(statusesList)
      .folderIds(folderIdsList)
      .onlyRootFolder("<boolean>")
      .dateFrom("<integer>")
      .dateTo("<integer>")
      .uid("<string>")
      .first("<integer>")
      .last("<integer>")
      .after("<string>")
      .before("<string>")
      .orderField("LAST_DOCUMENT_CHANGE")
      .ascending("<boolean>")
      .includeTrash("<boolean>")
      .build();

    ListEnvelopesParameters requestParameters = ListEnvelopesParameters.builder()
      .accept("application/json")
      .requestBody(listEnvelopesRequest)
      .build();

    Object response = signplus.envelopes.listEnvelopes(requestParameters);

    System.out.println(response);
  }
}

```
