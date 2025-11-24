

# OsServerGroupsPostRequestServerGroup


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Имя группы серверов |  |
|**policies** | [**List&lt;PoliciesEnum&gt;**](#List&lt;PoliciesEnum&gt;) | Список политик размещения группы серверов на вычислительных узлах |  |



## Enum: List&lt;PoliciesEnum&gt;

| Name | Value |
|---- | -----|
| AFFINITY | &quot;affinity&quot; |
| ANTI_AFFINITY | &quot;anti-affinity&quot; |
| SOFT_AFFINITY | &quot;soft-affinity&quot; |
| SOFT_ANTI_AFFINITY | &quot;soft-anti-affinity&quot; |



