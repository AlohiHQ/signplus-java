# SignplusService

A list of all methods in the `SignplusService` service. Click on the method name to view detailed information about that method.

| Methods                                                           | Description                       |
| :---------------------------------------------------------------- | :-------------------------------- |
| [createEnvelope](#createenvelope)                                 | Create new envelope               |
| [createEnvelopeFromTemplate](#createenvelopefromtemplate)         | Create new envelope from template |
| [listEnvelopes](#listenvelopes)                                   | List envelopes                    |
| [getEnvelope](#getenvelope)                                       | Get envelope                      |
| [deleteEnvelope](#deleteenvelope)                                 | Delete envelope                   |
| [getEnvelopeDocument](#getenvelopedocument)                       | Get envelope document             |
| [getEnvelopeDocuments](#getenvelopedocuments)                     | Get envelope documents            |
| [addEnvelopeDocument](#addenvelopedocument)                       | Add envelope document             |
| [setEnvelopeDynamicFields](#setenvelopedynamicfields)             | Set envelope dynamic fields       |
| [addEnvelopeSigningSteps](#addenvelopesigningsteps)               | Add envelope signing steps        |
| [sendEnvelope](#sendenvelope)                                     | Send envelope for signature       |
| [duplicateEnvelope](#duplicateenvelope)                           | Duplicate envelope                |
| [voidEnvelope](#voidenvelope)                                     | Void envelope                     |
| [renameEnvelope](#renameenvelope)                                 | Rename envelope                   |
| [setEnvelopeComment](#setenvelopecomment)                         | Set envelope comment              |
| [setEnvelopeNotification](#setenvelopenotification)               | Set envelope notification         |
| [setEnvelopeExpirationDate](#setenvelopeexpirationdate)           | Set envelope expiration date      |
| [setEnvelopeLegalityLevel](#setenvelopelegalitylevel)             | Set envelope legality level       |
| [getEnvelopeAnnotations](#getenvelopeannotations)                 | Get envelope annotations          |
| [getEnvelopeDocumentAnnotations](#getenvelopedocumentannotations) | Get envelope document annotations |
| [addEnvelopeAnnotation](#addenvelopeannotation)                   | Add envelope annotation           |
| [deleteEnvelopeAnnotation](#deleteenvelopeannotation)             | Delete envelope annotation        |
| [createTemplate](#createtemplate)                                 | Create new template               |
| [listTemplates](#listtemplates)                                   | List templates                    |
| [getTemplate](#gettemplate)                                       | Get template                      |
| [deleteTemplate](#deletetemplate)                                 | Delete template                   |
| [duplicateTemplate](#duplicatetemplate)                           | Duplicate template                |
| [addTemplateDocument](#addtemplatedocument)                       | Add template document             |
| [getTemplateDocument](#gettemplatedocument)                       | Get template document             |
| [getTemplateDocuments](#gettemplatedocuments)                     | Get template documents            |
| [addTemplateSigningSteps](#addtemplatesigningsteps)               | Add template signing steps        |
| [renameTemplate](#renametemplate)                                 | Rename template                   |
| [setTemplateComment](#settemplatecomment)                         | Set template comment              |
| [setTemplateNotification](#settemplatenotification)               | Set template notification         |
| [getTemplateAnnotations](#gettemplateannotations)                 | Get template annotations          |
| [getDocumentTemplateAnnotations](#getdocumenttemplateannotations) | Get document template annotations |
| [addTemplateAnnotation](#addtemplateannotation)                   | Add template annotation           |
| [deleteTemplateAnnotation](#deletetemplateannotation)             | Delete template annotation        |
| [createWebhook](#createwebhook)                                   | Create webhook                    |
| [listWebhooks](#listwebhooks)                                     | List webhooks                     |
| [deleteWebhook](#deletewebhook)                                   | Delete webhook                    |

## createEnvelope

Create new envelope

- HTTP Method: `POST`
- Endpoint: `/envelope`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| createEnvelopeRequest | [CreateEnvelopeRequest](../models/CreateEnvelopeRequest.md) | ✅       | Request Body |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.CreateEnvelopeRequest;
import alohi.signplus.signplus.models.Envelope;
import alohi.signplus.signplus.models.EnvelopeFlowType;
import alohi.signplus.signplus.models.EnvelopeLegalityLevel;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    CreateEnvelopeRequest createEnvelopeRequest = CreateEnvelopeRequest
      .builder()
      .name("name")
      .flowType(EnvelopeFlowType.REQUEST_SIGNATURE)
      .legalityLevel(EnvelopeLegalityLevel.SES)
      .expiresAt(8L)
      .comment("comment")
      .sandbox(false)
      .build();

    Envelope response = signplus.signplusService.createEnvelope(createEnvelopeRequest);

    System.out.println(response);
  }
}

```

## createEnvelopeFromTemplate

Create new envelope from template

- HTTP Method: `POST`
- Endpoint: `/envelope/from_template/{template_id}`

**Parameters**

| Name                              | Type                                                                                | Required | Description  |
| :-------------------------------- | :---------------------------------------------------------------------------------- | :------- | :----------- |
| templateId                        | String                                                                              | ✅       |              |
| createEnvelopeFromTemplateRequest | [CreateEnvelopeFromTemplateRequest](../models/CreateEnvelopeFromTemplateRequest.md) | ✅       | Request Body |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.CreateEnvelopeFromTemplateRequest;
import alohi.signplus.signplus.models.Envelope;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    CreateEnvelopeFromTemplateRequest createEnvelopeFromTemplateRequest = CreateEnvelopeFromTemplateRequest
      .builder()
      .name("name")
      .comment("comment")
      .sandbox(false)
      .build();

    Envelope response = signplus.signplusService.createEnvelopeFromTemplate(
      "template_id",
      createEnvelopeFromTemplateRequest
    );

    System.out.println(response);
  }
}

```

## listEnvelopes

List envelopes

- HTTP Method: `POST`
- Endpoint: `/envelopes`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| listEnvelopesRequest | [ListEnvelopesRequest](../models/ListEnvelopesRequest.md) | ❌       | Request Body |

**Return Type**

`ListEnvelopesResponse`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.EnvelopeOrderField;
import alohi.signplus.signplus.models.EnvelopeStatus;
import alohi.signplus.signplus.models.ListEnvelopesRequest;
import alohi.signplus.signplus.models.ListEnvelopesResponse;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    List<String> tags = Arrays.asList("tags");

    List<String> ids = Arrays.asList("ids");

    List<EnvelopeStatus> statuses = Arrays.asList(EnvelopeStatus.DRAFT);

    List<String> folderIds = Arrays.asList("folder_ids");

    ListEnvelopesRequest listEnvelopesRequest = ListEnvelopesRequest
      .builder()
      .name("name")
      .tags(tags)
      .comment("comment")
      .ids(ids)
      .statuses(statuses)
      .folderIds(folderIds)
      .onlyRootFolder(true)
      .dateFrom(4L)
      .dateTo(7L)
      .uid("uid")
      .first(8L)
      .last(9L)
      .after("after")
      .before("before")
      .orderField(EnvelopeOrderField.CREATION_DATE)
      .ascending(false)
      .includeTrash(true)
      .build();

    ListEnvelopesResponse response = signplus.signplusService.listEnvelopes(listEnvelopesRequest);

    System.out.println(response);
  }
}

```

## getEnvelope

Get envelope

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| envelopeId | String | ✅       |             |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Envelope response = signplus.signplusService.getEnvelope("envelope_id");

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

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    signplus.signplusService.deleteEnvelope("envelope_id");
  }
}

```

## getEnvelopeDocument

Get envelope document

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/document/{document_id}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| envelopeId | String | ✅       |             |
| documentId | String | ✅       |             |

**Return Type**

`Document`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Document;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Document response = signplus.signplusService.getEnvelopeDocument("envelope_id", "document_id");

    System.out.println(response);
  }
}

```

## getEnvelopeDocuments

Get envelope documents

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/documents`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| envelopeId | String | ✅       |             |

**Return Type**

`ListEnvelopeDocumentsResponse`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.ListEnvelopeDocumentsResponse;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    ListEnvelopeDocumentsResponse response = signplus.signplusService.getEnvelopeDocuments("envelope_id");

    System.out.println(response);
  }
}

```

## addEnvelopeDocument

Add envelope document

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/document`

**Parameters**

| Name                       | Type                                                                  | Required | Description  |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :----------- |
| envelopeId                 | String                                                                | ✅       |              |
| addEnvelopeDocumentRequest | [AddEnvelopeDocumentRequest](../models/AddEnvelopeDocumentRequest.md) | ✅       | Request Body |

**Return Type**

`Document`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.AddEnvelopeDocumentRequest;
import alohi.signplus.signplus.models.Document;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    AddEnvelopeDocumentRequest addEnvelopeDocumentRequest = AddEnvelopeDocumentRequest.builder().file(file).build();

    Document response = signplus.signplusService.addEnvelopeDocument("envelope_id", addEnvelopeDocumentRequest);

    System.out.println(response);
  }
}

```

## setEnvelopeDynamicFields

Set envelope dynamic fields

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/dynamic_fields`

**Parameters**

| Name                            | Type                                                                            | Required | Description  |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :----------- |
| envelopeId                      | String                                                                          | ✅       |              |
| setEnvelopeDynamicFieldsRequest | [SetEnvelopeDynamicFieldsRequest](../models/SetEnvelopeDynamicFieldsRequest.md) | ✅       | Request Body |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.DynamicField;
import alohi.signplus.signplus.models.Envelope;
import alohi.signplus.signplus.models.SetEnvelopeDynamicFieldsRequest;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    DynamicField dynamicField = DynamicField.builder().name("name").value("value").build();

    List<DynamicField> dynamicFields = Arrays.asList(dynamicField);

    SetEnvelopeDynamicFieldsRequest setEnvelopeDynamicFieldsRequest = SetEnvelopeDynamicFieldsRequest
      .builder()
      .dynamicFields(dynamicFields)
      .build();

    Envelope response = signplus.signplusService.setEnvelopeDynamicFields(
      "envelope_id",
      setEnvelopeDynamicFieldsRequest
    );

    System.out.println(response);
  }
}

```

## addEnvelopeSigningSteps

Add envelope signing steps

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/signing_steps`

**Parameters**

| Name                           | Type                                                                          | Required | Description  |
| :----------------------------- | :---------------------------------------------------------------------------- | :------- | :----------- |
| envelopeId                     | String                                                                        | ✅       |              |
| addEnvelopeSigningStepsRequest | [AddEnvelopeSigningStepsRequest](../models/AddEnvelopeSigningStepsRequest.md) | ✅       | Request Body |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.AddEnvelopeSigningStepsRequest;
import alohi.signplus.signplus.models.Envelope;
import alohi.signplus.signplus.models.Recipient;
import alohi.signplus.signplus.models.RecipientRole;
import alohi.signplus.signplus.models.RecipientVerification;
import alohi.signplus.signplus.models.RecipientVerificationType;
import alohi.signplus.signplus.models.SigningStep;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    RecipientVerification recipientVerification = RecipientVerification
      .builder()
      .type(RecipientVerificationType.SMS)
      .value("value")
      .build();

    Recipient recipient = Recipient
      .builder()
      .id("id")
      .uid("uid")
      .name("name")
      .email("email")
      .role(RecipientRole.SIGNER)
      .verification(recipientVerification)
      .build();

    List<Recipient> recipients = Arrays.asList(recipient);

    SigningStep signingStep = SigningStep.builder().recipients(recipients).build();

    List<SigningStep> signingSteps = Arrays.asList(signingStep);

    AddEnvelopeSigningStepsRequest addEnvelopeSigningStepsRequest = AddEnvelopeSigningStepsRequest
      .builder()
      .signingSteps(signingSteps)
      .build();

    Envelope response = signplus.signplusService.addEnvelopeSigningSteps("envelope_id", addEnvelopeSigningStepsRequest);

    System.out.println(response);
  }
}

```

## sendEnvelope

Send envelope for signature

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/send`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| envelopeId | String | ✅       |             |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Envelope response = signplus.signplusService.sendEnvelope("envelope_id");

    System.out.println(response);
  }
}

```

## duplicateEnvelope

Duplicate envelope

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/duplicate`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| envelopeId | String | ✅       |             |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Envelope response = signplus.signplusService.duplicateEnvelope("envelope_id");

    System.out.println(response);
  }
}

```

## voidEnvelope

Void envelope

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/void`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| envelopeId | String | ✅       |             |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Envelope response = signplus.signplusService.voidEnvelope("envelope_id");

    System.out.println(response);
  }
}

```

## renameEnvelope

Rename envelope

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/rename`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| envelopeId            | String                                                      | ✅       |              |
| renameEnvelopeRequest | [RenameEnvelopeRequest](../models/RenameEnvelopeRequest.md) | ✅       | Request Body |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;
import alohi.signplus.signplus.models.RenameEnvelopeRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    RenameEnvelopeRequest renameEnvelopeRequest = RenameEnvelopeRequest.builder().name("name").build();

    Envelope response = signplus.signplusService.renameEnvelope("envelope_id", renameEnvelopeRequest);

    System.out.println(response);
  }
}

```

## setEnvelopeComment

Set envelope comment

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/set_comment`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| envelopeId                | String                                                              | ✅       |              |
| setEnvelopeCommentRequest | [SetEnvelopeCommentRequest](../models/SetEnvelopeCommentRequest.md) | ✅       | Request Body |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;
import alohi.signplus.signplus.models.SetEnvelopeCommentRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetEnvelopeCommentRequest setEnvelopeCommentRequest = SetEnvelopeCommentRequest
      .builder()
      .comment("comment")
      .build();

    Envelope response = signplus.signplusService.setEnvelopeComment("envelope_id", setEnvelopeCommentRequest);

    System.out.println(response);
  }
}

```

## setEnvelopeNotification

Set envelope notification

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/set_notification`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| envelopeId           | String                                                    | ✅       |              |
| envelopeNotification | [EnvelopeNotification](../models/EnvelopeNotification.md) | ✅       | Request Body |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;
import alohi.signplus.signplus.models.EnvelopeNotification;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    EnvelopeNotification envelopeNotification = EnvelopeNotification
      .builder()
      .subject("subject")
      .message("message")
      .reminderInterval(1L)
      .build();

    Envelope response = signplus.signplusService.setEnvelopeNotification("envelope_id", envelopeNotification);

    System.out.println(response);
  }
}

```

## setEnvelopeExpirationDate

Set envelope expiration date

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/set_expiration_date`

**Parameters**

| Name                         | Type                                                                      | Required | Description  |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :----------- |
| envelopeId                   | String                                                                    | ✅       |              |
| setEnvelopeExpirationRequest | [SetEnvelopeExpirationRequest](../models/SetEnvelopeExpirationRequest.md) | ✅       | Request Body |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;
import alohi.signplus.signplus.models.SetEnvelopeExpirationRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetEnvelopeExpirationRequest setEnvelopeExpirationRequest = SetEnvelopeExpirationRequest
      .builder()
      .expiresAt(6L)
      .build();

    Envelope response = signplus.signplusService.setEnvelopeExpirationDate("envelope_id", setEnvelopeExpirationRequest);

    System.out.println(response);
  }
}

```

## setEnvelopeLegalityLevel

Set envelope legality level

- HTTP Method: `PUT`
- Endpoint: `/envelope/{envelope_id}/set_legality_level`

**Parameters**

| Name                            | Type                                                                            | Required | Description  |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :----------- |
| envelopeId                      | String                                                                          | ✅       |              |
| setEnvelopeLegalityLevelRequest | [SetEnvelopeLegalityLevelRequest](../models/SetEnvelopeLegalityLevelRequest.md) | ✅       | Request Body |

**Return Type**

`Envelope`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Envelope;
import alohi.signplus.signplus.models.EnvelopeLegalityLevel;
import alohi.signplus.signplus.models.SetEnvelopeLegalityLevelRequest;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetEnvelopeLegalityLevelRequest setEnvelopeLegalityLevelRequest = SetEnvelopeLegalityLevelRequest
      .builder()
      .legalityLevel(EnvelopeLegalityLevel.SES)
      .build();

    Envelope response = signplus.signplusService.setEnvelopeLegalityLevel(
      "envelope_id",
      setEnvelopeLegalityLevelRequest
    );

    System.out.println(response);
  }
}

```

## getEnvelopeAnnotations

Get envelope annotations

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/annotations`

**Parameters**

| Name       | Type   | Required | Description        |
| :--------- | :----- | :------- | :----------------- |
| envelopeId | String | ✅       | ID of the envelope |

**Return Type**

`List<Annotation>`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Annotation;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    List<Annotation> response = signplus.signplusService.getEnvelopeAnnotations("envelope_id");

    System.out.println(response);
  }
}

```

## getEnvelopeDocumentAnnotations

Get envelope document annotations

- HTTP Method: `GET`
- Endpoint: `/envelope/{envelope_id}/annotations/{document_id}`

**Parameters**

| Name       | Type   | Required | Description        |
| :--------- | :----- | :------- | :----------------- |
| envelopeId | String | ✅       | ID of the envelope |
| documentId | String | ✅       | ID of document     |

**Return Type**

`ListEnvelopeDocumentAnnotationsResponse`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.ListEnvelopeDocumentAnnotationsResponse;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    ListEnvelopeDocumentAnnotationsResponse response = signplus.signplusService.getEnvelopeDocumentAnnotations(
      "envelope_id",
      "document_id"
    );

    System.out.println(response);
  }
}

```

## addEnvelopeAnnotation

Add envelope annotation

- HTTP Method: `POST`
- Endpoint: `/envelope/{envelope_id}/annotation`

**Parameters**

| Name                 | Type                                                      | Required | Description        |
| :------------------- | :-------------------------------------------------------- | :------- | :----------------- |
| envelopeId           | String                                                    | ✅       | ID of the envelope |
| addAnnotationRequest | [AddAnnotationRequest](../models/AddAnnotationRequest.md) | ✅       | Request Body       |

**Return Type**

`Annotation`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.AddAnnotationRequest;
import alohi.signplus.signplus.models.Annotation;
import alohi.signplus.signplus.models.AnnotationCheckbox;
import alohi.signplus.signplus.models.AnnotationCheckboxStyle;
import alohi.signplus.signplus.models.AnnotationDateTime;
import alohi.signplus.signplus.models.AnnotationDateTimeFormat;
import alohi.signplus.signplus.models.AnnotationFont;
import alohi.signplus.signplus.models.AnnotationFontFamily;
import alohi.signplus.signplus.models.AnnotationInitials;
import alohi.signplus.signplus.models.AnnotationSignature;
import alohi.signplus.signplus.models.AnnotationText;
import alohi.signplus.signplus.models.AnnotationType;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    AnnotationSignature annotationSignature = AnnotationSignature.builder().id("id").build();

    AnnotationInitials annotationInitials = AnnotationInitials.builder().id("id").build();

    AnnotationFont annotationFont = AnnotationFont
      .builder()
      .family(AnnotationFontFamily.UNKNOWN)
      .italic(true)
      .bold(true)
      .build();

    AnnotationText annotationText = AnnotationText
      .builder()
      .size(0.75D)
      .color(0.4D)
      .value("value")
      .tooltip("tooltip")
      .dynamicFieldName("dynamic_field_name")
      .font(annotationFont)
      .build();

    AnnotationDateTime annotationDateTime = AnnotationDateTime
      .builder()
      .size(2.34D)
      .font(annotationFont)
      .color("color")
      .autoFill(false)
      .timezone("timezone")
      .timestamp(6L)
      .format(AnnotationDateTimeFormat.DMY_NUMERIC_SLASH)
      .build();

    AnnotationCheckbox annotationCheckbox = AnnotationCheckbox
      .builder()
      .checked(true)
      .style(AnnotationCheckboxStyle.CIRCLE_CHECK)
      .build();

    AddAnnotationRequest addAnnotationRequest = AddAnnotationRequest
      .builder()
      .recipientId("recipient_id")
      .documentId("document_id")
      .page(5L)
      .x(2.83D)
      .y(1.27D)
      .width(5.18D)
      .height(4.34D)
      .required(false)
      .type(AnnotationType.TEXT)
      .signature(annotationSignature)
      .initials(annotationInitials)
      .text(annotationText)
      .datetime(annotationDateTime)
      .checkbox(annotationCheckbox)
      .build();

    Annotation response = signplus.signplusService.addEnvelopeAnnotation("envelope_id", addAnnotationRequest);

    System.out.println(response);
  }
}

```

## deleteEnvelopeAnnotation

Delete envelope annotation

- HTTP Method: `DELETE`
- Endpoint: `/envelope/{envelope_id}/annotation/{annotation_id}`

**Parameters**

| Name         | Type   | Required | Description                    |
| :----------- | :----- | :------- | :----------------------------- |
| envelopeId   | String | ✅       | ID of the envelope             |
| annotationId | String | ✅       | ID of the annotation to delete |

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    signplus.signplusService.deleteEnvelopeAnnotation("envelope_id", "annotation_id");
  }
}

```

## createTemplate

Create new template

- HTTP Method: `POST`
- Endpoint: `/template`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| createTemplateRequest | [CreateTemplateRequest](../models/CreateTemplateRequest.md) | ✅       | Request Body |

**Return Type**

`Template`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.CreateTemplateRequest;
import alohi.signplus.signplus.models.Template;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    CreateTemplateRequest createTemplateRequest = CreateTemplateRequest.builder().name("name").build();

    Template response = signplus.signplusService.createTemplate(createTemplateRequest);

    System.out.println(response);
  }
}

```

## listTemplates

List templates

- HTTP Method: `POST`
- Endpoint: `/templates`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| listTemplatesRequest | [ListTemplatesRequest](../models/ListTemplatesRequest.md) | ❌       | Request Body |

**Return Type**

`ListTemplatesResponse`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.ListTemplatesRequest;
import alohi.signplus.signplus.models.ListTemplatesResponse;
import alohi.signplus.signplus.models.TemplateOrderField;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    List<String> tags = Arrays.asList("tags");

    List<String> ids = Arrays.asList("ids");

    ListTemplatesRequest listTemplatesRequest = ListTemplatesRequest
      .builder()
      .name("name")
      .tags(tags)
      .ids(ids)
      .first(2L)
      .last(0L)
      .after("after")
      .before("before")
      .orderField(TemplateOrderField.TEMPLATE_ID)
      .ascending(true)
      .build();

    ListTemplatesResponse response = signplus.signplusService.listTemplates(listTemplatesRequest);

    System.out.println(response);
  }
}

```

## getTemplate

Get template

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| templateId | String | ✅       |             |

**Return Type**

`Template`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Template;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Template response = signplus.signplusService.getTemplate("template_id");

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

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    signplus.signplusService.deleteTemplate("template_id");
  }
}

```

## duplicateTemplate

Duplicate template

- HTTP Method: `POST`
- Endpoint: `/template/{template_id}/duplicate`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| templateId | String | ✅       |             |

**Return Type**

`Template`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Template;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Template response = signplus.signplusService.duplicateTemplate("template_id");

    System.out.println(response);
  }
}

```

## addTemplateDocument

Add template document

- HTTP Method: `POST`
- Endpoint: `/template/{template_id}/document`

**Parameters**

| Name                       | Type                                                                  | Required | Description  |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :----------- |
| templateId                 | String                                                                | ✅       |              |
| addTemplateDocumentRequest | [AddTemplateDocumentRequest](../models/AddTemplateDocumentRequest.md) | ✅       | Request Body |

**Return Type**

`Document`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.AddTemplateDocumentRequest;
import alohi.signplus.signplus.models.Document;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    AddTemplateDocumentRequest addTemplateDocumentRequest = AddTemplateDocumentRequest.builder().file(file).build();

    Document response = signplus.signplusService.addTemplateDocument("template_id", addTemplateDocumentRequest);

    System.out.println(response);
  }
}

```

## getTemplateDocument

Get template document

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}/document/{document_id}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| templateId | String | ✅       |             |
| documentId | String | ✅       |             |

**Return Type**

`Document`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.Document;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Document response = signplus.signplusService.getTemplateDocument("template_id", "document_id");

    System.out.println(response);
  }
}

```

## getTemplateDocuments

Get template documents

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}/documents`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| templateId | String | ✅       |             |

**Return Type**

`ListTemplateDocumentsResponse`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.ListTemplateDocumentsResponse;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    ListTemplateDocumentsResponse response = signplus.signplusService.getTemplateDocuments("template_id");

    System.out.println(response);
  }
}

