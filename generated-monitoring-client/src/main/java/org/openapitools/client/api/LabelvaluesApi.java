package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.Error;
import org.openapitools.client.model.ErrorBadRequest;
import org.openapitools.client.model.GetLabelValuesResponse;

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
public class LabelvaluesApi {
    private ApiClient apiClient;

    public LabelvaluesApi() {
        this(new ApiClient());
    }

    @Autowired
    public LabelvaluesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить значения метки с заданным именем
     * Получить значения метки с заданным именем. В качестве параметров могут быть указаны селекторы метрик и/или диапазон времени, из которых нужно читать значения метки
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param labelName Имя метки, значения которой нужно получить
     * @param namespace Пространство имен сервиса VK Cloud
     * @param match Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). Позволяет выбрать метрики, из которых будут считаны значения метки с заданным именем
     * @param start Начало диапазона времени, в котором нужно читать значения метки. Формат — RFC3339 или Unix timestamp
     * @param end Конец диапазона времени, в котором нужно читать значения метки. Формат — RFC3339 или Unix timestamp
     * @return GetLabelValuesResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec labelValuesRequestCreation(String projectId, String labelName, String namespace, List<String> match, String start, String end) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new WebClientResponseException("Missing the required parameter 'projectId' when calling labelValues", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'labelName' is set
        if (labelName == null) {
            throw new WebClientResponseException("Missing the required parameter 'labelName' when calling labelValues", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("project_id", projectId);
        pathParams.put("label_name", labelName);

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

        ParameterizedTypeReference<GetLabelValuesResponse> localVarReturnType = new ParameterizedTypeReference<GetLabelValuesResponse>() {};
        return apiClient.invokeAPI("/{project_id}/label/{label_name}/values", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить значения метки с заданным именем
     * Получить значения метки с заданным именем. В качестве параметров могут быть указаны селекторы метрик и/или диапазон времени, из которых нужно читать значения метки
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param labelName Имя метки, значения которой нужно получить
     * @param namespace Пространство имен сервиса VK Cloud
     * @param match Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). Позволяет выбрать метрики, из которых будут считаны значения метки с заданным именем
     * @param start Начало диапазона времени, в котором нужно читать значения метки. Формат — RFC3339 или Unix timestamp
     * @param end Конец диапазона времени, в котором нужно читать значения метки. Формат — RFC3339 или Unix timestamp
     * @return GetLabelValuesResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetLabelValuesResponse> labelValues(String projectId, String labelName, String namespace, List<String> match, String start, String end) throws WebClientResponseException {
        ParameterizedTypeReference<GetLabelValuesResponse> localVarReturnType = new ParameterizedTypeReference<GetLabelValuesResponse>() {};
        return labelValuesRequestCreation(projectId, labelName, namespace, match, start, end).bodyToMono(localVarReturnType);
    }

    /**
     * Получить значения метки с заданным именем
     * Получить значения метки с заданным именем. В качестве параметров могут быть указаны селекторы метрик и/или диапазон времени, из которых нужно читать значения метки
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param labelName Имя метки, значения которой нужно получить
     * @param namespace Пространство имен сервиса VK Cloud
     * @param match Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). Позволяет выбрать метрики, из которых будут считаны значения метки с заданным именем
     * @param start Начало диапазона времени, в котором нужно читать значения метки. Формат — RFC3339 или Unix timestamp
     * @param end Конец диапазона времени, в котором нужно читать значения метки. Формат — RFC3339 или Unix timestamp
     * @return ResponseEntity&lt;GetLabelValuesResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetLabelValuesResponse>> labelValuesWithHttpInfo(String projectId, String labelName, String namespace, List<String> match, String start, String end) throws WebClientResponseException {
        ParameterizedTypeReference<GetLabelValuesResponse> localVarReturnType = new ParameterizedTypeReference<GetLabelValuesResponse>() {};
        return labelValuesRequestCreation(projectId, labelName, namespace, match, start, end).toEntity(localVarReturnType);
    }

    /**
     * Получить значения метки с заданным именем
     * Получить значения метки с заданным именем. В качестве параметров могут быть указаны селекторы метрик и/или диапазон времени, из которых нужно читать значения метки
     * <p><b>200</b> - Запрос выполнен успешно
     * <p><b>400</b> - Отсутствуют или неверно заданы параметры запроса
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Ошибка авторизации
     * <p><b>500</b> - Внутренняя ошибка сервера
     * <p><b>502</b> - Неверный шлюз (bad gateway)
     * <p><b>503</b> - Сервис недоступен
     * @param projectId Идентификатор проекта (PID) в Openstack
     * @param labelName Имя метки, значения которой нужно получить
     * @param namespace Пространство имен сервиса VK Cloud
     * @param match Выражение для фильтра на языке [PromQL](https://prometheus.io/docs/prometheus/latest/querying/basics/). Позволяет выбрать метрики, из которых будут считаны значения метки с заданным именем
     * @param start Начало диапазона времени, в котором нужно читать значения метки. Формат — RFC3339 или Unix timestamp
     * @param end Конец диапазона времени, в котором нужно читать значения метки. Формат — RFC3339 или Unix timestamp
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec labelValuesWithResponseSpec(String projectId, String labelName, String namespace, List<String> match, String start, String end) throws WebClientResponseException {
        return labelValuesRequestCreation(projectId, labelName, namespace, match, start, end);
    }
}
