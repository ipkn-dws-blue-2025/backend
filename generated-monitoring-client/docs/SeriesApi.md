# SeriesApi

All URIs are relative to *https://mcs.mail.ru/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**seriesQuery**](SeriesApi.md#seriesQuery) | **GET** /{project_id}/series | Получить список метрик по заданному фильтру (Series query) |



## seriesQuery

> GetSeriesQueryResponse seriesQuery(projectId, match, namespace, start, end)

Получить список метрик по заданному фильтру (Series query)

Выполнить запрос списка метрик, которые [соответствуют заданному фильтру](https://prometheus.io/docs/prometheus/latest/querying/api/#finding-series-by-label-matchers). Фильтр задается набором меток в виде пар имя/значение

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SeriesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mcs.mail.ru/v2");
        
        // Configure API key authorization: keystone
        ApiKeyAuth keystone = (ApiKeyAuth) defaultClient.getAuthentication("keystone");
        keystone.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //keystone.setApiKeyPrefix("Token");

        SeriesApi apiInstance = new SeriesApi(defaultClient);
        String projectId = "projectId_example"; // String | Идентификатор проекта (PID) в Openstack
        List<String> match = Arrays.asList(); // List<String> | Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). В выражении должна быть задана хотя бы одна метка для поиска подходящих метрик
        String namespace = "default"; // String | Пространство имен сервиса VK Cloud
        String start = "start_example"; // String | Начало диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
        String end = "end_example"; // String | Конец диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
        try {
            GetSeriesQueryResponse result = apiInstance.seriesQuery(projectId, match, namespace, start, end);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SeriesApi#seriesQuery");
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
| **match** | [**List&lt;String&gt;**](String.md)| Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). В выражении должна быть задана хотя бы одна метка для поиска подходящих метрик | |
| **namespace** | **String**| Пространство имен сервиса VK Cloud | [optional] [default to default] |
| **start** | **String**| Начало диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp | [optional] |
| **end** | **String**| Конец диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp | [optional] |

### Return type

[**GetSeriesQueryResponse**](GetSeriesQueryResponse.md)

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