```

## addTemplateSigningSteps

Add template signing steps

- HTTP Method: `POST`
- Endpoint: `/template/{template_id}/signing_steps`

**Parameters**

| Name                           | Type                                                                          | Required | Description  |
| :----------------------------- | :---------------------------------------------------------------------------- | :------- | :----------- |
| templateId                     | String                                                                        | ✅       |              |
| addTemplateSigningStepsRequest | [AddTemplateSigningStepsRequest](../models/AddTemplateSigningStepsRequest.md) | ✅       | Request Body |

**Return Type**

`Template`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.AddTemplateSigningStepsRequest;
import alohi.signplus.signplus.models.Template;
import alohi.signplus.signplus.models.TemplateRecipient;
import alohi.signplus.signplus.models.TemplateRecipientRole;
import alohi.signplus.signplus.models.TemplateSigningStep;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    TemplateRecipient templateRecipient = TemplateRecipient
      .builder()
      .id("id")
      .uid("uid")
      .name("name")
      .email("email")
      .role(TemplateRecipientRole.SIGNER)
      .build();

    List<TemplateRecipient> recipients = Arrays.asList(templateRecipient);

    TemplateSigningStep templateSigningStep = TemplateSigningStep.builder().recipients(recipients).build();

    List<TemplateSigningStep> signingSteps = Arrays.asList(templateSigningStep);

    AddTemplateSigningStepsRequest addTemplateSigningStepsRequest = AddTemplateSigningStepsRequest
      .builder()
      .signingSteps(signingSteps)
      .build();

    Template response = signplus.signplusService.addTemplateSigningSteps("template_id", addTemplateSigningStepsRequest);

    System.out.println(response);
  }
}

```

