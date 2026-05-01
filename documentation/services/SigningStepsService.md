# SigningStepsService

A list of all methods in the `SigningStepsService` service. Click on the method name to view detailed information about that method.

| Methods                                             | Description                |
| :-------------------------------------------------- | :------------------------- |
| [addEnvelopeSigningSteps](#addenvelopesigningsteps) | Add envelope signing steps |

## addEnvelopeSigningSteps

Add envelope signing steps

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/signing_steps`

**Parameters**

| Name              | Type                                                                                | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :------------------------ |
| envelopeId        | String                                                                              | ✅       |                           |
| requestParameters | [AddEnvelopeSigningStepsParameters](../models/AddEnvelopeSigningStepsParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.AddEnvelopeSigningStepsParameters;
import com.alohi.signplus.models.AddEnvelopeSigningStepsRequest;
import com.alohi.signplus.models.AddEnvelopeSigningStepsRequestSigningSteps;
import com.alohi.signplus.models.SigningStepsRecipients1;
import com.alohi.signplus.models.Verification;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Verification verification = Verification.builder().type("SMS").value("string").build();

    SigningStepsRecipients1 signingStepsRecipients1 = SigningStepsRecipients1.builder()
      .name("string")
      .email("string")
      .role("IN_PERSON_SIGNER")
      .id("string")
      .uid("string")
      .verification(verification)
      .build();

    List<SigningStepsRecipients1> recipientsList = Arrays.asList(signingStepsRecipients1);

    AddEnvelopeSigningStepsRequestSigningSteps addEnvelopeSigningStepsRequestSigningSteps =
      AddEnvelopeSigningStepsRequestSigningSteps.builder().recipients(recipientsList).build();

    List<AddEnvelopeSigningStepsRequestSigningSteps> signingStepsList = Arrays.asList(
      addEnvelopeSigningStepsRequestSigningSteps
    );

    AddEnvelopeSigningStepsRequest addEnvelopeSigningStepsRequest =
      AddEnvelopeSigningStepsRequest.builder().signingSteps(signingStepsList).build();

    AddEnvelopeSigningStepsParameters requestParameters =
      AddEnvelopeSigningStepsParameters.builder()
        .accept("application/json")
        .requestBody(addEnvelopeSigningStepsRequest)
        .build();

    Object response = signplus.signingSteps.addEnvelopeSigningSteps(
      "envelope_id",
      requestParameters
    );

    System.out.println(response);
  }
}

```
