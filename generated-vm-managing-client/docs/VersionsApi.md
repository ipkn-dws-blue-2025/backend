# VersionsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiConfirmV21V21Get**](VersionsApi.md#apiConfirmV21V21Get) | **GET** /v2.1 | Подтвердить наличие версии 2.1 |
| [**rootGet**](VersionsApi.md#rootGet) | **GET** / | Получить перечень поддерживаемых версий API |



## apiConfirmV21V21Get

> apiConfirmV21V21Get()

Подтвердить наличие версии 2.1

Метод позволяет подтвердить наличие версии 2.1.  Возвращает код &#x60;&#x60;304 FOUND&#x60;&#x60; и пустое тело ответа

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.VersionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        VersionsApi apiInstance = new VersionsApi(defaultClient);
        try {
            apiInstance.apiConfirmV21V21Get();
        } catch (ApiException e) {
            System.err.println("Exception when calling VersionsApi#apiConfirmV21V21Get");
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **304** | ОК |  -  |


## rootGet

> Versions rootGet()

Получить перечень поддерживаемых версий API

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.VersionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        VersionsApi apiInstance = new VersionsApi(defaultClient);
        try {
            Versions result = apiInstance.rootGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling VersionsApi#rootGet");
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

[**Versions**](Versions.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ОК |  -  |