## renameTemplate

Rename template

- HTTP Method: `PUT`
- Endpoint: `/template/{template_id}/rename`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| templateId            | String                                                      | ✅       |              |
| renameTemplateRequest | [RenameTemplateRequest](../models/RenameTemplateRequest.md) | ✅       | Request Body |

**Return Type**

`Template`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.RenameTemplateRequest;
import alohi.signplus.signplus.models.Template;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    RenameTemplateRequest renameTemplateRequest = RenameTemplateRequest.builder().name("name").build();

    Template response = signplus.signplusService.renameTemplate("template_id", renameTemplateRequest);

    System.out.println(response);
  }
}

```

## setTemplateComment

Set template comment

- HTTP Method: `PUT`
- Endpoint: `/template/{template_id}/set_comment`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| templateId                | String                                                              | ✅       |              |
| setTemplateCommentRequest | [SetTemplateCommentRequest](../models/SetTemplateCommentRequest.md) | ✅       | Request Body |

**Return Type**

`Template`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.SetTemplateCommentRequest;
import alohi.signplus.signplus.models.Template;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    SetTemplateCommentRequest setTemplateCommentRequest = SetTemplateCommentRequest
      .builder()
      .comment("comment")
      .build();

    Template response = signplus.signplusService.setTemplateComment("template_id", setTemplateCommentRequest);

    System.out.println(response);
  }
}

```

