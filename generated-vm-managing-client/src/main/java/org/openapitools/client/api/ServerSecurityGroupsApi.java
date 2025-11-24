package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ServersServerIdOsSecurityGroupsGet200Response;

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
public class ServerSecurityGroupsApi {
    private ApiClient apiClient;

    public ServerSecurityGroupsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ServerSecurityGroupsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить список групп безопасности ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ServersServerIdOsSecurityGroupsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdOsSecurityGroupsGetRequestCreation(String serverId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdOsSecurityGroupsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ServersServerIdOsSecurityGroupsGet200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsSecurityGroupsGet200Response>() {};
        return apiClient.invokeAPI("/servers/{server_id}/os-security-groups", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список групп безопасности ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ServersServerIdOsSecurityGroupsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ServersServerIdOsSecurityGroupsGet200Response> serversServerIdOsSecurityGroupsGet(String serverId) throws WebClientResponseException {
        ParameterizedTypeReference<ServersServerIdOsSecurityGroupsGet200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsSecurityGroupsGet200Response>() {};
        return serversServerIdOsSecurityGroupsGetRequestCreation(serverId).bodyToMono(localVarReturnType);
    }

    /**
     * Получить список групп безопасности ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ResponseEntity&lt;ServersServerIdOsSecurityGroupsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ServersServerIdOsSecurityGroupsGet200Response>> serversServerIdOsSecurityGroupsGetWithHttpInfo(String serverId) throws WebClientResponseException {
        ParameterizedTypeReference<ServersServerIdOsSecurityGroupsGet200Response> localVarReturnType = new ParameterizedTypeReference<ServersServerIdOsSecurityGroupsGet200Response>() {};
        return serversServerIdOsSecurityGroupsGetRequestCreation(serverId).toEntity(localVarReturnType);
    }

    /**
     * Получить список групп безопасности ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdOsSecurityGroupsGetWithResponseSpec(String serverId) throws WebClientResponseException {
        return serversServerIdOsSecurityGroupsGetRequestCreation(serverId);
    }
}
