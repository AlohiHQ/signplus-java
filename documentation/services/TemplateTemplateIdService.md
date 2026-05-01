# TemplateTemplateIdService

A list of all methods in the `TemplateTemplateIdService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description     |
| :-------------------------------- | :-------------- |
| [getTemplate](#gettemplate)       | Get template    |
| [deleteTemplate](#deletetemplate) | Delete template |

## getTemplate

Get template

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}`

**Parameters**

| Name              | Type                                                        | Required | Description               |
| :---------------- | :---------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                      | ✅       |                           |
| requestParameters | [GetTemplateParameters](../models/GetTemplateParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.GetTemplateParameters;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    GetTemplateParameters requestParameters = GetTemplateParameters.builder()
      .accept("application/json")
      .build();

    Object response = signplus.templateTemplateId.getTemplate("template_id", requestParameters);

    System.out.println(response);
  }
}

```

## deleteTemplate

Delete template

- HTTP Method: `DELETE`
- Endpoint: `/template/{template_id}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| templateId | String | ✅       |             |

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

    Object response = signplus.templateTemplateId.deleteTemplate("template_id");

    System.out.println(response);
  }
}

```