## setTemplateNotification

Set template notification

- HTTP Method: `PUT`
- Endpoint: `/template/{template_id}/set_notification`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| templateId           | String                                                    | ✅       |              |
| envelopeNotification | [EnvelopeNotification](../models/EnvelopeNotification.md) | ✅       | Request Body |

**Return Type**

`Template`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.EnvelopeNotification;
import alohi.signplus.signplus.models.Template;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    EnvelopeNotification envelopeNotification = EnvelopeNotification
      .builder()
      .subject("subject")
      .message("message")
      .reminderInterval(1L)
      .build();

    Template response = signplus.signplusService.setTemplateNotification("template_id", envelopeNotification);

    System.out.println(response);
  }
}

```

## getTemplateAnnotations

Get template annotations

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}/annotations`

**Parameters**

| Name       | Type   | Required | Description        |
| :--------- | :----- | :------- | :----------------- |
| templateId | String | ✅       | ID of the template |

**Return Type**

`ListTemplateAnnotationsResponse`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.ListTemplateAnnotationsResponse;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    ListTemplateAnnotationsResponse response = signplus.signplusService.getTemplateAnnotations("template_id");

    System.out.println(response);
  }
}

```

## getDocumentTemplateAnnotations

Get document template annotations

- HTTP Method: `GET`
- Endpoint: `/template/{template_id}/annotations/{document_id}`

**Parameters**

| Name       | Type   | Required | Description        |
| :--------- | :----- | :------- | :----------------- |
| templateId | String | ✅       | ID of the template |
| documentId | String | ✅       | ID of document     |

**Return Type**

`ListTemplateDocumentAnnotationsResponse`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.ListTemplateDocumentAnnotationsResponse;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    ListTemplateDocumentAnnotationsResponse response = signplus.signplusService.getDocumentTemplateAnnotations(
      "template_id",
      "document_id"
    );

    System.out.println(response);
  }
}

```

