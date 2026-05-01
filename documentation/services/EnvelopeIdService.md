# EnvelopeIdService

A list of all methods in the `EnvelopeIdService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description     |
| :-------------------------------- | :-------------- |
| [getEnvelope](#getenvelope)       | Get envelope    |
| [deleteEnvelope](#deleteenvelope) | Delete envelope |

## getEnvelope

Get envelope

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}`

**Parameters**

| Name              | Type                                                        | Required | Description               |
| :---------------- | :---------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                      | ✅       |                           |
| requestParameters | [GetEnvelopeParameters](../models/GetEnvelopeParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetEnvelopeParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetEnvelopeParameters requestParameters = GetEnvelopeParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.envelopeId.getEnvelope("envelope_id", requestParameters);

    System.out.println(response);
  }
}

```

## deleteEnvelope

Delete envelope

- HTTP Method: `DELETE`
- Endpoint: `/envelope/{envelope_id}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| envelopeId | String | ✅       |             |

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

    Object response = signplus.envelopeId.deleteEnvelope("envelope_id");

    System.out.println(response);
  }
}

```
