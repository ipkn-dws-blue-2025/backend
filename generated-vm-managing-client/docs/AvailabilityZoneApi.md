# AvailabilityZoneApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**osAvailabilityZoneGet**](AvailabilityZoneApi.md#osAvailabilityZoneGet) | **GET** /os-availability-zone | Получить информацию о зонах доступности |



## osAvailabilityZoneGet

> OsAvailabilityZoneGet200Response osAvailabilityZoneGet()

Получить информацию о зонах доступности

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AvailabilityZoneApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        AvailabilityZoneApi apiInstance = new AvailabilityZoneApi(defaultClient);
        try {
            OsAvailabilityZoneGet200Response result = apiInstance.osAvailabilityZoneGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AvailabilityZoneApi#osAvailabilityZoneGet");
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

[**OsAvailabilityZoneGet200Response**](OsAvailabilityZoneGet200Response.md)

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

