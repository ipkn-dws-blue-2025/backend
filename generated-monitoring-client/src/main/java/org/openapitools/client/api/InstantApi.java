package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.Error;
import org.openapitools.client.model.ErrorBadRequest;
import org.openapitools.client.model.GetInstantQueryResponse;

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
public class InstantApi {
    private ApiClient apiClient;

    public InstantApi() {
        this(new ApiClient());
    }

    @Autowired
    public InstantApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить метрики в момент времени (Instant query)
     * Выполнить запрос значений метрик для заданного момента времени
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param query Выражение запроса на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/)
     * @param namespace Пространство имен сервиса VK Cloud
     * @param time Момент времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp. Если параметр не указан, используется текущий момент времени сервера
     * @param step Диапазон времени перед моментом time, в котором будет проведен поиск значений метрик, если значения не будут найдены для момента time. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations)
     * @return GetInstantQueryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec instantQueryRequestCreation(String projectId, String query, String namespace, String time, String step) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new WebClientResponseException("Missing the required parameter 'projectId' when calling instantQuery", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new WebClientResponseException("Missing the required parameter 'query' when calling instantQuery", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("project_id", projectId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "namespace", namespace));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "query", query));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "time", time));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "step", step));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "keystone" };

        ParameterizedTypeReference<GetInstantQueryResponse> localVarReturnType = new ParameterizedTypeReference<GetInstantQueryResponse>() {};
        return apiClient.invokeAPI("/{project_id}/query", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить метрики в момент времени (Instant query)
     * Выполнить запрос значений метрик для заданного момента времени
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param query Выражение запроса на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/)
     * @param namespace Пространство имен сервиса VK Cloud
     * @param time Момент времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp. Если параметр не указан, используется текущий момент времени сервера
     * @param step Диапазон времени перед моментом time, в котором будет проведен поиск значений метрик, если значения не будут найдены для момента time. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations)
     * @return GetInstantQueryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetInstantQueryResponse> instantQuery(String projectId, String query, String namespace, String time, String step) throws WebClientResponseException {
        ParameterizedTypeReference<GetInstantQueryResponse> localVarReturnType = new ParameterizedTypeReference<GetInstantQueryResponse>() {};
        return instantQueryRequestCreation(projectId, query, namespace, time, step).bodyToMono(localVarReturnType);
    }

    /**
     * Получить метрики в момент времени (Instant query)
     * Выполнить запрос значений метрик для заданного момента времени
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param query Выражение запроса на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/)
     * @param namespace Пространство имен сервиса VK Cloud
     * @param time Момент времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp. Если параметр не указан, используется текущий момент времени сервера
     * @param step Диапазон времени перед моментом time, в котором будет проведен поиск значений метрик, если значения не будут найдены для момента time. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations)
     * @return ResponseEntity&lt;GetInstantQueryResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetInstantQueryResponse>> instantQueryWithHttpInfo(String projectId, String query, String namespace, String time, String step) throws WebClientResponseException {
        ParameterizedTypeReference<GetInstantQueryResponse> localVarReturnType = new ParameterizedTypeReference<GetInstantQueryResponse>() {};
        return instantQueryRequestCreation(projectId, query, namespace, time, step).toEntity(localVarReturnType);
    }

    /**
     * Получить метрики в момент времени (Instant query)
     * Выполнить запрос значений метрик для заданного момента времени
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param query Выражение запроса на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/)
     * @param namespace Пространство имен сервиса VK Cloud
     * @param time Момент времени, для которого запрашиваются значения метрик. Формат — RFC3339 или Unix timestamp. Если параметр не указан, используется текущий момент времени сервера
     * @param step Диапазон времени перед моментом time, в котором будет проведен поиск значений метрик, если значения не будут найдены для момента time. Формат — [duration в языке PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/#time-durations)
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec instantQueryWithResponseSpec(String projectId, String query, String namespace, String time, String step) throws WebClientResponseException {
        return instantQueryRequestCreation(projectId, query, namespace, time, step);
    }
}
