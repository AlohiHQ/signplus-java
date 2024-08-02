# CreateEnvelopeRequest

**Properties**

| Name          | Type                  | Required | Description                                                                                                                                                             |
| :------------ | :-------------------- | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| name          | String                | ✅       | Name of the envelope                                                                                                                                                    |
| flowType      | EnvelopeFlowType      | ✅       | Flow type of the envelope (REQUEST_SIGNATURE is a request for signature, SIGN_MYSELF is a self-signing flow)                                                            |
| legalityLevel | EnvelopeLegalityLevel | ✅       | Legal level of the envelope (SES is Simple Electronic Signature, QES_EIDAS is Qualified Electronic Signature, QES_ZERTES is Qualified Electronic Signature with Zertes) |
| expiresAt     | Long                  | ❌       | Unix timestamp of the expiration date                                                                                                                                   |
| comment       | String                | ❌       | Comment for the envelope                                                                                                                                                |
| sandbox       | Boolean               | ❌       | Whether the envelope is created in sandbox mode                                                                                                                         |
