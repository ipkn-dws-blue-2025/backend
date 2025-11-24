package org.openapitools.client.api;

import org.openapitools.client.ApiClient;


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
public class ServerActionsApi {
    private ApiClient apiClient;

    public ServerActionsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ServerActionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Выполнить действие с ВМ
     * Метод позволяет управлять работой ВМ.  Укажите желаемое действие в теле запроса.
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * <p><b>501</b> - Метод еще не реализован
     * @param serverId Идентификатор ВМ
     * @param body The body parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdActionPostRequestCreation(String serverId, Object body) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdActionPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling serversServerIdActionPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("server_id", serverId);

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
        return apiClient.invokeAPI("/servers/{server_id}/action", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Выполнить действие с ВМ
     * Метод позволяет управлять работой ВМ.  Укажите желаемое действие в теле запроса.
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * <p><b>501</b> - Метод еще не реализован
     * @param serverId Идентификатор ВМ
     * @param body The body parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> serversServerIdActionPost(String serverId, Object body) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return serversServerIdActionPostRequestCreation(serverId, body).bodyToMono(localVarReturnType);
    }

    /**
     * Выполнить действие с ВМ
     * Метод позволяет управлять работой ВМ.  Укажите желаемое действие в теле запроса.
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * <p><b>501</b> - Метод еще не реализован
     * @param serverId Идентификатор ВМ
     * @param body The body parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> serversServerIdActionPostWithHttpInfo(String serverId, Object body) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return serversServerIdActionPostRequestCreation(serverId, body).toEntity(localVarReturnType);
    }

    /**
     * Выполнить действие с ВМ
     * Метод позволяет управлять работой ВМ.  Укажите желаемое действие в теле запроса.
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * <p><b>501</b> - Метод еще не реализован
     * @param serverId Идентификатор ВМ
     * @param body The body parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdActionPostWithResponseSpec(String serverId, Object body) throws WebClientResponseException {
        return serversServerIdActionPostRequestCreation(serverId, body);
    }
}
