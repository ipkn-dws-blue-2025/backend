

# FlavorDetails


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Имя шаблона конфигурации ВМ |  |
|**id** | **String** | Идентификатор шаблона конфигурации ВМ |  |
|**ram** | **Integer** | Количество RAM в мебибайтах |  |
|**disk** | **Integer** | Размер диска в гигибайтах |  |
|**vcpus** | **Integer** | Количество виртуальных процессоров |  |
|**links** | **Object** | Ссылки на рассматриваемые ресурсы. Дополнительная информация — http:developer.openstack.org/api-guide/compute/links_and_references.html |  |
|**osFLVEXTDATAColonEphemeral** | **Integer** | Размер эфемерного диска |  |
|**swap** | **Integer** | Размер swap-диска. Если &#x60;&#x60;0&#x60;&#x60;, swap-диск не будет создан |  |
|**rxtxFactor** | **BigDecimal** | Коэффициент приема/передачи, который будет установлен на портах, если поддерживается расширение QOS |  |
|**osFlavorAccessColonIsPublic** | **Boolean** | Указывает, является ли шаблон конфигурации ВМ общедоступным |  |
|**extraSpecs** | **Object** | Дополнительные сведения о шаблоне конфигурации ВМ |  |



