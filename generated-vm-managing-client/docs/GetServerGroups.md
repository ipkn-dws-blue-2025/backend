

# GetServerGroups

Группа серверов

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Идентификатор группы серверов |  |
|**name** | **String** | Имя группы серверов |  |
|**policies** | [**List&lt;PoliciesEnum&gt;**](#List&lt;PoliciesEnum&gt;) | Список политик размещения группы серверов на вычислительных узлах |  |
|**members** | **List&lt;String&gt;** | Список ВМ, входящих в группу |  |
|**metadata** | **Map&lt;String, String&gt;** | Метаданные группы серверов |  |
|**projectId** | **String** | Значение параметра &lt;a href&#x3D;&#39;https://cloud.vk.com/docs/tools-for-using-services/api/rest-api/endpoints#poluchenie_project_id&#39;&gt;Project ID&lt;/a&gt; для проекта |  [optional] |



## Enum: List&lt;PoliciesEnum&gt;

| Name | Value |
|---- | -----|
| AFFINITY | &quot;affinity&quot; |
| ANTI_AFFINITY | &quot;anti-affinity&quot; |
| SOFT_AFFINITY | &quot;soft-affinity&quot; |
| SOFT_ANTI_AFFINITY | &quot;soft-anti-affinity&quot; |



