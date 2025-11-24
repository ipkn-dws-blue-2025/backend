# ServersApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**serversDetailGet**](ServersApi.md#serversDetailGet) | **GET** /servers/detail | Получить список ВМ с подробной информацией |
| [**serversGet**](ServersApi.md#serversGet) | **GET** /servers | Получить список ВМ |
| [**serversPost**](ServersApi.md#serversPost) | **POST** /servers | Создать новую ВМ |
| [**serversServerIdDelete**](ServersApi.md#serversServerIdDelete) | **DELETE** /servers/{server_id} | Удалить ВМ |
| [**serversServerIdGet**](ServersApi.md#serversServerIdGet) | **GET** /servers/{server_id} | Получить информацию о ВМ |
| [**serversServerIdPut**](ServersApi.md#serversServerIdPut) | **PUT** /servers/{server_id} | Обновить информацию о ВМ |



## serversDetailGet

> GetListServerDetails serversDetailGet(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore)

Получить список ВМ с подробной информацией

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServersApi apiInstance = new ServersApi(defaultClient);
        Integer limit = 56; // Integer | Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре ``marker`` идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
        String marker = "marker_example"; // String | Маркер пагинации для больших наборов данных
        String sortKey = "created_at"; // String | Атрибут, по которому сортируются ВМ в ответе
        String sortDir = "desc"; // String | Направление сортировки. Возможные значения:  ``asc`` — по возрастанию;  ``desc`` — по убыванию
        String changesSince = "2015-08-27T09:49:58-05:00"; // String | Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: ``CCYY-MM-DDThh:mm:ss±hh:mm``. Значение ``±hh:mm`` указывает на часовой пояс (смещение от UTC)
        String image = "image_example"; // String | Фильтр по идентификатору образа
        String flavor = "flavor_example"; // String | Фильтр по идентификатору шаблона конфигурации ВМ
        String name = "name_example"; // String | Фильтр по имени ВМ
        String status = "ACTIVE"; // String | Фильтр по статусу ВМ
        String ip = "ip_example"; // String | Фильтр по IP-адресу версии 4
        String reservationId = "reservationId_example"; // String | Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
        String ip6 = "ip6_example"; // String | Фильтр по IP-адресу версии 6
        String tags = "tags_example"; // String | Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
        String tagsAny = "tagsAny_example"; // String | Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
        String notTags = "notTags_example"; // String | Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
        String notTagsAny = "notTagsAny_example"; // String | Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
        String changesBefore = "2015-08-27T09:49:58-05:00"; // String | Фильтр по дате и времени последнего изменения ВМ. Формат: ``CCYY-MM-DDThh:mm:ss±hh:mm``. Значение ``±hh:mm`` указывает на часовой пояс (смещение от UTC)
        try {
            GetListServerDetails result = apiInstance.serversDetailGet(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServersApi#serversDetailGet");
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
| **sortKey** | **String**| Атрибут, по которому сортируются ВМ в ответе | [optional] [default to created_at] |
| **sortDir** | **String**| Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию | [optional] [default to desc] |
| **changesSince** | **String**| Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC) | [optional] |
| **image** | **String**| Фильтр по идентификатору образа | [optional] |
| **flavor** | **String**| Фильтр по идентификатору шаблона конфигурации ВМ | [optional] |
| **name** | **String**| Фильтр по имени ВМ | [optional] |
| **status** | **String**| Фильтр по статусу ВМ | [optional] [enum: ACTIVE, BUILDING, DELETED, ERROR, HARD_REBOOT, MIGRATING, PASSWORD, PAUSED, REBOOT, REBUILD, RESCUED, RESIZED, REVERT_RESIZE, SOFT_DELETED, STOPPED, SHUTOFF, SUSPENDED, UNKNOWN, VERIFY_RESIZE] |
| **ip** | **String**| Фильтр по IP-адресу версии 4 | [optional] |
| **reservationId** | **String**| Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ | [optional] |
| **ip6** | **String**| Фильтр по IP-адресу версии 6 | [optional] |
| **tags** | **String**| Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой | [optional] |
| **tagsAny** | **String**| Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой | [optional] |
| **notTags** | **String**| Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой | [optional] |
| **notTagsAny** | **String**| Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой  | [optional] |
| **changesBefore** | **String**| Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC) | [optional] |

### Return type

[**GetListServerDetails**](GetListServerDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ОК |  -  |


## serversGet

> GetServers serversGet(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore)

Получить список ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServersApi apiInstance = new ServersApi(defaultClient);
        Integer limit = 56; // Integer | Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре ``marker`` идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
        String marker = "marker_example"; // String | Маркер пагинации для больших наборов данных
        String sortKey = "created_at"; // String | Атрибут, по которому сортируются ВМ в ответе
        String sortDir = "desc"; // String | Направление сортировки. Возможные значения:  ``asc`` — по возрастанию;  ``desc`` — по убыванию
        String changesSince = "2015-08-27T09:49:58-05:00"; // String | Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: ``CCYY-MM-DDThh:mm:ss±hh:mm``. Значение ``±hh:mm`` указывает на часовой пояс (смещение от UTC)
        String image = "image_example"; // String | Фильтр по идентификатору образа
        String flavor = "flavor_example"; // String | Фильтр по идентификатору шаблона конфигурации ВМ
        String name = "name_example"; // String | Фильтр по имени ВМ
        String status = "ACTIVE"; // String | Фильтр по статусу ВМ
        String ip = "ip_example"; // String | Фильтр по IP-адресу версии 4
        String reservationId = "reservationId_example"; // String | Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
        String ip6 = "ip6_example"; // String | Фильтр по IP-адресу версии 6
        String tags = "tags_example"; // String | Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
        String tagsAny = "tagsAny_example"; // String | Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
        String notTags = "notTags_example"; // String | Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
        String notTagsAny = "notTagsAny_example"; // String | Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
        String changesBefore = "2015-08-27T09:49:58-05:00"; // String | Фильтр по дате и времени последнего изменения ВМ. Формат: ``CCYY-MM-DDThh:mm:ss±hh:mm``. Значение ``±hh:mm`` указывает на часовой пояс (смещение от UTC)
        try {
            GetServers result = apiInstance.serversGet(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServersApi#serversGet");
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
| **sortKey** | **String**| Атрибут, по которому сортируются ВМ в ответе | [optional] [default to created_at] |
| **sortDir** | **String**| Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию | [optional] [default to desc] |
| **changesSince** | **String**| Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC) | [optional] |
| **image** | **String**| Фильтр по идентификатору образа | [optional] |
| **flavor** | **String**| Фильтр по идентификатору шаблона конфигурации ВМ | [optional] |
| **name** | **String**| Фильтр по имени ВМ | [optional] |
| **status** | **String**| Фильтр по статусу ВМ | [optional] [enum: ACTIVE, BUILDING, DELETED, ERROR, HARD_REBOOT, MIGRATING, PASSWORD, PAUSED, REBOOT, REBUILD, RESCUED, RESIZED, REVERT_RESIZE, SOFT_DELETED, STOPPED, SHUTOFF, SUSPENDED, UNKNOWN, VERIFY_RESIZE] |
| **ip** | **String**| Фильтр по IP-адресу версии 4 | [optional] |
| **reservationId** | **String**| Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ | [optional] |
| **ip6** | **String**| Фильтр по IP-адресу версии 6 | [optional] |
| **tags** | **String**| Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой | [optional] |
| **tagsAny** | **String**| Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой | [optional] |
| **notTags** | **String**| Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой | [optional] |
| **notTagsAny** | **String**| Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой  | [optional] |
| **changesBefore** | **String**| Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC) | [optional] |

### Return type

[**GetServers**](GetServers.md)

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


## serversPost

> GetServerDetails serversPost(serversPostRequest)

Создать новую ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServersApi apiInstance = new ServersApi(defaultClient);
        ServersPostRequest serversPostRequest = new ServersPostRequest(); // ServersPostRequest | Объект данных новой ВМ в формате JSON
        try {
            GetServerDetails result = apiInstance.serversPost(serversPostRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServersApi#serversPost");
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
| **serversPostRequest** | [**ServersPostRequest**](ServersPostRequest.md)| Объект данных новой ВМ в формате JSON | [optional] |

### Return type

[**GetServerDetails**](GetServerDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | ОК |  -  |
| **400** | Некорректный запрос |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |
| **404** | Объект не найден |  -  |
| **409** | Конфликт |  -  |
| **413** | Превышен размер запроса |  -  |


## serversServerIdDelete

> serversServerIdDelete(serverId)

Удалить ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServersApi apiInstance = new ServersApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        try {
            apiInstance.serversServerIdDelete(serverId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServersApi#serversServerIdDelete");
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
| **serverId** | **String**| Идентификатор ВМ | |

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
| **409** | Конфликт |  -  |


## serversServerIdGet

> GetServerDetails serversServerIdGet(serverId)

Получить информацию о ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServersApi apiInstance = new ServersApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        try {
            GetServerDetails result = apiInstance.serversServerIdGet(serverId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServersApi#serversServerIdGet");
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
| **serverId** | **String**| Идентификатор ВМ | |

### Return type

[**GetServerDetails**](GetServerDetails.md)

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


## serversServerIdPut

> GetServerDetails serversServerIdPut(serverId, serverUpdate)

Обновить информацию о ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        ServersApi apiInstance = new ServersApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        ServerUpdate serverUpdate = new ServerUpdate(); // ServerUpdate | 
        try {
            GetServerDetails result = apiInstance.serversServerIdPut(serverId, serverUpdate);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ServersApi#serversServerIdPut");
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
| **serverId** | **String**| Идентификатор ВМ | |
| **serverUpdate** | [**ServerUpdate**](ServerUpdate.md)|  | |

### Return type

[**GetServerDetails**](GetServerDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ОК |  -  |
| **400** | ОК |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |
| **404** | Объект не найден |  -  |

