package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.OsServerGroupsGet200Response;
import org.openapitools.client.model.OsServerGroupsPost200Response;
import org.openapitools.client.model.OsServerGroupsPostRequest;

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
public class ServerGroupsApi {
    private ApiClient apiClient;

    public ServerGroupsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ServerGroupsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить список групп серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. Используется совместно с параметром &#x60;&#x60;offset&#x60;&#x60;, чтобы в последующих запросах получать следующий набор элементов
     * @param offset Порядковый номер элемента, с которого следует начать список
     * @return OsServerGroupsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec osServerGroupsGetRequestCreation(Integer limit, Integer offset) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<OsServerGroupsGet200Response> localVarReturnType = new ParameterizedTypeReference<OsServerGroupsGet200Response>() {};
        return apiClient.invokeAPI("/os-server-groups", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список групп серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. Используется совместно с параметром &#x60;&#x60;offset&#x60;&#x60;, чтобы в последующих запросах получать следующий набор элементов
     * @param offset Порядковый номер элемента, с которого следует начать список
     * @return OsServerGroupsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OsServerGroupsGet200Response> osServerGroupsGet(Integer limit, Integer offset) throws WebClientResponseException {
        ParameterizedTypeReference<OsServerGroupsGet200Response> localVarReturnType = new ParameterizedTypeReference<OsServerGroupsGet200Response>() {};
        return osServerGroupsGetRequestCreation(limit, offset).bodyToMono(localVarReturnType);
    }

    /**
     * Получить список групп серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. Используется совместно с параметром &#x60;&#x60;offset&#x60;&#x60;, чтобы в последующих запросах получать следующий набор элементов
     * @param offset Порядковый номер элемента, с которого следует начать список
     * @return ResponseEntity&lt;OsServerGroupsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OsServerGroupsGet200Response>> osServerGroupsGetWithHttpInfo(Integer limit, Integer offset) throws WebClientResponseException {
        ParameterizedTypeReference<OsServerGroupsGet200Response> localVarReturnType = new ParameterizedTypeReference<OsServerGroupsGet200Response>() {};
        return osServerGroupsGetRequestCreation(limit, offset).toEntity(localVarReturnType);
    }

    /**
     * Получить список групп серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. Используется совместно с параметром &#x60;&#x60;offset&#x60;&#x60;, чтобы в последующих запросах получать следующий набор элементов
     * @param offset Порядковый номер элемента, с которого следует начать список
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec osServerGroupsGetWithResponseSpec(Integer limit, Integer offset) throws WebClientResponseException {
        return osServerGroupsGetRequestCreation(limit, offset);
    }
    /**
     * Создать группу серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param osServerGroupsPostRequest Объект данных новой группы серверов в формате JSON
     * @return OsServerGroupsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec osServerGroupsPostRequestCreation(OsServerGroupsPostRequest osServerGroupsPostRequest) throws WebClientResponseException {
        Object postBody = osServerGroupsPostRequest;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

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

        ParameterizedTypeReference<OsServerGroupsPost200Response> localVarReturnType = new ParameterizedTypeReference<OsServerGroupsPost200Response>() {};
        return apiClient.invokeAPI("/os-server-groups", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Создать группу серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param osServerGroupsPostRequest Объект данных новой группы серверов в формате JSON
     * @return OsServerGroupsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OsServerGroupsPost200Response> osServerGroupsPost(OsServerGroupsPostRequest osServerGroupsPostRequest) throws WebClientResponseException {
        ParameterizedTypeReference<OsServerGroupsPost200Response> localVarReturnType = new ParameterizedTypeReference<OsServerGroupsPost200Response>() {};
        return osServerGroupsPostRequestCreation(osServerGroupsPostRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Создать группу серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param osServerGroupsPostRequest Объект данных новой группы серверов в формате JSON
     * @return ResponseEntity&lt;OsServerGroupsPost200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OsServerGroupsPost200Response>> osServerGroupsPostWithHttpInfo(OsServerGroupsPostRequest osServerGroupsPostRequest) throws WebClientResponseException {
        ParameterizedTypeReference<OsServerGroupsPost200Response> localVarReturnType = new ParameterizedTypeReference<OsServerGroupsPost200Response>() {};
        return osServerGroupsPostRequestCreation(osServerGroupsPostRequest).toEntity(localVarReturnType);
    }

    /**
     * Создать группу серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param osServerGroupsPostRequest Объект данных новой группы серверов в формате JSON
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec osServerGroupsPostWithResponseSpec(OsServerGroupsPostRequest osServerGroupsPostRequest) throws WebClientResponseException {
        return osServerGroupsPostRequestCreation(osServerGroupsPostRequest);
    }
    /**
     * Удалить группу серверов
     * 
     * <p><b>204</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverGroupId Идентификатор группы серверов
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec osServerGroupsServerGroupIdDeleteRequestCreation(String serverGroupId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'serverGroupId' is set
        if (serverGroupId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverGroupId' when calling osServerGroupsServerGroupIdDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("server_group_id", serverGroupId);

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
        return apiClient.invokeAPI("/os-server-groups/{server_group_id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Удалить группу серверов
     * 
     * <p><b>204</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverGroupId Идентификатор группы серверов
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> osServerGroupsServerGroupIdDelete(String serverGroupId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return osServerGroupsServerGroupIdDeleteRequestCreation(serverGroupId).bodyToMono(localVarReturnType);
    }

    /**
     * Удалить группу серверов
     * 
     * <p><b>204</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverGroupId Идентификатор группы серверов
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> osServerGroupsServerGroupIdDeleteWithHttpInfo(String serverGroupId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return osServerGroupsServerGroupIdDeleteRequestCreation(serverGroupId).toEntity(localVarReturnType);
    }

    /**
     * Удалить группу серверов
     * 
     * <p><b>204</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverGroupId Идентификатор группы серверов
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec osServerGroupsServerGroupIdDeleteWithResponseSpec(String serverGroupId) throws WebClientResponseException {
        return osServerGroupsServerGroupIdDeleteRequestCreation(serverGroupId);
    }
    /**
     * Получить информацию о группе серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverGroupId Идентификатор группы серверов
     * @return OsServerGroupsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec osServerGroupsServerGroupIdGetRequestCreation(String serverGroupId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'serverGroupId' is set
        if (serverGroupId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverGroupId' when calling osServerGroupsServerGroupIdGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("server_group_id", serverGroupId);

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

        ParameterizedTypeReference<OsServerGroupsPost200Response> localVarReturnType = new ParameterizedTypeReference<OsServerGroupsPost200Response>() {};
        return apiClient.invokeAPI("/os-server-groups/{server_group_id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить информацию о группе серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverGroupId Идентификатор группы серверов
     * @return OsServerGroupsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OsServerGroupsPost200Response> osServerGroupsServerGroupIdGet(String serverGroupId) throws WebClientResponseException {
        ParameterizedTypeReference<OsServerGroupsPost200Response> localVarReturnType = new ParameterizedTypeReference<OsServerGroupsPost200Response>() {};
        return osServerGroupsServerGroupIdGetRequestCreation(serverGroupId).bodyToMono(localVarReturnType);
    }

    /**
     * Получить информацию о группе серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverGroupId Идентификатор группы серверов
     * @return ResponseEntity&lt;OsServerGroupsPost200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OsServerGroupsPost200Response>> osServerGroupsServerGroupIdGetWithHttpInfo(String serverGroupId) throws WebClientResponseException {
        ParameterizedTypeReference<OsServerGroupsPost200Response> localVarReturnType = new ParameterizedTypeReference<OsServerGroupsPost200Response>() {};
        return osServerGroupsServerGroupIdGetRequestCreation(serverGroupId).toEntity(localVarReturnType);
    }

    /**
     * Получить информацию о группе серверов
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverGroupId Идентификатор группы серверов
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec osServerGroupsServerGroupIdGetWithResponseSpec(String serverGroupId) throws WebClientResponseException {
        return osServerGroupsServerGroupIdGetRequestCreation(serverGroupId);
    }
}
