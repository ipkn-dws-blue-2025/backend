package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.FlavorDetails;
import org.openapitools.client.model.GetListFlavors;
import java.util.UUID;

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
public class FlavorsApi {
    private ApiClient apiClient;

    public FlavorsApi() {
        this(new ApiClient());
    }

    @Autowired
    public FlavorsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить список шаблонов конфигураций ВМ с подробной информацией
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param sortKey Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param minDisk Фильтр по минимальному размеру диска в гигибайтах
     * @param minRam Фильтр по минимальному количеству RAM в мебибайтах
     * @return List&lt;FlavorDetails&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec flavorsDetailGetRequestCreation(String sortKey, String sortDir, Integer limit, String marker, Integer minDisk, Integer minRam) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_key", sortKey));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_dir", sortDir));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "marker", marker));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "minDisk", minDisk));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "minRam", minRam));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<FlavorDetails> localVarReturnType = new ParameterizedTypeReference<FlavorDetails>() {};
        return apiClient.invokeAPI("/flavors/detail", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список шаблонов конфигураций ВМ с подробной информацией
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param sortKey Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param minDisk Фильтр по минимальному размеру диска в гигибайтах
     * @param minRam Фильтр по минимальному количеству RAM в мебибайтах
     * @return List&lt;FlavorDetails&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<FlavorDetails> flavorsDetailGet(String sortKey, String sortDir, Integer limit, String marker, Integer minDisk, Integer minRam) throws WebClientResponseException {
        ParameterizedTypeReference<FlavorDetails> localVarReturnType = new ParameterizedTypeReference<FlavorDetails>() {};
        return flavorsDetailGetRequestCreation(sortKey, sortDir, limit, marker, minDisk, minRam).bodyToFlux(localVarReturnType);
    }

    /**
     * Получить список шаблонов конфигураций ВМ с подробной информацией
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param sortKey Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param minDisk Фильтр по минимальному размеру диска в гигибайтах
     * @param minRam Фильтр по минимальному количеству RAM в мебибайтах
     * @return ResponseEntity&lt;List&lt;FlavorDetails&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<List<FlavorDetails>>> flavorsDetailGetWithHttpInfo(String sortKey, String sortDir, Integer limit, String marker, Integer minDisk, Integer minRam) throws WebClientResponseException {
        ParameterizedTypeReference<FlavorDetails> localVarReturnType = new ParameterizedTypeReference<FlavorDetails>() {};
        return flavorsDetailGetRequestCreation(sortKey, sortDir, limit, marker, minDisk, minRam).toEntityList(localVarReturnType);
    }

    /**
     * Получить список шаблонов конфигураций ВМ с подробной информацией
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param sortKey Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param minDisk Фильтр по минимальному размеру диска в гигибайтах
     * @param minRam Фильтр по минимальному количеству RAM в мебибайтах
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec flavorsDetailGetWithResponseSpec(String sortKey, String sortDir, Integer limit, String marker, Integer minDisk, Integer minRam) throws WebClientResponseException {
        return flavorsDetailGetRequestCreation(sortKey, sortDir, limit, marker, minDisk, minRam);
    }
    /**
     * Получить информацию о шаблоне конфигурации ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param flavorId Идентификатор шаблона конфигурации ВМ
     * @return FlavorDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec flavorsFlavorIdGetRequestCreation(String flavorId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'flavorId' is set
        if (flavorId == null) {
            throw new WebClientResponseException("Missing the required parameter 'flavorId' when calling flavorsFlavorIdGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("flavor_id", flavorId);

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

        ParameterizedTypeReference<FlavorDetails> localVarReturnType = new ParameterizedTypeReference<FlavorDetails>() {};
        return apiClient.invokeAPI("/flavors/{flavor_id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить информацию о шаблоне конфигурации ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param flavorId Идентификатор шаблона конфигурации ВМ
     * @return FlavorDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<FlavorDetails> flavorsFlavorIdGet(String flavorId) throws WebClientResponseException {
        ParameterizedTypeReference<FlavorDetails> localVarReturnType = new ParameterizedTypeReference<FlavorDetails>() {};
        return flavorsFlavorIdGetRequestCreation(flavorId).bodyToMono(localVarReturnType);
    }

    /**
     * Получить информацию о шаблоне конфигурации ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param flavorId Идентификатор шаблона конфигурации ВМ
     * @return ResponseEntity&lt;FlavorDetails&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<FlavorDetails>> flavorsFlavorIdGetWithHttpInfo(String flavorId) throws WebClientResponseException {
        ParameterizedTypeReference<FlavorDetails> localVarReturnType = new ParameterizedTypeReference<FlavorDetails>() {};
        return flavorsFlavorIdGetRequestCreation(flavorId).toEntity(localVarReturnType);
    }

    /**
     * Получить информацию о шаблоне конфигурации ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param flavorId Идентификатор шаблона конфигурации ВМ
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec flavorsFlavorIdGetWithResponseSpec(String flavorId) throws WebClientResponseException {
        return flavorsFlavorIdGetRequestCreation(flavorId);
    }
    /**
     * Получить значение дополнительного параметра шаблона конфигурации ВМ
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Объект не найден
     * @param flavorId The flavorId parameter
     * @param extraSpecKey The extraSpecKey parameter
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec flavorsFlavorIdOsExtraSpecsExtraSpecKeyGetRequestCreation(UUID flavorId, String extraSpecKey) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'flavorId' is set
        if (flavorId == null) {
            throw new WebClientResponseException("Missing the required parameter 'flavorId' when calling flavorsFlavorIdOsExtraSpecsExtraSpecKeyGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'extraSpecKey' is set
        if (extraSpecKey == null) {
            throw new WebClientResponseException("Missing the required parameter 'extraSpecKey' when calling flavorsFlavorIdOsExtraSpecsExtraSpecKeyGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("flavor_id", flavorId);
        pathParams.put("extra_spec_key", extraSpecKey);

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

        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/flavors/{flavor_id}/os-extra_specs/{extra_spec_key}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить значение дополнительного параметра шаблона конфигурации ВМ
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Объект не найден
     * @param flavorId The flavorId parameter
     * @param extraSpecKey The extraSpecKey parameter
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Object> flavorsFlavorIdOsExtraSpecsExtraSpecKeyGet(UUID flavorId, String extraSpecKey) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return flavorsFlavorIdOsExtraSpecsExtraSpecKeyGetRequestCreation(flavorId, extraSpecKey).bodyToMono(localVarReturnType);
    }

    /**
     * Получить значение дополнительного параметра шаблона конфигурации ВМ
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Объект не найден
     * @param flavorId The flavorId parameter
     * @param extraSpecKey The extraSpecKey parameter
     * @return ResponseEntity&lt;Object&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Object>> flavorsFlavorIdOsExtraSpecsExtraSpecKeyGetWithHttpInfo(UUID flavorId, String extraSpecKey) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return flavorsFlavorIdOsExtraSpecsExtraSpecKeyGetRequestCreation(flavorId, extraSpecKey).toEntity(localVarReturnType);
    }

    /**
     * Получить значение дополнительного параметра шаблона конфигурации ВМ
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Объект не найден
     * @param flavorId The flavorId parameter
     * @param extraSpecKey The extraSpecKey parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec flavorsFlavorIdOsExtraSpecsExtraSpecKeyGetWithResponseSpec(UUID flavorId, String extraSpecKey) throws WebClientResponseException {
        return flavorsFlavorIdOsExtraSpecsExtraSpecKeyGetRequestCreation(flavorId, extraSpecKey);
    }
    /**
     * Вернуть все дополнительные параметры шаблона конфигурации ВМ
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Объект не найден
     * @param flavorId UUID шаблона конфигурации ВМ
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec flavorsFlavorIdOsExtraSpecsGetRequestCreation(UUID flavorId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'flavorId' is set
        if (flavorId == null) {
            throw new WebClientResponseException("Missing the required parameter 'flavorId' when calling flavorsFlavorIdOsExtraSpecsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("flavor_id", flavorId);

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

        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/flavors/{flavor_id}/os-extra_specs", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Вернуть все дополнительные параметры шаблона конфигурации ВМ
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Объект не найден
     * @param flavorId UUID шаблона конфигурации ВМ
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Object> flavorsFlavorIdOsExtraSpecsGet(UUID flavorId) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return flavorsFlavorIdOsExtraSpecsGetRequestCreation(flavorId).bodyToMono(localVarReturnType);
    }

    /**
     * Вернуть все дополнительные параметры шаблона конфигурации ВМ
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Объект не найден
     * @param flavorId UUID шаблона конфигурации ВМ
     * @return ResponseEntity&lt;Object&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Object>> flavorsFlavorIdOsExtraSpecsGetWithHttpInfo(UUID flavorId) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return flavorsFlavorIdOsExtraSpecsGetRequestCreation(flavorId).toEntity(localVarReturnType);
    }

    /**
     * Вернуть все дополнительные параметры шаблона конфигурации ВМ
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Объект не найден
     * @param flavorId UUID шаблона конфигурации ВМ
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec flavorsFlavorIdOsExtraSpecsGetWithResponseSpec(UUID flavorId) throws WebClientResponseException {
        return flavorsFlavorIdOsExtraSpecsGetRequestCreation(flavorId);
    }
    /**
     * Получить список шаблонов конфигураций ВМ
     * Метод возвращает список шаблонов конфигураций ВМ по заданным фильтрам
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param sortKey Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param minDisk Фильтр по минимальному размеру диска в гигибайтах
     * @param minRam Фильтр по минимальному количеству RAM в мебибайтах
     * @return GetListFlavors
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec flavorsGetRequestCreation(String sortKey, String sortDir, Integer limit, String marker, Integer minDisk, Integer minRam) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_key", sortKey));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_dir", sortDir));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "marker", marker));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "minDisk", minDisk));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "minRam", minRam));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetListFlavors> localVarReturnType = new ParameterizedTypeReference<GetListFlavors>() {};
        return apiClient.invokeAPI("/flavors", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список шаблонов конфигураций ВМ
     * Метод возвращает список шаблонов конфигураций ВМ по заданным фильтрам
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param sortKey Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param minDisk Фильтр по минимальному размеру диска в гигибайтах
     * @param minRam Фильтр по минимальному количеству RAM в мебибайтах
     * @return GetListFlavors
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetListFlavors> flavorsGet(String sortKey, String sortDir, Integer limit, String marker, Integer minDisk, Integer minRam) throws WebClientResponseException {
        ParameterizedTypeReference<GetListFlavors> localVarReturnType = new ParameterizedTypeReference<GetListFlavors>() {};
        return flavorsGetRequestCreation(sortKey, sortDir, limit, marker, minDisk, minRam).bodyToMono(localVarReturnType);
    }

    /**
     * Получить список шаблонов конфигураций ВМ
     * Метод возвращает список шаблонов конфигураций ВМ по заданным фильтрам
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param sortKey Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param minDisk Фильтр по минимальному размеру диска в гигибайтах
     * @param minRam Фильтр по минимальному количеству RAM в мебибайтах
     * @return ResponseEntity&lt;GetListFlavors&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetListFlavors>> flavorsGetWithHttpInfo(String sortKey, String sortDir, Integer limit, String marker, Integer minDisk, Integer minRam) throws WebClientResponseException {
        ParameterizedTypeReference<GetListFlavors> localVarReturnType = new ParameterizedTypeReference<GetListFlavors>() {};
        return flavorsGetRequestCreation(sortKey, sortDir, limit, marker, minDisk, minRam).toEntity(localVarReturnType);
    }

    /**
     * Получить список шаблонов конфигураций ВМ
     * Метод возвращает список шаблонов конфигураций ВМ по заданным фильтрам
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param sortKey Атрибут, по которому сортируются шаблоны конфигураций ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param minDisk Фильтр по минимальному размеру диска в гигибайтах
     * @param minRam Фильтр по минимальному количеству RAM в мебибайтах
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec flavorsGetWithResponseSpec(String sortKey, String sortDir, Integer limit, String marker, Integer minDisk, Integer minRam) throws WebClientResponseException {
        return flavorsGetRequestCreation(sortKey, sortDir, limit, marker, minDisk, minRam);
    }
}
