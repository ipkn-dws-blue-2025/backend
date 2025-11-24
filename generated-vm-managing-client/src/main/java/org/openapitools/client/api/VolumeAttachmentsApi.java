package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest;
import org.openapitools.client.model.ServersServerIdOsVolumeAttachmentsGet200Response;
import org.openapitools.client.model.ServersServerIdOsVolumeAttachmentsPost200Response;
import org.openapitools.client.model.ServersServerIdOsVolumeAttachmentsPostRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-11-24T15:32:07.370943+03:00[Europe/Moscow]", comments = "Generator version: 7.4.0")
public class VolumeAttachmentsApi {
    private ApiClient apiClient;

    public VolumeAttachmentsApi() {
        this(new ApiClient());
    }

    @Autowired
    public VolumeAttachmentsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Отключить диск от ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdOsVolumeAttachmentsAttachmentIdDeleteRequestCreation(String serverId, String attachmentId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdOsVolumeAttachmentsAttachmentIdDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'attachmentId' when calling serversServerIdOsVolumeAttachmentsAttachmentIdDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("server_id", serverId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/servers/{server_id}/os-volume_attachments/{attachment_id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Отключить диск от ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> serversServerIdOsVolumeAttachmentsAttachmentIdDelete(String serverId, String attachmentId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return serversServerIdOsVolumeAttachmentsAttachmentIdDeleteRequestCreation(serverId, attachmentId).bodyToMono(localVarReturnType);
    }

    /**
     * Отключить диск от ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> serversServerIdOsVolumeAttachmentsAttachmentIdDeleteWithHttpInfo(String serverId, String attachmentId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return serversServerIdOsVolumeAttachmentsAttachmentIdDeleteRequestCreation(serverId, attachmentId).toEntity(localVarReturnType);
    }

    /**
     * Отключить диск от ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdOsVolumeAttachmentsAttachmentIdDeleteWithResponseSpec(String serverId, String attachmentId) throws WebClientResponseException {
        return serversServerIdOsVolumeAttachmentsAttachmentIdDeleteRequestCreation(serverId, attachmentId);
    }
    /**
     * Получить информацию о подключении диска к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @return ServersServerIdOsVolumeAttachmentsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdOsVolumeAttachmentsAttachmentIdGetRequestCreation(String serverId, String attachmentId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdOsVolumeAttachmentsAttachmentIdGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'attachmentId' when calling serversServerIdOsVolumeAttachmentsAttachmentIdGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("server_id", serverId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response>() {};
        return apiClient.invokeAPI("/servers/{server_id}/os-volume_attachments/{attachment_id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить информацию о подключении диска к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @return ServersServerIdOsVolumeAttachmentsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ServersServerIdOsVolumeAttachmentsPost200Response> serversServerIdOsVolumeAttachmentsAttachmentIdGet(String serverId, String attachmentId) throws WebClientResponseException {
        ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response>() {};
        return serversServerIdOsVolumeAttachmentsAttachmentIdGetRequestCreation(serverId, attachmentId).bodyToMono(localVarReturnType);
    }

    /**
     * Получить информацию о подключении диска к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @return ResponseEntity&lt;ServersServerIdOsVolumeAttachmentsPost200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ServersServerIdOsVolumeAttachmentsPost200Response>> serversServerIdOsVolumeAttachmentsAttachmentIdGetWithHttpInfo(String serverId, String attachmentId) throws WebClientResponseException {
        ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response>() {};
        return serversServerIdOsVolumeAttachmentsAttachmentIdGetRequestCreation(serverId, attachmentId).toEntity(localVarReturnType);
    }

    /**
     * Получить информацию о подключении диска к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdOsVolumeAttachmentsAttachmentIdGetWithResponseSpec(String serverId, String attachmentId) throws WebClientResponseException {
        return serversServerIdOsVolumeAttachmentsAttachmentIdGetRequestCreation(serverId, attachmentId);
    }
    /**
     * Обновить информацию о подключении диска к ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @param serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest The serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdOsVolumeAttachmentsAttachmentIdPutRequestCreation(String serverId, String attachmentId, ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest) throws WebClientResponseException {
        Object postBody = serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdOsVolumeAttachmentsAttachmentIdPut", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'attachmentId' when calling serversServerIdOsVolumeAttachmentsAttachmentIdPut", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest' is set
        if (serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest' when calling serversServerIdOsVolumeAttachmentsAttachmentIdPut", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("server_id", serverId);
        pathParams.put("attachment_id", attachmentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/servers/{server_id}/os-volume_attachments/{attachment_id}", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Обновить информацию о подключении диска к ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @param serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest The serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> serversServerIdOsVolumeAttachmentsAttachmentIdPut(String serverId, String attachmentId, ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return serversServerIdOsVolumeAttachmentsAttachmentIdPutRequestCreation(serverId, attachmentId, serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Обновить информацию о подключении диска к ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @param serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest The serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> serversServerIdOsVolumeAttachmentsAttachmentIdPutWithHttpInfo(String serverId, String attachmentId, ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return serversServerIdOsVolumeAttachmentsAttachmentIdPutRequestCreation(serverId, attachmentId, serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest).toEntity(localVarReturnType);
    }

    /**
     * Обновить информацию о подключении диска к ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param attachmentId Идентификатор подключения диска к ВМ
     * @param serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest The serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdOsVolumeAttachmentsAttachmentIdPutWithResponseSpec(String serverId, String attachmentId, ServersServerIdOsVolumeAttachmentsAttachmentIdPutRequest serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest) throws WebClientResponseException {
        return serversServerIdOsVolumeAttachmentsAttachmentIdPutRequestCreation(serverId, attachmentId, serversServerIdOsVolumeAttachmentsAttachmentIdPutRequest);
    }
    /**
     * Получить список дисков, подключенных к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ServersServerIdOsVolumeAttachmentsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdOsVolumeAttachmentsGetRequestCreation(String serverId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdOsVolumeAttachmentsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("server_id", serverId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsGet200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsGet200Response>() {};
        return apiClient.invokeAPI("/servers/{server_id}/os-volume_attachments", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список дисков, подключенных к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ServersServerIdOsVolumeAttachmentsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ServersServerIdOsVolumeAttachmentsGet200Response> serversServerIdOsVolumeAttachmentsGet(String serverId) throws WebClientResponseException {
        ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsGet200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsGet200Response>() {};
        return serversServerIdOsVolumeAttachmentsGetRequestCreation(serverId).bodyToMono(localVarReturnType);
    }

    /**
     * Получить список дисков, подключенных к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ResponseEntity&lt;ServersServerIdOsVolumeAttachmentsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ServersServerIdOsVolumeAttachmentsGet200Response>> serversServerIdOsVolumeAttachmentsGetWithHttpInfo(String serverId) throws WebClientResponseException {
        ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsGet200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsGet200Response>() {};
        return serversServerIdOsVolumeAttachmentsGetRequestCreation(serverId).toEntity(localVarReturnType);
    }

    /**
     * Получить список дисков, подключенных к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdOsVolumeAttachmentsGetWithResponseSpec(String serverId) throws WebClientResponseException {
        return serversServerIdOsVolumeAttachmentsGetRequestCreation(serverId);
    }
    /**
     * Подключить диск к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param serversServerIdOsVolumeAttachmentsPostRequest The serversServerIdOsVolumeAttachmentsPostRequest parameter
     * @return ServersServerIdOsVolumeAttachmentsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdOsVolumeAttachmentsPostRequestCreation(String serverId, ServersServerIdOsVolumeAttachmentsPostRequest serversServerIdOsVolumeAttachmentsPostRequest) throws WebClientResponseException {
        Object postBody = serversServerIdOsVolumeAttachmentsPostRequest;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdOsVolumeAttachmentsPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'serversServerIdOsVolumeAttachmentsPostRequest' is set
        if (serversServerIdOsVolumeAttachmentsPostRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'serversServerIdOsVolumeAttachmentsPostRequest' when calling serversServerIdOsVolumeAttachmentsPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("server_id", serverId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response>() {};
        return apiClient.invokeAPI("/servers/{server_id}/os-volume_attachments", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Подключить диск к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param serversServerIdOsVolumeAttachmentsPostRequest The serversServerIdOsVolumeAttachmentsPostRequest parameter
     * @return ServersServerIdOsVolumeAttachmentsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ServersServerIdOsVolumeAttachmentsPost200Response> serversServerIdOsVolumeAttachmentsPost(String serverId, ServersServerIdOsVolumeAttachmentsPostRequest serversServerIdOsVolumeAttachmentsPostRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response>() {};
        return serversServerIdOsVolumeAttachmentsPostRequestCreation(serverId, serversServerIdOsVolumeAttachmentsPostRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Подключить диск к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param serversServerIdOsVolumeAttachmentsPostRequest The serversServerIdOsVolumeAttachmentsPostRequest parameter
     * @return ResponseEntity&lt;ServersServerIdOsVolumeAttachmentsPost200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ServersServerIdOsVolumeAttachmentsPost200Response>> serversServerIdOsVolumeAttachmentsPostWithHttpInfo(String serverId, ServersServerIdOsVolumeAttachmentsPostRequest serversServerIdOsVolumeAttachmentsPostRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsVolumeAttachmentsPost200Response>() {};
        return serversServerIdOsVolumeAttachmentsPostRequestCreation(serverId, serversServerIdOsVolumeAttachmentsPostRequest).toEntity(localVarReturnType);
    }

    /**
     * Подключить диск к ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @param serversServerIdOsVolumeAttachmentsPostRequest The serversServerIdOsVolumeAttachmentsPostRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdOsVolumeAttachmentsPostWithResponseSpec(String serverId, ServersServerIdOsVolumeAttachmentsPostRequest serversServerIdOsVolumeAttachmentsPostRequest) throws WebClientResponseException {
        return serversServerIdOsVolumeAttachmentsPostRequestCreation(serverId, serversServerIdOsVolumeAttachmentsPostRequest);
    }
}
