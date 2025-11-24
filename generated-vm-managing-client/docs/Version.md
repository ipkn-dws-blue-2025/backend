

# Version

Одиночная запись о версии

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Имя версии. Не имеет реального семантического значения |  |
|**links** | **List&lt;Map&lt;String, String&gt;&gt;** | Ссылки на рассматриваемые ресурсы. Дополнительная информация — &#x60;http:developer.openstack.org/api-guide/compute/links_and_references.html&#x60; |  |
|**status** | [**StatusEnum**](#StatusEnum) | Статус версии |  |
|**version** | **String** | Если эта версия API поддерживает микроверсии, максимальная поддерживаемая микроверсия. Если микроверсии не поддерживаются, пустая строка |  |
|**minVersion** | **String** | Если эта версия API поддерживает микроверсии, минимальная поддерживаемая микроверсия. Если микроверсии не поддерживаются, пустая строка |  |
|**updated** | **String** | Дата и время обновления |  |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| CURRENT | &quot;CURRENT&quot; |
| SUPPORTED | &quot;SUPPORTED&quot; |
| DEPRECATED | &quot;DEPRECATED&quot; |



