# FileIdService

A list of all methods in the `FileIdService` service. Click on the method name to view detailed information about that method.

| Methods                                 | Description                  |
| :-------------------------------------- | :--------------------------- |
| [getAttachmentFile](#getattachmentfile) | Get envelope attachment file |

## getAttachmentFile

Get envelope attachment file

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/attachments/{file_id}`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                  | ✅       |                           |
| fileId            | String                                                                  | ✅       |                           |
| requestParameters | [GetAttachmentFileParameters](../models/GetAttachmentFileParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetAttachmentFileParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetAttachmentFileParameters requestParameters = GetAttachmentFileParameters.builder()
      .accept("application/octet-stream")
      .build();

    Object response = signplus.fileId.getAttachmentFile(
      "envelope_id",
      "file_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
