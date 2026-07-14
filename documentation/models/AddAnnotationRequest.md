# AddAnnotationRequest

**Properties**

| Name        | Type                                          | Required | Description                                                                                     |
| :---------- | :-------------------------------------------- | :------- | :---------------------------------------------------------------------------------------------- |
| documentId  | String                                        | ✅       | ID of the document                                                                              |
| page        | Long                                          | ✅       | Page number where the annotation is placed                                                      |
| x           | Double                                        | ✅       | X coordinate of the annotation (in % of the page width from 0 to 100) from the top left corner  |
| y           | Double                                        | ✅       | Y coordinate of the annotation (in % of the page height from 0 to 100) from the top left corner |
| width       | Double                                        | ✅       | Width of the annotation (in % of the page width from 0 to 100)                                  |
| height      | Double                                        | ✅       | Height of the annotation (in % of the page height from 0 to 100)                                |
| type        | [AnnotationType](AnnotationType.md)           | ✅       | Type of the annotation                                                                          |
| recipientId | String                                        | ❌       | ID of the recipient                                                                             |
| required    | Boolean                                       | ❌       |                                                                                                 |
| signature   | [AnnotationSignature](AnnotationSignature.md) | ❌       | Signature annotation (null if annotation is not a signature)                                    |
| initials    | [AnnotationInitials](AnnotationInitials.md)   | ❌       | Initials annotation (null if annotation is not initials)                                        |
| text        | [AnnotationText](AnnotationText.md)           | ❌       | Text annotation (null if annotation is not a text)                                              |
| datetime    | [AnnotationDateTime](AnnotationDateTime.md)   | ❌       | Date annotation (null if annotation is not a date)                                              |
| checkbox    | [AnnotationCheckbox](AnnotationCheckbox.md)   | ❌       | Checkbox annotation (null if annotation is not a checkbox)                                      |
