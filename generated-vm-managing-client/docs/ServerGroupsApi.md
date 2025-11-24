# ServerGroupsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**osServerGroupsGet**](ServerGroupsApi.md#osServerGroupsGet) | **GET** /os-server-groups | Получить список групп серверов |
| [**osServerGroupsPost**](ServerGroupsApi.md#osServerGroupsPost) | **POST** /os-server-groups | Создать группу серверов |
| [**osServerGroupsServerGroupIdDelete**](ServerGroupsApi.md#osServerGroupsServerGroupIdDelete) | **DELETE** /os-server-groups/{server_group_id} | Удалить группу серверов |
| [**osServerGroupsServerGroupIdGet**](ServerGroupsApi.md#osServerGroupsServerGroupIdGet) | **GET** /os-server-groups/{server_group_id} | Получить информацию о группе серверов |



## osServerGroupsGet

> OsServerGroupsGet200Response osServerGroupsGet(limit, offset)

Получить список групп серверов

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServerGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServerGroupsApi apiInstance = new ServerGroupsApi(defaultClient);
        Integer limit = 56; // Integer | Максимальное количество элементов, возвращаемых в одном ответе. Используется совместно с параметром ``offset``, чтобы в последующих запросах получать следующий набор элементов
        Integer offset = 56; // Integer | Порядковый номер элемента, с которого следует начать список
        try {
            OsServerGroupsGet200Response result = apiInstance.osServerGroupsGet(limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServerGroupsApi#osServerGroupsGet");
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
| **limit** | **Integer**| Максимальное количество элементов, возвращаемых в одном ответе. Используется совместно с параметром &#x60;&#x60;offset&#x60;&#x60;, чтобы в последующих запросах получать следующий набор элементов | [optional] |
| **offset** | **Integer**| Порядковый номер элемента, с которого следует начать список | [optional] |

### Return type

[**OsServerGroupsGet200Response**](OsServerGroupsGet200Response.md)

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


## osServerGroupsPost

> OsServerGroupsPost200Response osServerGroupsPost(osServerGroupsPostRequest)

Создать группу серверов

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServerGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServerGroupsApi apiInstance = new ServerGroupsApi(defaultClient);
        OsServerGroupsPostRequest osServerGroupsPostRequest = new OsServerGroupsPostRequest(); // OsServerGroupsPostRequest | Объект данных новой группы серверов в формате JSON
        try {
            OsServerGroupsPost200Response result = apiInstance.osServerGroupsPost(osServerGroupsPostRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServerGroupsApi#osServerGroupsPost");
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
| **osServerGroupsPostRequest** | [**OsServerGroupsPostRequest**](OsServerGroupsPostRequest.md)| Объект данных новой группы серверов в формате JSON | [optional] |

### Return type

[**OsServerGroupsPost200Response**](OsServerGroupsPost200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ОК |  -  |
| **400** | Некорректный запрос |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |


## osServerGroupsServerGroupIdDelete

> osServerGroupsServerGroupIdDelete(serverGroupId)

Удалить группу серверов

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServerGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServerGroupsApi apiInstance = new ServerGroupsApi(defaultClient);
        String serverGroupId = "serverGroupId_example"; // String | Идентификатор группы серверов
        try {
            apiInstance.osServerGroupsServerGroupIdDelete(serverGroupId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServerGroupsApi#osServerGroupsServerGroupIdDelete");
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
| **serverGroupId** | **String**| Идентификатор группы серверов | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | ОК |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |
| **404** | Объект не найден |  -  |


## osServerGroupsServerGroupIdGet

> OsServerGroupsPost200Response osServerGroupsServerGroupIdGet(serverGroupId)

Получить информацию о группе серверов

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServerGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServerGroupsApi apiInstance = new ServerGroupsApi(defaultClient);
        String serverGroupId = "serverGroupId_example"; // String | Идентификатор группы серверов
        try {
            OsServerGroupsPost200Response result = apiInstance.osServerGroupsServerGroupIdGet(serverGroupId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServerGroupsApi#osServerGroupsServerGroupIdGet");
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
| **serverGroupId** | **String**| Идентификатор группы серверов | |

### Return type

[**OsServerGroupsPost200Response**](OsServerGroupsPost200Response.md)

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

