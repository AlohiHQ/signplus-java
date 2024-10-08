# Signplus Java SDK 2.0.0

Welcome to the Signplus SDK documentation. This guide will help you get started with integrating and using the Signplus SDK in your project.

## Versions

- API version: `2.0.0`
- SDK version: `2.0.0`

## About the API

Integrate legally-binding electronic signature to your workflow

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
- [Authentication](#authentication)
  - [Access Token Authentication](#access-token-authentication)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)
- [License](#license)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>com.alohi</groupId>
    <artifactId>signplus</artifactId>
    <version>2.0.0</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation group: com.alohi, name: signplus, version: 2.0.0
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Authentication

### Access Token Authentication

The Signplus API uses an Access Token for authentication.

This token must be provided to authenticate your requests to the API.

#### Setting the Access Token

When you initialize the SDK, you can set the access token as follows:

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);
  }
}

```

If you need to set or update the access token after initializing the SDK, you can use:

```java
signplus.setAccessToken('YOUR_ACCESS_TOKEN');
```

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().timeout(10000).build();
    Signplus signplus = new Signplus(config);
  }
}

```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```java
import com.alohi.signplus.Signplus;
import com.alohi.signplus.config.SignplusConfig;
import com.alohi.signplus.models.Envelope;

public class Main {

  public static void main(String[] args) {
    SignplusConfig config = SignplusConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    Signplus signplus = new Signplus(config);

    Envelope response = signplus.signplusService.getEnvelope("envelope_id");

    System.out.println(response);
  }
}

```

## Services

The SDK provides various services to interact with the API.

