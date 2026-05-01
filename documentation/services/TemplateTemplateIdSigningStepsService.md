# TemplateTemplateIdSigningStepsService

A list of all methods in the `TemplateTemplateIdSigningStepsService` service. Click on the method name to view detailed information about that method.

| Methods                                             | Description                |
| :-------------------------------------------------- | :------------------------- |
| [addTemplateSigningSteps](#addtemplatesigningsteps) | Add template signing steps |

## addTemplateSigningSteps

Add template signing steps

- HTTP Method: `POST`
- Endpoint: `/template/{template_id}/signing_steps`

**Parameters**

| Name              | Type                                                                                | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :------------------------ |
| templateId        | String                                                                              | ✅       |                           |
| requestParameters | [AddTemplateSigningStepsParameters](../models/AddTemplateSigningStepsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.AddTemplateSigningStepsParameters;
import com.alohi.signplus.models.AddTemplateSigningStepsRequest;
import com.alohi.signplus.models.AddTemplateSigningStepsRequestSigningSteps;
import com.alohi.signplus.models.SigningStepsRecipients2;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SigningStepsRecipients2 signingStepsRecipients2 = SigningStepsRecipients2.builder()
      .id("<string>")
      .uid("<string>")
      .name("<string>")
      .email("<string>")
      .role("SIGNER")
      .build();

    List<SigningStepsRecipients2> recipientsList = Arrays.asList(signingStepsRecipients2);

    AddTemplateSigningStepsRequestSigningSteps addTemplateSigningStepsRequestSigningSteps =
      AddTemplateSigningStepsRequestSigningSteps.builder().recipients(recipientsList).build();

    List<AddTemplateSigningStepsRequestSigningSteps> signingStepsList = Arrays.asList(
      addTemplateSigningStepsRequestSigningSteps
    );

    AddTemplateSigningStepsRequest addTemplateSigningStepsRequest =
      AddTemplateSigningStepsRequest.builder().signingSteps(signingStepsList).build();

    AddTemplateSigningStepsParameters requestParameters =
      AddTemplateSigningStepsParameters.builder()
        .accept("application/json")
        .requestBody(addTemplateSigningStepsRequest)
        .build();

    Object response = signplus.templateTemplateIdSigningSteps.addTemplateSigningSteps(
      "template_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
