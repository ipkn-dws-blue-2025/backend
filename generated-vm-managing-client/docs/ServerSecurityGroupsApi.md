# ServerSecurityGroupsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**serversServerIdOsSecurityGroupsGet**](ServerSecurityGroupsApi.md#serversServerIdOsSecurityGroupsGet) | **GET** /servers/{server_id}/os-security-groups | Получить список групп безопасности ВМ |



## serversServerIdOsSecurityGroupsGet

> ServersServerIdOsSecurityGroupsGet200Response serversServerIdOsSecurityGroupsGet(serverId)

Получить список групп безопасности ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServerSecurityGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServerSecurityGroupsApi apiInstance = new ServerSecurityGroupsApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        try {
            ServersServerIdOsSecurityGroupsGet200Response result = apiInstance.serversServerIdOsSecurityGroupsGet(serverId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServerSecurityGroupsApi#serversServerIdOsSecurityGroupsGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **serverId** | **String**| Идентификатор ВМ | |

### Return type

[**ServersServerIdOsSecurityGroupsGet200Response**](ServersServerIdOsSecurityGroupsGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ОК |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |
| **404** | Объект не найден |  -  |

