# CertificateService

A list of all methods in the `CertificateService` service. Click on the method name to view detailed information about that method.

| Methods                                                     | Description                                        |
| :---------------------------------------------------------- | :------------------------------------------------- |
| [downloadEnvelopeCertificate](#downloadenvelopecertificate) | Download certificate of completion for an envelope |

## downloadEnvelopeCertificate

Download certificate of completion for an envelope

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/certificate`

**Parameters**

| Name              | Type                                                                                        | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------------ | :------- | :------------------------ |
| envelopeId        | String                                                                                      | ✅       |                           |
| requestParameters | [DownloadEnvelopeCertificateParameters](../models/DownloadEnvelopeCertificateParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.DownloadEnvelopeCertificateParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    DownloadEnvelopeCertificateParameters requestParameters =
      DownloadEnvelopeCertificateParameters.builder().accept("application/pdf").build();

    Object response = signplus.certificate.downloadEnvelopeCertificate(
      "envelope_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
