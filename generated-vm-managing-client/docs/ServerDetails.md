

# ServerDetails

Детальная информация о ВМ

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addresses** | **Object** | Адреса ВМ. Для получения дополнительной информации см. &#x60;&#x60;nova.conf&#x60;&#x60; параметры конфигурации http://docs.openstack.org/liberty/config-reference/content/list-of-compute-config-options.html |  [optional] |
|**created** | **String** | Дата и время создания ресурса. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC) |  [optional] |
|**flavor** | **Object** | Идентификатор и ссылки на шаблон конфигурации ВМ |  [optional] |
|**hostId** | **String** | Идентификатор хоста |  [optional] |
|**id** | **String** | Идентификатор ВМ |  [optional] |
|**image** | **Object** | Идентификатор и ссылки на образ. Объект может быть пустой при загрузке ВМ с диска |  [optional] |
|**keyName** | **String** | Имя связанной ключевой пары, если есть |  [optional] |
|**links** | [**List&lt;ServerDetailsLinksInner&gt;**](ServerDetailsLinksInner.md) | Ссылки на рассматриваемые ресурсы. Дополнительная информация — &#x60;http:developer.openstack.org/api-guide/compute/links_and_references.html&#x60; |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | Метаданные ВМ |  [optional] |
|**name** | **String** | Имя ВМ |  [optional] |
|**accessIPv4** | **String** | IP-адрес версии 4, который следует использовать для доступа к ВМ |  [optional] |
|**accessIPv6** | **String** | IP-адрес версии 6, который следует использовать для доступа к ВМ |  [optional] |
|**configDrive** | **Boolean** | Указывает, использовался ли для этой ВМ конфигурационный диск |  [optional] |
|**osDCFColonDiskConfig** | [**OsDCFColonDiskConfigEnum**](#OsDCFColonDiskConfigEnum) | Конфигурация диска. Возможные значения:  &#x60;&#x60;AUTO&#x60;&#x60; — будет создана ВМ с одним разделом, размером с целевой диск. Файловая система автоматически настраивается, чтобы соответствовать всему разделу.  &#x60;&#x60;MANUAL&#x60;&#x60; — ВМ будет создана с использованием схемы разделов и файловую систему, которая находится в исходном образе, если целевой диск больше. Оставшееся дисковое пространство не будет разделено |  [optional] |
|**osEXTAZColonAvailabilityZone** | **String** | Имя зоны доступности |  [optional] |
|**osEXTSTSColonPowerState** | [**OsEXTSTSColonPowerStateEnum**](#OsEXTSTSColonPowerStateEnum) | Состояние питания ВМ |  [optional] |
|**osEXTSTSColonTaskState** | **String** | Состояние задачи ВМ |  [optional] |
|**osEXTSTSColonVmState** | **String** | Состояние ВМ |  [optional] |
|**osExtendedVolumesColonVolumesAttached** | **Object** | Прикрепленные диски, если есть |  [optional] |
|**osSRVUSGColonLaunchedAt** | **String** | Дата и время запуска ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC) |  [optional] |
|**osSRVUSGColonTerminatedAt** | **String** | Дата и время удаления ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC) |  [optional] |
|**progress** | **Integer** | Процентное значение прогресса удаления |  [optional] |
|**securityGroups** | [**List&lt;ServersPostRequestServerSecurityGroupsInner&gt;**](ServersPostRequestServerSecurityGroupsInner.md) | Группы безопасности |  [optional] |
|**tenantId** | **String** | Значение параметра &lt;a href&#x3D;&#39;https://cloud.vk.com/docs/tools-for-using-services/api/rest-api/endpoints#poluchenie_project_id&#39;&gt;Project ID&lt;/a&gt; для проекта |  [optional] |
|**updated** | **String** | Дата и время обновления ресурса. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC) |  [optional] |
|**userId** | **String** | Идентификатор пользователя, которому принадлежит ВМ |  [optional] |
|**osEXTSERVATTRColonHostname** | **String** | Имя хоста, заданное для ВМ при его загрузке |  [optional] |
|**osEXTSERVATTRColonReservationId** | **String** | Идентификатор резервирования для ВМ. Этот идентификатор может быть полезен при отслеживании групп серверов, созданных множественным вызовом создания ВМ |  [optional] |
|**osEXTSERVATTRColonLaunchIndex** | **Integer** | Последовательность запуска ВМ, созданных множественным вызовом создания ВМ |  [optional] |
|**osEXTSERVATTRColonKernelId** | **String** | Идентификатор образа ядра при использовании AMI |  [optional] |
|**osEXTSERVATTRColonRamdiskId** | **String** | Идентификатор образа виртуального диска при использовании AMI |  [optional] |
|**osEXTSERVATTRColonRootDeviceName** | **String** | Имя корневого устройства для ВМ |  [optional] |
|**osEXTSERVATTRColonUserData** | **String** | Пользовательские данные, с которыми была создана ВМ |  [optional] |



## Enum: OsDCFColonDiskConfigEnum

| Name | Value |
|---- | -----|
| AUTO | &quot;AUTO&quot; |
| MANUAL | &quot;MANUAL&quot; |



## Enum: OsEXTSTSColonPowerStateEnum

| Name | Value |
|---- | -----|
| NUMBER_0 | 0 |
| NUMBER_1 | 1 |
| NUMBER_3 | 3 |
| NUMBER_4 | 4 |
| NUMBER_6 | 6 |
| NUMBER_7 | 7 |



