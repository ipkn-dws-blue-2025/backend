package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.OsAvailabilityZoneGet200Response;

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
public class AvailabilityZoneApi {
    private ApiClient apiClient;

    public AvailabilityZoneApi() {
        this(new ApiClient());
    }

    @Autowired
    public AvailabilityZoneApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить информацию о зонах доступности
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @return OsAvailabilityZoneGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec osAvailabilityZoneGetRequestCreation() throws WebClientResponseException {
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

        ParameterizedTypeReference<OsAvailabilityZoneGet200Response> localVarReturnType = new ParameterizedTypeReference<OsAvailabilityZoneGet200Response>() {};
        return apiClient.invokeAPI("/os-availability-zone", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить информацию о зонах доступности
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @return OsAvailabilityZoneGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OsAvailabilityZoneGet200Response> osAvailabilityZoneGet() throws WebClientResponseException {
        ParameterizedTypeReference<OsAvailabilityZoneGet200Response> localVarReturnType = new ParameterizedTypeReference<OsAvailabilityZoneGet200Response>() {};
        return osAvailabilityZoneGetRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Получить информацию о зонах доступности
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @return ResponseEntity&lt;OsAvailabilityZoneGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OsAvailabilityZoneGet200Response>> osAvailabilityZoneGetWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<OsAvailabilityZoneGet200Response> localVarReturnType = new ParameterizedTypeReference<OsAvailabilityZoneGet200Response>() {};
        return osAvailabilityZoneGetRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Получить информацию о зонах доступности
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec osAvailabilityZoneGetWithResponseSpec() throws WebClientResponseException {
        return osAvailabilityZoneGetRequestCreation();
    }
}
