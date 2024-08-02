# Envelope

**Properties**

| Name          | Type                  | Required | Description                                                                                                                                                             |
| :------------ | :-------------------- | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id            | String                | ❌       | Unique identifier of the envelope                                                                                                                                       |
| name          | String                | ❌       | Name of the envelope                                                                                                                                                    |
| comment       | String                | ❌       | Comment for the envelope                                                                                                                                                |
| pages         | Long                  | ❌       | Total number of pages in the envelope                                                                                                                                   |
| flowType      | EnvelopeFlowType      | ❌       | Flow type of the envelope (REQUEST_SIGNATURE is a request for signature, SIGN_MYSELF is a self-signing flow)                                                            |
| legalityLevel | EnvelopeLegalityLevel | ❌       | Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes) |
| status        | EnvelopeStatus        | ❌       | Status of the envelope                                                                                                                                                  |
| createdAt     | Long                  | ❌       | Unix timestamp of the creation date                                                                                                                                     |
| updatedAt     | Long                  | ❌       | Unix timestamp of the last modification date                                                                                                                            |
| expiresAt     | Long                  | ❌       | Unix timestamp of the expiration date                                                                                                                                   |
| numRecipients | Long                  | ❌       | Number of recipients in the envelope                                                                                                                                    |
| isDuplicable  | Boolean               | ❌       | Whether the envelope can be duplicated                                                                                                                                  |
| signingSteps  | List<SigningStep>     | ❌       |                                                                                                                                                                         |
| documents     | List<Document>        | ❌       |                                                                                                                                                                         |
| notification  | EnvelopeNotification  | ❌       |                                                                                                                                                                         |