## addTemplateAnnotation

Add template annotation

- HTTP Method: `POST`
- Endpoint: `/template/{template_id}/annotation`

**Parameters**

| Name                 | Type                                                      | Required | Description        |
| :------------------- | :-------------------------------------------------------- | :------- | :----------------- |
| templateId           | String                                                    | ✅       | ID of the template |
| addAnnotationRequest | [AddAnnotationRequest](../models/AddAnnotationRequest.md) | ✅       | Request Body       |

**Return Type**

`Annotation`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.AddAnnotationRequest;
import alohi.signplus.signplus.models.Annotation;
import alohi.signplus.signplus.models.AnnotationCheckbox;
import alohi.signplus.signplus.models.AnnotationCheckboxStyle;
import alohi.signplus.signplus.models.AnnotationDateTime;
import alohi.signplus.signplus.models.AnnotationDateTimeFormat;
import alohi.signplus.signplus.models.AnnotationFont;
import alohi.signplus.signplus.models.AnnotationFontFamily;
import alohi.signplus.signplus.models.AnnotationInitials;
import alohi.signplus.signplus.models.AnnotationSignature;
import alohi.signplus.signplus.models.AnnotationText;
import alohi.signplus.signplus.models.AnnotationType;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    AnnotationSignature annotationSignature = AnnotationSignature.builder().id("id").build();

    AnnotationInitials annotationInitials = AnnotationInitials.builder().id("id").build();

    AnnotationFont annotationFont = AnnotationFont
      .builder()
      .family(AnnotationFontFamily.UNKNOWN)
      .italic(true)
      .bold(true)
      .build();

    AnnotationText annotationText = AnnotationText
      .builder()
      .size(0.75D)
      .color(0.4D)
      .value("value")
      .tooltip("tooltip")
      .dynamicFieldName("dynamic_field_name")
      .font(annotationFont)
      .build();

    AnnotationDateTime annotationDateTime = AnnotationDateTime
      .builder()
      .size(2.34D)
      .font(annotationFont)
      .color("color")
      .autoFill(false)
      .timezone("timezone")
      .timestamp(6L)
      .format(AnnotationDateTimeFormat.DMY_NUMERIC_SLASH)
      .build();

    AnnotationCheckbox annotationCheckbox = AnnotationCheckbox
      .builder()
      .checked(true)
      .style(AnnotationCheckboxStyle.CIRCLE_CHECK)
      .build();

    AddAnnotationRequest addAnnotationRequest = AddAnnotationRequest
      .builder()
      .recipientId("recipient_id")
      .documentId("document_id")
      .page(5L)
      .x(2.83D)
      .y(1.27D)
      .width(5.18D)
      .height(4.34D)
      .required(false)
      .type(AnnotationType.TEXT)
      .signature(annotationSignature)
      .initials(annotationInitials)
      .text(annotationText)
      .datetime(annotationDateTime)
      .checkbox(annotationCheckbox)
      .build();

    Annotation response = signplus.signplusService.addTemplateAnnotation("template_id", addAnnotationRequest);

    System.out.println(response);
  }
}

