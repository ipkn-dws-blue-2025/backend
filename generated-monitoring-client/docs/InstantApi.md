# InstantApi

All URIs are relative to *https://mcs.mail.ru/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**instantQuery**](InstantApi.md#instantQuery) | **GET** /{project_id}/query | Получить метрики в момент времени (Instant query) |



## instantQuery

> GetInstantQueryResponse instantQuery(projectId, query, namespace, time, step)

Получить метрики в момент времени (Instant query)

Выполнить запрос значений метрик для заданного момента времени

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstantApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mcs.mail.ru/v2");
        
        // Configure API key authorization: keystone
        ApiKeyAuth keystone = (ApiKeyAuth) defaultClient.getAuthentication("keystone");
        keystone.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //keystone.setApiKeyPrefix("Token");

        InstantApi apiInstance = new InstantApi(defaultClient);
        String projectId = "projectId_example"; // String | Идентификатор проекта (PID) в Openstack
        String query = "query_example"; // String | Выражение запроса на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/)
        String namespace = "default"; // String | Пространство имен сервиса VK Cloud
        String time = "time_example"; // String | Момент времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp. Если параметр не указан, используется текущий момент времени сервера
        String step = "5m"; // String | Диапазон времени перед моментом time, в котором будет проведен поиск значений метрик, если значения не будут найдены для момента time. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations)
        try {
            GetInstantQueryResponse result = apiInstance.instantQuery(projectId, query, namespace, time, step);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InstantApi#instantQuery");
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
| **projectId** | **String**| Идентификатор проекта (PID) в Openstack | |
| **query** | **String**| Выражение запроса на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/) | |
| **namespace** | **String**| Пространство имен сервиса VK Cloud | [optional] [default to default] |
| **time** | **String**| Момент времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp. Если параметр не указан, используется текущий момент времени сервера | [optional] |
| **step** | **String**| Диапазон времени перед моментом time, в котором будет проведен поиск значений метрик, если значения не будут найдены для момента time. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations) | [optional] [default to 5m] |

### Return type

[**GetInstantQueryResponse**](GetInstantQueryResponse.md)

### Authorization

[keystone](../README.md#keystone)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Запрос выполнен успешно |  -  |
| **400** | Отсутствуют или неверно заданы параметры запроса |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Ошибка авторизации |  -  |
| **500** | Внутренняя ошибка сервера |  -  |
| **502** | Неверный шлюз (bad gateway) |  -  |
| **503** | Сервис недоступен |  -  |

