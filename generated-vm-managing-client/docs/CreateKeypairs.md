

# CreateKeypairs


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Имя ключевой пары |  |
|**publicKey** | **String** | Публичный ключ |  |
|**privateKey** | **String** | Закрытый ключ. Возвращается, если в запросе не указан параметр &#x60;&#x60;public_key&#x60;&#x60;. Сохраните закрытый ключ, получить его потом будет невозможно |  [optional] |
|**fingerprint** | **String** | Цифровой отпечаток ключевой пары |  |
|**type** | [**TypeEnum**](#TypeEnum) | Тип ключевой пары |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SSH | &quot;ssh&quot; |
| X509 | &quot;x509&quot; |



