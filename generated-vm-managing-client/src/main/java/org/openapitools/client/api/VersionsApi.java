package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.Versions;

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
public class VersionsApi {
    private ApiClient apiClient;

    public VersionsApi() {
        this(new ApiClient());
    }

    @Autowired
    public VersionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Подтвердить наличие версии 2.1
     * Метод позволяет подтвердить наличие версии 2.1.  Возвращает код &#x60;&#x60;304 FOUND&#x60;&#x60; и пустое тело ответа
     * <p><b>304</b> - ОК
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiConfirmV21V21GetRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

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
        return apiClient.invokeAPI("/v2.1", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Подтвердить наличие версии 2.1
     * Метод позволяет подтвердить наличие версии 2.1.  Возвращает код &#x60;&#x60;304 FOUND&#x60;&#x60; и пустое тело ответа
     * <p><b>304</b> - ОК
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> apiConfirmV21V21Get() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiConfirmV21V21GetRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Подтвердить наличие версии 2.1
     * Метод позволяет подтвердить наличие версии 2.1.  Возвращает код &#x60;&#x60;304 FOUND&#x60;&#x60; и пустое тело ответа
     * <p><b>304</b> - ОК
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> apiConfirmV21V21GetWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiConfirmV21V21GetRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Подтвердить наличие версии 2.1
     * Метод позволяет подтвердить наличие версии 2.1.  Возвращает код &#x60;&#x60;304 FOUND&#x60;&#x60; и пустое тело ответа
     * <p><b>304</b> - ОК
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiConfirmV21V21GetWithResponseSpec() throws WebClientResponseException {
        return apiConfirmV21V21GetRequestCreation();
    }
    /**
     * Получить перечень поддерживаемых версий API
     * 
     * <p><b>200</b> - ОК
     * @return Versions
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec rootGetRequestCreation() throws WebClientResponseException {
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

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Versions> localVarReturnType = new ParameterizedTypeReference<Versions>() {};
        return apiClient.invokeAPI("/", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить перечень поддерживаемых версий API
     * 
     * <p><b>200</b> - ОК
     * @return Versions
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Versions> rootGet() throws WebClientResponseException {
        ParameterizedTypeReference<Versions> localVarReturnType = new ParameterizedTypeReference<Versions>() {};
        return rootGetRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Получить перечень поддерживаемых версий API
     * 
     * <p><b>200</b> - ОК
     * @return ResponseEntity&lt;Versions&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Versions>> rootGetWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<Versions> localVarReturnType = new ParameterizedTypeReference<Versions>() {};
        return rootGetRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Получить перечень поддерживаемых версий API
     * 
     * <p><b>200</b> - ОК
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec rootGetWithResponseSpec() throws WebClientResponseException {
        return rootGetRequestCreation();
    }
}
