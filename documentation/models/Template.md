# Template

**Properties**

| Name            | Type                      | Required | Description                                                                                                                                                             |
| :-------------- | :------------------------ | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id              | String                    | ❌       | Unique identifier of the template                                                                                                                                       |
| name            | String                    | ❌       | Name of the template                                                                                                                                                    |
| comment         | String                    | ❌       | Comment for the template                                                                                                                                                |
| pages           | Long                      | ❌       | Total number of pages in the template                                                                                                                                   |
| legalityLevel   | EnvelopeLegalityLevel     | ❌       | Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes) |
| createdAt       | Long                      | ❌       | Unix timestamp of the creation date                                                                                                                                     |
| updatedAt       | Long                      | ❌       | Unix timestamp of the last modification date                                                                                                                            |
| expirationDelay | Long                      | ❌       | Expiration delay added to the current time when an envelope is created from this template                                                                               |
| numRecipients   | Long                      | ❌       | Number of recipients in the envelope                                                                                                                                    |
| signingSteps    | List<TemplateSigningStep> | ❌       |                                                                                                                                                                         |
| documents       | List<Document>            | ❌       |                                                                                                                                                                         |
| notification    | EnvelopeNotification      | ❌       |                                                                                                                                                                         |
| dynamicFields   | List<String>              | ❌       | List of dynamic fields                                                                                                                                                  |
