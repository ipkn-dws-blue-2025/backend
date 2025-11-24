# LabelsApi

All URIs are relative to *https://mcs.mail.ru/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**labels**](LabelsApi.md#labels) | **GET** /{project_id}/labels | Получить список имен меток |



## labels

> GetLabelsResponse labels(projectId, namespace, match, start, end)

Получить список имен меток

Получить список имен меток. В качестве параметров могут быть указаны селекторы метрик и/или диапазон времени, из которых нужно читать имена меток

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LabelsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mcs.mail.ru/v2");
        
        // Configure API key authorization: keystone
        ApiKeyAuth keystone = (ApiKeyAuth) defaultClient.getAuthentication("keystone");
        keystone.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //keystone.setApiKeyPrefix("Token");

        LabelsApi apiInstance = new LabelsApi(defaultClient);
        String projectId = "projectId_example"; // String | Идентификатор проекта (PID) в Openstack
        String namespace = "default"; // String | Пространство имен сервиса VK Cloud
        List<String> match = Arrays.asList(); // List<String> | Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). Позволяет выбрать метрики, из которых будут считаны имена меток
        String start = "start_example"; // String | Начало диапазона времени, в котором нужно читать имена меток. Формат — RFC3339 или Unix timestamp
        String end = "end_example"; // String | Конец диапазона времени, в котором нужно читать имена меток. Формат — RFC3339 или Unix timestamp
        try {
            GetLabelsResponse result = apiInstance.labels(projectId, namespace, match, start, end);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LabelsApi#labels");
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
| **namespace** | **String**| Пространство имен сервиса VK Cloud | [optional] [default to default] |
| **match** | [**List&lt;String&gt;**](String.md)| Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). Позволяет выбрать метрики, из которых будут считаны имена меток | [optional] |
| **start** | **String**| Начало диапазона времени, в котором нужно читать имена меток. Формат — RFC3339 или Unix timestamp | [optional] |
| **end** | **String**| Конец диапазона времени, в котором нужно читать имена меток. Формат — RFC3339 или Unix timestamp | [optional] |

### Return type

[**GetLabelsResponse**](GetLabelsResponse.md)

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

