package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.OsKeypairsGet200Response;
import org.openapitools.client.model.OsKeypairsKeypairNameGet200Response;
import org.openapitools.client.model.OsKeypairsPost200Response;
import org.openapitools.client.model.OsKeypairsPostRequest;

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
public class KeypairsApi {
    private ApiClient apiClient;

    public KeypairsApi() {
        this(new ApiClient());
    }

    @Autowired
    public KeypairsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить список ключевых пар
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @return OsKeypairsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec osKeypairsGetRequestCreation(Integer limit, String marker) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "marker", marker));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<OsKeypairsGet200Response> localVarReturnType = new ParameterizedTypeReference<OsKeypairsGet200Response>() {};
        return apiClient.invokeAPI("/os-keypairs", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список ключевых пар
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @return OsKeypairsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OsKeypairsGet200Response> osKeypairsGet(Integer limit, String marker) throws WebClientResponseException {
        ParameterizedTypeReference<OsKeypairsGet200Response> localVarReturnType = new ParameterizedTypeReference<OsKeypairsGet200Response>() {};
        return osKeypairsGetRequestCreation(limit, marker).bodyToMono(localVarReturnType);
    }

    /**
     * Получить список ключевых пар
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @return ResponseEntity&lt;OsKeypairsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OsKeypairsGet200Response>> osKeypairsGetWithHttpInfo(Integer limit, String marker) throws WebClientResponseException {
        ParameterizedTypeReference<OsKeypairsGet200Response> localVarReturnType = new ParameterizedTypeReference<OsKeypairsGet200Response>() {};
        return osKeypairsGetRequestCreation(limit, marker).toEntity(localVarReturnType);
    }

    /**
     * Получить список ключевых пар
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec osKeypairsGetWithResponseSpec(Integer limit, String marker) throws WebClientResponseException {
        return osKeypairsGetRequestCreation(limit, marker);
    }
    /**
     * Удалить ключевую пару
     * 
     * <p><b>202</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param keypairName Имя ключевой пары
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec osKeypairsKeypairNameDeleteRequestCreation(String keypairName) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'keypairName' is set
        if (keypairName == null) {
            throw new WebClientResponseException("Missing the required parameter 'keypairName' when calling osKeypairsKeypairNameDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("keypair_name", keypairName);

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
        return apiClient.invokeAPI("/os-keypairs/{keypair_name}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Удалить ключевую пару
     * 
     * <p><b>202</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param keypairName Имя ключевой пары
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> osKeypairsKeypairNameDelete(String keypairName) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return osKeypairsKeypairNameDeleteRequestCreation(keypairName).bodyToMono(localVarReturnType);
    }

    /**
     * Удалить ключевую пару
     * 
     * <p><b>202</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param keypairName Имя ключевой пары
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> osKeypairsKeypairNameDeleteWithHttpInfo(String keypairName) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return osKeypairsKeypairNameDeleteRequestCreation(keypairName).toEntity(localVarReturnType);
    }

    /**
     * Удалить ключевую пару
     * 
     * <p><b>202</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param keypairName Имя ключевой пары
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec osKeypairsKeypairNameDeleteWithResponseSpec(String keypairName) throws WebClientResponseException {
        return osKeypairsKeypairNameDeleteRequestCreation(keypairName);
    }
    /**
     * Получить информацию о ключевой паре
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param keypairName Имя ключевой пары
     * @return OsKeypairsKeypairNameGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec osKeypairsKeypairNameGetRequestCreation(String keypairName) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'keypairName' is set
        if (keypairName == null) {
            throw new WebClientResponseException("Missing the required parameter 'keypairName' when calling osKeypairsKeypairNameGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("keypair_name", keypairName);

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

        ParameterizedTypeReference<OsKeypairsKeypairNameGet200Response> localVarReturnType = new ParameterizedTypeReference<OsKeypairsKeypairNameGet200Response>() {};
        return apiClient.invokeAPI("/os-keypairs/{keypair_name}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить информацию о ключевой паре
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param keypairName Имя ключевой пары
     * @return OsKeypairsKeypairNameGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OsKeypairsKeypairNameGet200Response> osKeypairsKeypairNameGet(String keypairName) throws WebClientResponseException {
        ParameterizedTypeReference<OsKeypairsKeypairNameGet200Response> localVarReturnType = new ParameterizedTypeReference<OsKeypairsKeypairNameGet200Response>() {};
        return osKeypairsKeypairNameGetRequestCreation(keypairName).bodyToMono(localVarReturnType);
    }

    /**
     * Получить информацию о ключевой паре
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param keypairName Имя ключевой пары
     * @return ResponseEntity&lt;OsKeypairsKeypairNameGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OsKeypairsKeypairNameGet200Response>> osKeypairsKeypairNameGetWithHttpInfo(String keypairName) throws WebClientResponseException {
        ParameterizedTypeReference<OsKeypairsKeypairNameGet200Response> localVarReturnType = new ParameterizedTypeReference<OsKeypairsKeypairNameGet200Response>() {};
        return osKeypairsKeypairNameGetRequestCreation(keypairName).toEntity(localVarReturnType);
    }

    /**
     * Получить информацию о ключевой паре
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param keypairName Имя ключевой пары
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec osKeypairsKeypairNameGetWithResponseSpec(String keypairName) throws WebClientResponseException {
        return osKeypairsKeypairNameGetRequestCreation(keypairName);
    }
    /**
     * Создать или импортировать ключевую пару
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>409</b> - Конфликт
     * @param osKeypairsPostRequest Объект данных новой ключевой пары в формате JSON
     * @return OsKeypairsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec osKeypairsPostRequestCreation(OsKeypairsPostRequest osKeypairsPostRequest) throws WebClientResponseException {
        Object postBody = osKeypairsPostRequest;
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

        ParameterizedTypeReference<OsKeypairsPost200Response> localVarReturnType = new ParameterizedTypeReference<OsKeypairsPost200Response>() {};
        return apiClient.invokeAPI("/os-keypairs", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Создать или импортировать ключевую пару
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>409</b> - Конфликт
     * @param osKeypairsPostRequest Объект данных новой ключевой пары в формате JSON
     * @return OsKeypairsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OsKeypairsPost200Response> osKeypairsPost(OsKeypairsPostRequest osKeypairsPostRequest) throws WebClientResponseException {
        ParameterizedTypeReference<OsKeypairsPost200Response> localVarReturnType = new ParameterizedTypeReference<OsKeypairsPost200Response>() {};
        return osKeypairsPostRequestCreation(osKeypairsPostRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Создать или импортировать ключевую пару
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>409</b> - Конфликт
     * @param osKeypairsPostRequest Объект данных новой ключевой пары в формате JSON
     * @return ResponseEntity&lt;OsKeypairsPost200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OsKeypairsPost200Response>> osKeypairsPostWithHttpInfo(OsKeypairsPostRequest osKeypairsPostRequest) throws WebClientResponseException {
        ParameterizedTypeReference<OsKeypairsPost200Response> localVarReturnType = new ParameterizedTypeReference<OsKeypairsPost200Response>() {};
        return osKeypairsPostRequestCreation(osKeypairsPostRequest).toEntity(localVarReturnType);
    }

    /**
     * Создать или импортировать ключевую пару
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>409</b> - Конфликт
     * @param osKeypairsPostRequest Объект данных новой ключевой пары в формате JSON
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec osKeypairsPostWithResponseSpec(OsKeypairsPostRequest osKeypairsPostRequest) throws WebClientResponseException {
        return osKeypairsPostRequestCreation(osKeypairsPostRequest);
    }
}
