

# RebootVM

Перезапустить ВМ

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Тип перезапуска ВМ. Значение &#x60;&#x60;SOFT&#x60;&#x60; применимо только к ВМ в статусе &#x60;&#x60;ACTIVE&#x60;&#x60;. Значение &#x60;&#x60;HARD&#x60;&#x60; применимо к ВМ в статусах &#x60;&#x60;ACTIVE&#x60;&#x60;, &#x60;&#x60;ERROR&#x60;&#x60;, &#x60;&#x60;HARD_REBOOT&#x60;&#x60;, &#x60;&#x60;PAUSED&#x60;&#x60;, &#x60;&#x60;REBOOT&#x60;&#x60;, &#x60;&#x60;SHUTOFF&#x60;&#x60; и &#x60;&#x60;SUSPENDED&#x60;&#x60; |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| HARD | &quot;HARD&quot; |
| SOFT | &quot;SOFT&quot; |



