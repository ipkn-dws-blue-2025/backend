# VolumeAttachmentsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**serversServerIdOsVolumeAttachmentsAttachmentIdDelete**](VolumeAttachmentsApi.md#serversServerIdOsVolumeAttachmentsAttachmentIdDelete) | **DELETE** /servers/{server_id}/os-volume_attachments/{attachment_id} | Отключить диск от ВМ |
| [**serversServerIdOsVolumeAttachmentsAttachmentIdGet**](VolumeAttachmentsApi.md#serversServerIdOsVolumeAttachmentsAttachmentIdGet) | **GET** /servers/{server_id}/os-volume_attachments/{attachment_id} | Получить информацию о подключении диска к ВМ |
| [**serversServerIdOsVolumeAttachmentsAttachmentIdPut**](VolumeAttachmentsApi.md#serversServerIdOsVolumeAttachmentsAttachmentIdPut) | **PUT** /servers/{server_id}/os-volume_attachments/{attachment_id} | Обновить информацию о подключении диска к ВМ |
| [**serversServerIdOsVolumeAttachmentsGet**](VolumeAttachmentsApi.md#serversServerIdOsVolumeAttachmentsGet) | **GET** /servers/{server_id}/os-volume_attachments | Получить список дисков, подключенных к ВМ |
| [**serversServerIdOsVolumeAttachmentsPost**](VolumeAttachmentsApi.md#serversServerIdOsVolumeAttachmentsPost) | **POST** /servers/{server_id}/os-volume_attachments | Подключить диск к ВМ |



## serversServerIdOsVolumeAttachmentsAttachmentIdDelete

> serversServerIdOsVolumeAttachmentsAttachmentIdDelete(serverId, attachmentId)

Отключить диск от ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.VolumeAttachmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        VolumeAttachmentsApi apiInstance = new VolumeAttachmentsApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        String attachmentId = "attachmentId_example"; // String | Идентификатор подключения диска к ВМ
        try {
            apiInstance.serversServerIdOsVolumeAttachmentsAttachmentIdDelete(serverId, attachmentId);
        } catch (ApiException e) {
            System.err.println("Exception when calling VolumeAttachmentsApi#serversServerIdOsVolumeAttachmentsAttachmentIdDelete");
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
| **attachmentId** | **String**| Идентификатор подключения диска к ВМ | |

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
| **400** | Некорректный запрос |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |
| **404** | Объект не найден |  -  |
| **409** | Конфликт |  -  |


## serversServerIdOsVolumeAttachmentsAttachmentIdGet

> ServersServerIdOsVolumeAttachmentsPost200Response serversServerIdOsVolumeAttachmentsAttachmentIdGet(serverId, attachmentId)

Получить информацию о подключении диска к ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.VolumeAttachmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        VolumeAttachmentsApi apiInstance = new VolumeAttachmentsApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        String attachmentId = "attachmentId_example"; // String | Идентификатор подключения диска к ВМ
        try {
            ServersServerIdOsVolumeAttachmentsPost200Response result = apiInstance.serversServerIdOsVolumeAttachmentsAttachmentIdGet(serverId, attachmentId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling VolumeAttachmentsApi#serversServerIdOsVolumeAttachmentsAttachmentIdGet");
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
| **attachmentId** | **String**| Идентификатор подключения диска к ВМ | |

### Return type

[**ServersServerIdOsVolumeAttachmentsPost200Response**](ServersServerIdOsVolumeAttachmentsPost200Response.md)

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


## serversServerIdOsVolumeAttachmentsAttachmentIdPut

> serversServerIdOsVolumeAttachmentsAttachmentIdPut(serverId, attachmentId, serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest)

Обновить информацию о подключении диска к ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.VolumeAttachmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        VolumeAttachmentsApi apiInstance = new VolumeAttachmentsApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        String attachmentId = "attachmentId_example"; // String | Идентификатор подключения диска к ВМ
        ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest = new ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest(); // ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest | 
        try {
            apiInstance.serversServerIdOsVolumeAttachmentsAttachmentIdPut(serverId, attachmentId, serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling VolumeAttachmentsApi#serversServerIdOsVolumeAttachmentsAttachmentIdPut");
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
| **attachmentId** | **String**| Идентификатор подключения диска к ВМ | |
| **serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest** | [**ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest**](ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | ОК |  -  |
| **400** | Некорректный запрос |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |
| **404** | Объект не найден |  -  |
| **409** | Конфликт |  -  |


## serversServerIdOsVolumeAttachmentsGet

> ServersServerIdOsVolumeAttachmentsGet200Response serversServerIdOsVolumeAttachmentsGet(serverId)

Получить список дисков, подключенных к ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.VolumeAttachmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        VolumeAttachmentsApi apiInstance = new VolumeAttachmentsApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        try {
            ServersServerIdOsVolumeAttachmentsGet200Response result = apiInstance.serversServerIdOsVolumeAttachmentsGet(serverId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling VolumeAttachmentsApi#serversServerIdOsVolumeAttachmentsGet");
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

[**ServersServerIdOsVolumeAttachmentsGet200Response**](ServersServerIdOsVolumeAttachmentsGet200Response.md)

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


## serversServerIdOsVolumeAttachmentsPost

> ServersServerIdOsVolumeAttachmentsPost200Response serversServerIdOsVolumeAttachmentsPost(serverId, serversServerIdOsVolumeAttachmentsPostRequest)

Подключить диск к ВМ

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.VolumeAttachmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        VolumeAttachmentsApi apiInstance = new VolumeAttachmentsApi(defaultClient);
        String serverId = "serverId_example"; // String | Идентификатор ВМ
        ServersServerIdOsVolumeAttachmentsPostRequest serversServerIdOsVolumeAttachmentsPostRequest = new ServersServerIdOsVolumeAttachmentsPostRequest(); // ServersServerIdOsVolumeAttachmentsPostRequest | 
        try {
            ServersServerIdOsVolumeAttachmentsPost200Response result = apiInstance.serversServerIdOsVolumeAttachmentsPost(serverId, serversServerIdOsVolumeAttachmentsPostRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling VolumeAttachmentsApi#serversServerIdOsVolumeAttachmentsPost");
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
| **serversServerIdOsVolumeAttachmentsPostRequest** | [**ServersServerIdOsVolumeAttachmentsPostRequest**](ServersServerIdOsVolumeAttachmentsPostRequest.md)|  | |

### Return type

[**ServersServerIdOsVolumeAttachmentsPost200Response**](ServersServerIdOsVolumeAttachmentsPost200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ОК |  -  |
| **401** | Ошибка аутентификации |  -  |
| **403** | Недостаточно прав |  -  |
| **404** | Объект не найден |  -  |
| **409** | Конфликт |  -  |

