# ListTemplatesRequest

**Properties**

| Name       | Type               | Required | Description                                   |
| :--------- | :----------------- | :------- | :-------------------------------------------- |
| name       | String             | ❌       | Name of the template                          |
| tags       | List<String>       | ❌       | List of tag templates                         |
| ids        | List<String>       | ❌       | List of templates IDs                         |
| first      | Long               | ❌       |                                               |
| last       | Long               | ❌       |                                               |
| after      | String             | ❌       |                                               |
| before     | String             | ❌       |                                               |
| orderField | TemplateOrderField | ❌       | Field to order templates by                   |
| ascending  | Boolean            | ❌       | Whether to order templates in ascending order |
