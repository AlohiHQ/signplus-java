# ListEnvelopesRequest

**Properties**

| Name           | Type                 | Required | Description                                       |
| :------------- | :------------------- | :------- | :------------------------------------------------ |
| name           | String               | ❌       | Name of the envelope                              |
| tags           | List<String>         | ❌       | List of tags                                      |
| comment        | String               | ❌       | Comment of the envelope                           |
| ids            | List<String>         | ❌       | List of envelope IDs                              |
| statuses       | List<EnvelopeStatus> | ❌       | List of envelope statuses                         |
| folderIds      | List<String>         | ❌       | List of folder IDs                                |
| onlyRootFolder | Boolean              | ❌       | Whether to only list envelopes in the root folder |
| dateFrom       | Long                 | ❌       | Unix timestamp of the start date                  |
| dateTo         | Long                 | ❌       | Unix timestamp of the end date                    |
| uid            | String               | ❌       | Unique identifier of the user                     |
| first          | Long                 | ❌       |                                                   |
| last           | Long                 | ❌       |                                                   |
| after          | String               | ❌       |                                                   |
| before         | String               | ❌       |                                                   |
| orderField     | EnvelopeOrderField   | ❌       | Field to order envelopes by                       |
| ascending      | Boolean              | ❌       | Whether to order envelopes in ascending order     |
| includeTrash   | Boolean              | ❌       | Whether to include envelopes in the trash         |
