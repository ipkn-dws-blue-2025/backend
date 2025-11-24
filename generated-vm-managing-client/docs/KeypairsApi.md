# KeypairsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**osKeypairsGet**](KeypairsApi.md#osKeypairsGet) | **GET** /os-keypairs | Получить список ключевых пар |
| [**osKeypairsKeypairNameDelete**](KeypairsApi.md#osKeypairsKeypairNameDelete) | **DELETE** /os-keypairs/{keypair_name} | Удалить ключевую пару |
| [**osKeypairsKeypairNameGet**](KeypairsApi.md#osKeypairsKeypairNameGet) | **GET** /os-keypairs/{keypair_name} | Получить информацию о ключевой паре |
| [**osKeypairsPost**](KeypairsApi.md#osKeypairsPost) | **POST** /os-keypairs | Создать или импортировать ключевую пару |



## osKeypairsGet

> OsKeypairsGet200Response osKeypairsGet(limit, marker)

Получить список ключевых пар

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KeypairsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        KeypairsApi apiInstance = new KeypairsApi(defaultClient);
        Integer limit = 56; // Integer | Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре ``marker`` идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
        String marker = "marker_example"; // String | Маркер пагинации для больших наборов данных
        try {
            OsKeypairsGet200Response result = apiInstance.osKeypairsGet(limit, marker);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeypairsApi#osKeypairsGet");
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
| **limit** | **Integer**| Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов | [optional] |
| **marker** | **String**| Маркер пагинации для больших наборов данных | [optional] |

### Return type

[**OsKeypairsGet200Response**](OsKeypairsGet200Response.md)

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


## osKeypairsKeypairNameDelete

> osKeypairsKeypairNameDelete(keypairName)

Удалить ключевую пару

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KeypairsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        KeypairsApi apiInstance = new KeypairsApi(defaultClient);
        String keypairName = "keypairName_example"; // String | Имя ключевой пары
        try {
            apiInstance.osKeypairsKeypairNameDelete(keypairName);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeypairsApi#osKeypairsKeypairNameDelete");
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
| **keypairName** | **String**| Имя ключевой пары | |

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
| **202** | ОК |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |
| **404** | Объект не найден |  -  |


## osKeypairsKeypairNameGet

> OsKeypairsKeypairNameGet200Response osKeypairsKeypairNameGet(keypairName)

Получить информацию о ключевой паре

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KeypairsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        KeypairsApi apiInstance = new KeypairsApi(defaultClient);
        String keypairName = "keypairName_example"; // String | Имя ключевой пары
        try {
            OsKeypairsKeypairNameGet200Response result = apiInstance.osKeypairsKeypairNameGet(keypairName);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeypairsApi#osKeypairsKeypairNameGet");
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
| **keypairName** | **String**| Имя ключевой пары | |

### Return type

[**OsKeypairsKeypairNameGet200Response**](OsKeypairsKeypairNameGet200Response.md)

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


## osKeypairsPost

> OsKeypairsPost200Response osKeypairsPost(osKeypairsPostRequest)

Создать или импортировать ключевую пару

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.KeypairsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        KeypairsApi apiInstance = new KeypairsApi(defaultClient);
        OsKeypairsPostRequest osKeypairsPostRequest = new OsKeypairsPostRequest(); // OsKeypairsPostRequest | Объект данных новой ключевой пары в формате JSON
        try {
            OsKeypairsPost200Response result = apiInstance.osKeypairsPost(osKeypairsPostRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeypairsApi#osKeypairsPost");
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
| **osKeypairsPostRequest** | [**OsKeypairsPostRequest**](OsKeypairsPostRequest.md)| Объект данных новой ключевой пары в формате JSON | [optional] |

### Return type

[**OsKeypairsPost200Response**](OsKeypairsPost200Response.md)

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
| **409** | Конфликт |  -  |

