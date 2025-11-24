# RangequeryApi

All URIs are relative to *https://mcs.mail.ru/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**rangeQuery**](RangequeryApi.md#rangeQuery) | **GET** /{project_id}/query_range | Получить метрики в диапазоне времени (Range query) |



## rangeQuery

> GetRangeQueryResponse rangeQuery(projectId, query, start, end, namespace, step, timeout)

Получить метрики в диапазоне времени (Range query)

Выполнить запрос значений метрик в заданном диапазоне времени

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.RangequeryApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mcs.mail.ru/v2");
        
        // Configure API key authorization: keystone
        ApiKeyAuth keystone = (ApiKeyAuth) defaultClient.getAuthentication("keystone");
        keystone.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //keystone.setApiKeyPrefix("Token");

        RangequeryApi apiInstance = new RangequeryApi(defaultClient);
        String projectId = "projectId_example"; // String | Идентификатор проекта (PID) в Openstack
        String query = "query_example"; // String | Выражение запроса на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/)
        String start = "start_example"; // String | Начало диапазона времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp
        String end = "end_example"; // String | Конец диапазона времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp
        String namespace = "default"; // String | Пространство имен сервиса VK Cloud
        String step = "step_example"; // String | Шаг, с которым необходимо получить значения метрик в заданном диапазоне времени. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations)
        String timeout = "timeout_example"; // String | Предельная длительность выполнения запроса. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations)
        try {
            GetRangeQueryResponse result = apiInstance.rangeQuery(projectId, query, start, end, namespace, step, timeout);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RangequeryApi#rangeQuery");
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
| **start** | **String**| Начало диапазона времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp | |
| **end** | **String**| Конец диапазона времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp | |
| **namespace** | **String**| Пространство имен сервиса VK Cloud | [optional] [default to default] |
| **step** | **String**| Шаг, с которым необходимо получить значения метрик в заданном диапазоне времени. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations) | [optional] |
| **timeout** | **String**| Предельная длительность выполнения запроса. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations) | [optional] |

### Return type

[**GetRangeQueryResponse**](GetRangeQueryResponse.md)

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

