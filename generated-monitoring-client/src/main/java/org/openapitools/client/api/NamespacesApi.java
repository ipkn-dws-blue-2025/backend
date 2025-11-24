package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.Error;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-11-24T15:32:08.670553200+03:00[Europe/Moscow]", comments = "Generator version: 7.4.0")
public class NamespacesApi {
    private ApiClient apiClient;

    public NamespacesApi() {
        this(new ApiClient());
    }

    @Autowired
    public NamespacesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить список разрешенных пространств имен
     * Получить список [пространств имен](https://cloud.vk.com/docs/ru/monitoring-services/monitoring/concepts/architecture/#namespaces) (namespaces), которые можно использовать в запросах
     * <p><b>200</b> - Список разрешенных пространств имен
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * @return List&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec allowedNamespacesRequestCreation() throws WebClientResponseException {
        Object postBody = null;
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
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "keystone" };

        ParameterizedTypeReference<List<String>> localVarReturnType = new ParameterizedTypeReference<List<String>>() {};
        return apiClient.invokeAPI("/namespaces", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список разрешенных пространств имен
     * Получить список [пространств имен](https://cloud.vk.com/docs/ru/monitoring-services/monitoring/concepts/architecture/#namespaces) (namespaces), которые можно использовать в запросах
     * <p><b>200</b> - Список разрешенных пространств имен
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * @return List&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<List<String>> allowedNamespaces() throws WebClientResponseException {
        ParameterizedTypeReference<List<String>> localVarReturnType = new ParameterizedTypeReference<List<String>>() {};
        return allowedNamespacesRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Получить список разрешенных пространств имен
     * Получить список [пространств имен](https://cloud.vk.com/docs/ru/monitoring-services/monitoring/concepts/architecture/#namespaces) (namespaces), которые можно использовать в запросах
     * <p><b>200</b> - Список разрешенных пространств имен
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * @return ResponseEntity&lt;List&lt;String&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<List<String>>> allowedNamespacesWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<List<String>> localVarReturnType = new ParameterizedTypeReference<List<String>>() {};
        return allowedNamespacesRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Получить список разрешенных пространств имен
     * Получить список [пространств имен](https://cloud.vk.com/docs/ru/monitoring-services/monitoring/concepts/architecture/#namespaces) (namespaces), которые можно использовать в запросах
     * <p><b>200</b> - Список разрешенных пространств имен
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec allowedNamespacesWithResponseSpec() throws WebClientResponseException {
        return allowedNamespacesRequestCreation();
    }
}
