# NamespacesApi

All URIs are relative to *https://mcs.mail.ru/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**allowedNamespaces**](NamespacesApi.md#allowedNamespaces) | **GET** /namespaces | Получить список разрешенных пространств имен |



## allowedNamespaces

> List&lt;String&gt; allowedNamespaces()

Получить список разрешенных пространств имен

Получить список [пространств имен](https://cloud.vk.com/docs/ru/monitoring-services/monitoring/concepts/architecture/#namespaces) (namespaces), которые можно использовать в запросах

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.NamespacesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://mcs.mail.ru/v2");
        
        // Configure API key authorization: keystone
        ApiKeyAuth keystone = (ApiKeyAuth) defaultClient.getAuthentication("keystone");
        keystone.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //keystone.setApiKeyPrefix("Token");

        NamespacesApi apiInstance = new NamespacesApi(defaultClient);
        try {
            List<String> result = apiInstance.allowedNamespaces();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling NamespacesApi#allowedNamespaces");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

[keystone](../README.md#keystone)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Список разрешенных пространств имен |  -  |
| **401** | Ошибка аутентификации |  -  |
| **500** | Внутренняя ошибка сервера |  -  |

