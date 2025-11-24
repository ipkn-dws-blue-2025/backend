package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.Error;
import org.openapitools.client.model.ErrorBadRequest;
import org.openapitools.client.model.GetSeriesQueryResponse;

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
public class SeriesApi {
    private ApiClient apiClient;

    public SeriesApi() {
        this(new ApiClient());
    }

    @Autowired
    public SeriesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить список метрик по заданному фильтру (Series query)
     * Выполнить запрос списка метрик, которые [соответствуют заданному фильтру](https://prometheus.io/docs/prometheus/latest/querying/api/#finding-series-by-label-matchers). Фильтр задается набором меток в виде пар имя/значение
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param match Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). В выражении должна быть задана хотя бы одна метка для поиска подходящих метрик
     * @param namespace Пространство имен сервиса VK Cloud
     * @param start Начало диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
     * @param end Конец диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
     * @return GetSeriesQueryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec seriesQueryRequestCreation(String projectId, List<String> match, String namespace, String start, String end) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new WebClientResponseException("Missing the required parameter 'projectId' when calling seriesQuery", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'match' is set
        if (match == null) {
            throw new WebClientResponseException("Missing the required parameter 'match' when calling seriesQuery", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("project_id", projectId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "namespace", namespace));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "match[]", match));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start", start));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "end", end));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "keystone" };

        ParameterizedTypeReference<GetSeriesQueryResponse> localVarReturnType = new ParameterizedTypeReference<GetSeriesQueryResponse>() {};
        return apiClient.invokeAPI("/{project_id}/series", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список метрик по заданному фильтру (Series query)
     * Выполнить запрос списка метрик, которые [соответствуют заданному фильтру](https://prometheus.io/docs/prometheus/latest/querying/api/#finding-series-by-label-matchers). Фильтр задается набором меток в виде пар имя/значение
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param match Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). В выражении должна быть задана хотя бы одна метка для поиска подходящих метрик
     * @param namespace Пространство имен сервиса VK Cloud
     * @param start Начало диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
     * @param end Конец диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
     * @return GetSeriesQueryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetSeriesQueryResponse> seriesQuery(String projectId, List<String> match, String namespace, String start, String end) throws WebClientResponseException {
        ParameterizedTypeReference<GetSeriesQueryResponse> localVarReturnType = new ParameterizedTypeReference<GetSeriesQueryResponse>() {};
        return seriesQueryRequestCreation(projectId, match, namespace, start, end).bodyToMono(localVarReturnType);
    }

    /**
     * Получить список метрик по заданному фильтру (Series query)
     * Выполнить запрос списка метрик, которые [соответствуют заданному фильтру](https://prometheus.io/docs/prometheus/latest/querying/api/#finding-series-by-label-matchers). Фильтр задается набором меток в виде пар имя/значение
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param match Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). В выражении должна быть задана хотя бы одна метка для поиска подходящих метрик
     * @param namespace Пространство имен сервиса VK Cloud
     * @param start Начало диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
     * @param end Конец диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
     * @return ResponseEntity&lt;GetSeriesQueryResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetSeriesQueryResponse>> seriesQueryWithHttpInfo(String projectId, List<String> match, String namespace, String start, String end) throws WebClientResponseException {
        ParameterizedTypeReference<GetSeriesQueryResponse> localVarReturnType = new ParameterizedTypeReference<GetSeriesQueryResponse>() {};
        return seriesQueryRequestCreation(projectId, match, namespace, start, end).toEntity(localVarReturnType);
    }

    /**
     * Получить список метрик по заданному фильтру (Series query)
     * Выполнить запрос списка метрик, которые [соответствуют заданному фильтру](https://prometheus.io/docs/prometheus/latest/querying/api/#finding-series-by-label-matchers). Фильтр задается набором меток в виде пар имя/значение
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param match Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). В выражении должна быть задана хотя бы одна метка для поиска подходящих метрик
     * @param namespace Пространство имен сервиса VK Cloud
     * @param start Начало диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
     * @param end Конец диапазона времени, в котором нужно провести поиск подходящих метрик. Формат — RFC3339 или Unix timestamp
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec seriesQueryWithResponseSpec(String projectId, List<String> match, String namespace, String start, String end) throws WebClientResponseException {
        return seriesQueryRequestCreation(projectId, match, namespace, start, end);
    }
}
