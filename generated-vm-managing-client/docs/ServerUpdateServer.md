

# ServerUpdateServer


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Новое имя ВМ |  [optional] |
|**description** | **String** | Новое описание ВМ |  [optional] |
|**accessIPv4** | **String** | Новый IP-адрес версии 4, который следует использовать для доступа к ВМ |  [optional] |
|**accessIPv6** | **String** | Новый IP-адрес версии 6, который следует использовать для доступа к ВМ |  [optional] |
|**osDCFColonDiskConfig** | [**OsDCFColonDiskConfigEnum**](#OsDCFColonDiskConfigEnum) | Конфигурация диска. Возможные значения:  &#x60;&#x60;AUTO&#x60;&#x60; — будет создана ВМ с одним разделом, размером с целевой диск. Файловая система автоматически настраивается, чтобы соответствовать всему разделу.  &#x60;&#x60;MANUAL&#x60;&#x60; — ВМ будет создана с использованием схемы разделов и файловую систему, которая находится в исходном образе, если целевой диск больше. Оставшееся дисковое пространство не будет разделено |  [optional] |



## Enum: OsDCFColonDiskConfigEnum

| Name | Value |
|---- | -----|
| AUTO | &quot;AUTO&quot; |
| MANUAL | &quot;MANUAL&quot; |



