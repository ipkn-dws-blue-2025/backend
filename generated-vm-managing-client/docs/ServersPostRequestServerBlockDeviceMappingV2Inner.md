

# ServersPostRequestServerBlockDeviceMappingV2Inner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**deviceName** | **String** | Путь к устройству диска, который вы хотите использовать для загрузки сервера |  |
|**sourceType** | [**SourceTypeEnum**](#SourceTypeEnum) | Тип диска |  |
|**destinationType** | [**DestinationTypeEnum**](#DestinationTypeEnum) | Определяет, откуда берется диск |  [optional] |
|**deleteOnTermination** | **Boolean** | Чтобы удалить загрузочный диск при уничтожении сервера, укажите &#x60;&#x60;true&#x60;&#x60;. В противном случае укажите &#x60;&#x60;false&#x60;&#x60;. По умолчанию: &#x60;&#x60;false&#x60;&#x60; |  [optional] |
|**guestFormat** | [**GuestFormatEnum**](#GuestFormatEnum) | Формат файловой системы диска гостевого сервера |  |
|**bootIndex** | **String** | Порядок загрузки. Задайте каждому устройству уникальный индекс загрузки, начиная с &#x60;&#x60;0&#x60;&#x60;. Чтобы запретить использование устройства для загрузки, установите отрицательное значение или используйте значение &#x60;&#x60;None&#x60;&#x60;. Простой вариант использования: назначить устройству загрузки индекс &#x60;&#x60;0&#x60;&#x60;, а для всех остальных оставить значение по умолчанию — &#x60;&#x60;None&#x60;&#x60;.  Некоторые гипервизоры могут не поддерживать загрузку с нескольких устройств, в этом случае учитываются только устройства с индексом 0. Другие гипервизоры поддерживают загрузку с нескольких устройств, но только если они разных типов (например, диск и CD-ROM). |  |
|**uuid** | **String** | Идентификатор исходного ресурса. Его значение указывает на разные ресурсы в зависимости от параметра &#x60;&#x60;source_type&#x60;&#x60;. Например, если &#x60;&#x60;source_type&#x60;&#x60; имеет значение &#x60;&#x60;image&#x60;&#x60;, блочное устройство создается на основе указанного образа, полученного из сервиса образов |  [optional] |
|**tag** | **String** | Тег роли устройства, который можно применить к блочному устройству |  [optional] |



## Enum: SourceTypeEnum

| Name | Value |
|---- | -----|
| BLANK | &quot;blank&quot; |
| SNAPSHOT | &quot;snapshot&quot; |
| VOLUME | &quot;volume&quot; |
| IMAGE | &quot;image&quot; |



## Enum: DestinationTypeEnum

| Name | Value |
|---- | -----|
| LOCAL | &quot;local&quot; |
| VOLUME | &quot;volume&quot; |



## Enum: GuestFormatEnum

| Name | Value |
|---- | -----|
| EPHEMERAL | &quot;ephemeral&quot; |
| SWAP | &quot;swap&quot; |



