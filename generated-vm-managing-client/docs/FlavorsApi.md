# FlavorsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**flavorsDetailGet**](FlavorsApi.md#flavorsDetailGet) | **GET** /flavors/detail | Получить список шаблонов конфигураций ВМ с подробной информацией |
| [**flavorsFlavorIdGet**](FlavorsApi.md#flavorsFlavorIdGet) | **GET** /flavors/{flavor_id} | Получить информацию о шаблоне конфигурации ВМ |
| [**flavorsFlavorIdOsExtraSpecsExtraSpecKeyGet**](FlavorsApi.md#flavorsFlavorIdOsExtraSpecsExtraSpecKeyGet) | **GET** /flavors/{flavor_id}/os-extra_specs/{extra_spec_key} | Получить значение дополнительного параметра шаблона конфигурации ВМ |
| [**flavorsFlavorIdOsExtraSpecsGet**](FlavorsApi.md#flavorsFlavorIdOsExtraSpecsGet) | **GET** /flavors/{flavor_id}/os-extra_specs | Вернуть все дополнительные параметры шаблона конфигурации ВМ |
| [**flavorsGet**](FlavorsApi.md#flavorsGet) | **GET** /flavors | Получить список шаблонов конфигураций ВМ |



## flavorsDetailGet

> List&lt;FlavorDetails&gt; flavorsDetailGet(sortKey, sortDir, limit, marker, minDisk, minRam)

Получить список шаблонов конфигураций ВМ с подробной информацией

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FlavorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        FlavorsApi apiInstance = new FlavorsApi(defaultClient);
        String sortKey = "flavorid"; // String | Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
        String sortDir = "asc"; // String | Направление сортировки. Возможные значения:  ``asc`` — по возрастанию;  ``desc`` — по убыванию
        Integer limit = 56; // Integer | Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре ``marker`` идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
        String marker = "marker_example"; // String | Маркер пагинации для больших наборов данных
        Integer minDisk = 100; // Integer | Фильтр по минимальному размеру диска в гигибайтах
        Integer minRam = 512; // Integer | Фильтр по минимальному количеству RAM в мебибайтах
        try {
            List<FlavorDetails> result = apiInstance.flavorsDetailGet(sortKey, sortDir, limit, marker, minDisk, minRam);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlavorsApi#flavorsDetailGet");
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
| **sortKey** | **String**| Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе | [optional] [default to flavorid] |
| **sortDir** | **String**| Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию | [optional] [default to asc] |
| **limit** | **Integer**| Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов | [optional] |
| **marker** | **String**| Маркер пагинации для больших наборов данных | [optional] |
| **minDisk** | **Integer**| Фильтр по минимальному размеру диска в гигибайтах | [optional] |
| **minRam** | **Integer**| Фильтр по минимальному количеству RAM в мебибайтах | [optional] |

### Return type

[**List&lt;FlavorDetails&gt;**](FlavorDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ОК |  -  |
| **400** | Некорректный запрос |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |


## flavorsFlavorIdGet

> FlavorDetails flavorsFlavorIdGet(flavorId)

Получить информацию о шаблоне конфигурации ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FlavorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        FlavorsApi apiInstance = new FlavorsApi(defaultClient);
        String flavorId = "flavorId_example"; // String | Идентификатор шаблона конфигурации ВМ
        try {
            FlavorDetails result = apiInstance.flavorsFlavorIdGet(flavorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlavorsApi#flavorsFlavorIdGet");
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
| **flavorId** | **String**| Идентификатор шаблона конфигурации ВМ | |

### Return type

[**FlavorDetails**](FlavorDetails.md)

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


## flavorsFlavorIdOsExtraSpecsExtraSpecKeyGet

> Object flavorsFlavorIdOsExtraSpecsExtraSpecKeyGet(flavorId, extraSpecKey)

Получить значение дополнительного параметра шаблона конфигурации ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FlavorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        FlavorsApi apiInstance = new FlavorsApi(defaultClient);
        UUID flavorId = UUID.randomUUID(); // UUID | 
        String extraSpecKey = "extraSpecKey_example"; // String | 
        try {
            Object result = apiInstance.flavorsFlavorIdOsExtraSpecsExtraSpecKeyGet(flavorId, extraSpecKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlavorsApi#flavorsFlavorIdOsExtraSpecsExtraSpecKeyGet");
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
| **flavorId** | **UUID**|  | |
| **extraSpecKey** | **String**|  | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **404** | Объект не найден |  -  |


## flavorsFlavorIdOsExtraSpecsGet

> Object flavorsFlavorIdOsExtraSpecsGet(flavorId)

Вернуть все дополнительные параметры шаблона конфигурации ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FlavorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        FlavorsApi apiInstance = new FlavorsApi(defaultClient);
        UUID flavorId = UUID.randomUUID(); // UUID | UUID шаблона конфигурации ВМ
        try {
            Object result = apiInstance.flavorsFlavorIdOsExtraSpecsGet(flavorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlavorsApi#flavorsFlavorIdOsExtraSpecsGet");
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
| **flavorId** | **UUID**| UUID шаблона конфигурации ВМ | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **404** | Объект не найден |  -  |


## flavorsGet

> GetListFlavors flavorsGet(sortKey, sortDir, limit, marker, minDisk, minRam)

Получить список шаблонов конфигураций ВМ

Метод возвращает список шаблонов конфигураций ВМ по заданным фильтрам

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FlavorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        FlavorsApi apiInstance = new FlavorsApi(defaultClient);
        String sortKey = "flavorid"; // String | Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
        String sortDir = "asc"; // String | Направление сортировки. Возможные значения:  ``asc`` — по возрастанию;  ``desc`` — по убыванию
        Integer limit = 56; // Integer | Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре ``marker`` идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
        String marker = "marker_example"; // String | Маркер пагинации для больших наборов данных
        Integer minDisk = 100; // Integer | Фильтр по минимальному размеру диска в гигибайтах
        Integer minRam = 512; // Integer | Фильтр по минимальному количеству RAM в мебибайтах
        try {
            GetListFlavors result = apiInstance.flavorsGet(sortKey, sortDir, limit, marker, minDisk, minRam);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlavorsApi#flavorsGet");
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
| **sortKey** | **String**| Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе | [optional] [default to flavorid] |
| **sortDir** | **String**| Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию | [optional] [default to asc] |
| **limit** | **Integer**| Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов | [optional] |
| **marker** | **String**| Маркер пагинации для больших наборов данных | [optional] |
| **minDisk** | **Integer**| Фильтр по минимальному размеру диска в гигибайтах | [optional] |
| **minRam** | **Integer**| Фильтр по минимальному количеству RAM в мебибайтах | [optional] |

### Return type

[**GetListFlavors**](GetListFlavors.md)

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

