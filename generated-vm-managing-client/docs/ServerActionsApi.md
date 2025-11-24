# ServerActionsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**serversServerIdActionPost**](ServerActionsApi.md#serversServerIdActionPost) | **POST** /servers/{server_id}/action | Выполнить действие с ВМ |



## serversServerIdActionPost

> serversServerIdActionPost(serverId, body)

Выполнить действие с ВМ

Метод позволяет управлять работой ВМ.  Укажите желаемое действие в теле запроса.

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServerActionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServerActionsApi apiInstance = new ServerActionsApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        Object body = {"addFloatingIp":{"address":"10.10.10.10","fixed_address":"192.168.0.3"}}; // Object | 
        try {
            apiInstance.serversServerIdActionPost(serverId, body);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServerActionsApi#serversServerIdActionPost");
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
| **body** | **Object**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | ОК |  -  |
| **400** | Некорректный запрос |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |
| **404** | Объект не найден |  -  |
| **409** | Конфликт |  -  |
| **501** | Метод еще не реализован |  -  |