```

## deleteTemplateAnnotation

Delete template annotation

- HTTP Method: `DELETE`
- Endpoint: `/template/{template_id}/annotation/{annotation_id}`

**Parameters**

| Name         | Type   | Required | Description                    |
| :----------- | :----- | :------- | :----------------------------- |
| templateId   | String | ✅       | ID of the template             |
| annotationId | String | ✅       | ID of the annotation to delete |

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    signplus.signplusService.deleteTemplateAnnotation("template_id", "annotation_id");
  }
}

```

## createWebhook

Create webhook

- HTTP Method: `POST`
- Endpoint: `/webhook`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| createWebhookRequest | [CreateWebhookRequest](../models/CreateWebhookRequest.md) | ✅       | Request Body |

**Return Type**

`Webhook`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.CreateWebhookRequest;
import alohi.signplus.signplus.models.Webhook;
import alohi.signplus.signplus.models.WebhookEvent;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    CreateWebhookRequest createWebhookRequest = CreateWebhookRequest
      .builder()
      .event(WebhookEvent.ENVELOPE_EXPIRED)
      .target("target")
      .build();

    Webhook response = signplus.signplusService.createWebhook(createWebhookRequest);

    System.out.println(response);
  }
}

```

## listWebhooks

List webhooks

- HTTP Method: `POST`
- Endpoint: `/webhooks`

**Parameters**

| Name                | Type                                                    | Required | Description  |
| :------------------ | :------------------------------------------------------ | :------- | :----------- |
| listWebhooksRequest | [ListWebhooksRequest](../models/ListWebhooksRequest.md) | ❌       | Request Body |

**Return Type**

`ListWebhooksResponse`

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;
import alohi.signplus.signplus.models.ListWebhooksRequest;
import alohi.signplus.signplus.models.ListWebhooksResponse;
import alohi.signplus.signplus.models.WebhookEvent;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    ListWebhooksRequest listWebhooksRequest = ListWebhooksRequest
      .builder()
      .webhookId("webhook_id")
      .event(WebhookEvent.ENVELOPE_EXPIRED)
      .build();

    ListWebhooksResponse response = signplus.signplusService.listWebhooks(listWebhooksRequest);

    System.out.println(response);
  }
}

```

## deleteWebhook

Delete webhook

- HTTP Method: `DELETE`
- Endpoint: `/webhook/{webhook_id}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| webhookId | String | ✅       |             |

**Example Usage Code Snippet**

```java
import alohi.signplus.signplus.Signplus;
import alohi.signplus.signplus.config.SignplusConfig;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    signplus.signplusService.deleteWebhook("webhook_id");
  }
}

```
