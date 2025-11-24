

# ServersPostRequestServer


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Имя ВМ |  |
|**flavorRef** | **String** | Идентификатор шаблона конфигурации ВМ |  |
|**imageRef** | **String** | Идентификатор образа, который будет использоваться для ВМ. Не требуется в случае загрузки с диска. Во всех остальных случаях параметр обязательный |  |
|**securityGroups** | [**List&lt;ServersPostRequestServerSecurityGroupsInner&gt;**](ServersPostRequestServerSecurityGroupsInner.md) | Одна или несколько групп безопасности. Если параметр не задан, на ВМ будет создана группа безопасности &#x60;&#x60;default&#x60;&#x60;. Запрошенные группы безопасности не применяются к уже существующим портам |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | Метаданные ВМ. Пары ключ — значение. Максимальный размер ключа и значения метаданных составляет 255 байт каждый |  [optional] |
|**accessIPv4** | **String** | IP-адрес версии 4 для доступа к ВМ |  [optional] |
|**accessIPv6** | **String** | IP-адрес версии 6 для доступа к ВМ |  [optional] |
|**adminPass** | **String** | Административный пароль ВМ |  |
|**userData** | **String** | Информация о конфигурации или сценарии, которые будут использоваться при запуске. Должно быть закодировано в Base64 |  [optional] |
|**availabilityZone** | **String** | Зона доступности ВМ |  [optional] |
|**configDrive** | **Boolean** | Указывает, надо ли подключать конфигурационный диск. Это устройство, монтируемое к ВМ на этапе запуска. ВМ может читать с него файлы, в том числе метаданные |  [optional] |
|**networks** | [**List&lt;ServersPostRequestServerNetworksInner&gt;**](ServersPostRequestServerNetworksInner.md) | Массив &#x60;&#x60;networks&#x60;&#x60;. Обязательный параметр, если в проекте несколько сетей. Если вы не указываете параметр &#x60;&#x60;networks&#x60;&#x60;, ВМ подключается к единственной сети, созданной для текущего проекта |  [optional] |
|**personality** | **List&lt;Object&gt;** | Путь к файлу и текст содержимого для вставки на ВМ при запуске. Максимальный размер данных пути к файлу составляет 255 байт |  [optional] |
|**blockDeviceMappingV2** | [**List&lt;ServersPostRequestServerBlockDeviceMappingV2Inner&gt;**](ServersPostRequestServerBlockDeviceMappingV2Inner.md) | Включает детальный контроль над сопоставлением блочных устройств для ВМ. Обычно это используется для загрузки серверов с дисков |  [optional] |
|**keyName** | **String** | Имя ключевой пары |  [optional] |
|**osColonSchedulerHints** | **Map&lt;String, String&gt;** | Словарь данных для отправки в планировщик. &#x60;&#x60;OS-SCH-HNT:scheduler_hints&#x60;&#x60; можно также указать в качестве строки |  [optional] |
|**osDCFColonDiskConfig** | [**OsDCFColonDiskConfigEnum**](#OsDCFColonDiskConfigEnum) | Конфигурация диска. Возможные значения:  &#x60;&#x60;AUTO&#x60;&#x60; — будет создана ВМ с одним разделом, размером с целевой диск. Файловая система автоматически настраивается, чтобы соответствовать всему разделу.  &#x60;&#x60;MANUAL&#x60;&#x60; — ВМ будет создана с использованием схемы разделов и файловую систему, которая находится в исходном образе, если целевой диск больше. Оставшееся дисковое пространство не будет разделено |  [optional] |
|**description** | **String** | Описание ВМ |  [optional] |
|**tags** | **List&lt;String&gt;** | Список тегов. Теги имеют следующие ограничения:  - Тег — это Unicode-строка длиной не более 60 символов.  - Тег не может быть пустой строкой.  - Теги чувствительны к регистру.  – Символы &#x60;/&#x60; и &#x60;,&#x60; запрещены в имени тега.  - У каждой ВМ может быть не более 50 тегов. |  [optional] |



## Enum: OsDCFColonDiskConfigEnum

| Name | Value |
|---- | -----|
| AUTO | &quot;AUTO&quot; |
| MANUAL | &quot;MANUAL&quot; |