<details> 
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                         |
| :----------------------------------------------------------- |
| [SignplusService](documentation/services/SignplusService.md) |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details> 
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                                                       | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| :--------------------------------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [CreateEnvelopeRequest](documentation/models/CreateEnvelopeRequest.md)                                     |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [Envelope](documentation/models/Envelope.md)                                                               |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [CreateEnvelopeFromTemplateRequest](documentation/models/CreateEnvelopeFromTemplateRequest.md)             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListEnvelopesRequest](documentation/models/ListEnvelopesRequest.md)                                       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListEnvelopesResponse](documentation/models/ListEnvelopesResponse.md)                                     |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [Document](documentation/models/Document.md)                                                               |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListEnvelopeDocumentsResponse](documentation/models/ListEnvelopeDocumentsResponse.md)                     |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [AddEnvelopeDocumentRequest](documentation/models/AddEnvelopeDocumentRequest.md)                           |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [SetEnvelopeDynamicFieldsRequest](documentation/models/SetEnvelopeDynamicFieldsRequest.md)                 |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [AddEnvelopeSigningStepsRequest](documentation/models/AddEnvelopeSigningStepsRequest.md)                   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [RenameEnvelopeRequest](documentation/models/RenameEnvelopeRequest.md)                                     |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [SetEnvelopeCommentRequest](documentation/models/SetEnvelopeCommentRequest.md)                             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [EnvelopeNotification](documentation/models/EnvelopeNotification.md)                                       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [SetEnvelopeExpirationRequest](documentation/models/SetEnvelopeExpirationRequest.md)                       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [SetEnvelopeLegalityLevelRequest](documentation/models/SetEnvelopeLegalityLevelRequest.md)                 |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [Annotation](documentation/models/Annotation.md)                                                           |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListEnvelopeDocumentAnnotationsResponse](documentation/models/ListEnvelopeDocumentAnnotationsResponse.md) |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [AddAnnotationRequest](documentation/models/AddAnnotationRequest.md)                                       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [CreateTemplateRequest](documentation/models/CreateTemplateRequest.md)                                     |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [Template](documentation/models/Template.md)                                                               |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListTemplatesRequest](documentation/models/ListTemplatesRequest.md)                                       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListTemplatesResponse](documentation/models/ListTemplatesResponse.md)                                     |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [AddTemplateDocumentRequest](documentation/models/AddTemplateDocumentRequest.md)                           |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListTemplateDocumentsResponse](documentation/models/ListTemplateDocumentsResponse.md)                     |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [AddTemplateSigningStepsRequest](documentation/models/AddTemplateSigningStepsRequest.md)                   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [RenameTemplateRequest](documentation/models/RenameTemplateRequest.md)                                     |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [SetTemplateCommentRequest](documentation/models/SetTemplateCommentRequest.md)                             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListTemplateAnnotationsResponse](documentation/models/ListTemplateAnnotationsResponse.md)                 |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListTemplateDocumentAnnotationsResponse](documentation/models/ListTemplateDocumentAnnotationsResponse.md) |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [CreateWebhookRequest](documentation/models/CreateWebhookRequest.md)                                       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [Webhook](documentation/models/Webhook.md)                                                                 |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListWebhooksRequest](documentation/models/ListWebhooksRequest.md)                                         |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [ListWebhooksResponse](documentation/models/ListWebhooksResponse.md)                                       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [EnvelopeLegalityLevel](documentation/models/EnvelopeLegalityLevel.md)                                     | Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes)                                                                                                                                                                                                                                                                                                                   |
| [EnvelopeFlowType](documentation/models/EnvelopeFlowType.md)                                               | Flow type of the envelope (REQUEST_SIGNATURE is a request for signature, SIGN_MYSELF is a self-signing flow)                                                                                                                                                                                                                                                                                                                                                                              |
| [EnvelopeStatus](documentation/models/EnvelopeStatus.md)                                                   | Status of the envelope                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| [SigningStep](documentation/models/SigningStep.md)                                                         |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [Recipient](documentation/models/Recipient.md)                                                             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [RecipientRole](documentation/models/RecipientRole.md)                                                     | Role of the recipient (SIGNER signs the document, RECEIVES_COPY receives a copy of the document, IN_PERSON_SIGNER signs the document in person, SENDER sends the document)                                                                                                                                                                                                                                                                                                                |
| [RecipientVerification](documentation/models/RecipientVerification.md)                                     |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [RecipientVerificationType](documentation/models/RecipientVerificationType.md)                             | Type of signature verification (SMS sends a code via SMS, PASSCODE requires a code to be entered)                                                                                                                                                                                                                                                                                                                                                                                         |
| [Page](documentation/models/Page.md)                                                                       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [EnvelopeOrderField](documentation/models/EnvelopeOrderField.md)                                           | Field to order envelopes by                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| [DynamicField](documentation/models/DynamicField.md)                                                       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [AnnotationType](documentation/models/AnnotationType.md)                                                   | Type of the annotation                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| [AnnotationSignature](documentation/models/AnnotationSignature.md)                                         | Signature annotation (null if annotation is not a signature)                                                                                                                                                                                                                                                                                                                                                                                                                              |
| [AnnotationInitials](documentation/models/AnnotationInitials.md)                                           | Initials annotation (null if annotation is not initials)                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| [AnnotationText](documentation/models/AnnotationText.md)                                                   | Text annotation (null if annotation is not a text)                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| [AnnotationDateTime](documentation/models/AnnotationDateTime.md)                                           | Date annotation (null if annotation is not a date)                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| [AnnotationCheckbox](documentation/models/AnnotationCheckbox.md)                                           | Checkbox annotation (null if annotation is not a checkbox)                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [AnnotationFont](documentation/models/AnnotationFont.md)                                                   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [AnnotationFontFamily](documentation/models/AnnotationFontFamily.md)                                       | Font family of the text                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| [AnnotationDateTimeFormat](documentation/models/AnnotationDateTimeFormat.md)                               | Format of the date time (DMY_NUMERIC_SLASH is day/month/year with slashes, MDY_NUMERIC_SLASH is month/day/year with slashes, YMD_NUMERIC_SLASH is year/month/day with slashes, DMY_NUMERIC_DASH_SHORT is day/month/year with dashes, DMY_NUMERIC_DASH is day/month/year with dashes, YMD_NUMERIC_DASH is year/month/day with dashes, MDY_TEXT_DASH_SHORT is month/day/year with dashes, MDY_TEXT_SPACE_SHORT is month/day/year with spaces, MDY_TEXT_SPACE is month/day/year with spaces) |
| [AnnotationCheckboxStyle](documentation/models/AnnotationCheckboxStyle.md)                                 | Style of the checkbox                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| [TemplateSigningStep](documentation/models/TemplateSigningStep.md)                                         |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [TemplateRecipient](documentation/models/TemplateRecipient.md)                                             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [TemplateRecipientRole](documentation/models/TemplateRecipientRole.md)                                     | Role of the recipient (SIGNER signs the document, RECEIVES_COPY receives a copy of the document, IN_PERSON_SIGNER signs the document in person, SENDER sends the document)                                                                                                                                                                                                                                                                                                                |
| [TemplateOrderField](documentation/models/TemplateOrderField.md)                                           | Field to order templates by                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| [WebhookEvent](documentation/models/WebhookEvent.md)                                                       | Event of the webhook                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |

</details>

## License

This SDK is licensed under the MIT License.

See the [LICENSE](LICENSE) file for more details.
