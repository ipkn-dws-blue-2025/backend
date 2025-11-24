

# OsKeypairsPostRequestKeypair


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Имя ключевой пары |  |
|**publicKey** | **String** | Публичный ключ. Если параметр не указан, то ключевая пара будет сгенерирована |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Тип ключевой пары |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SSH | &quot;ssh&quot; |
| X509 | &quot;x509&quot; |



