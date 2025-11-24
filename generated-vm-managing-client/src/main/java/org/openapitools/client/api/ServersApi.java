package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetListServerDetails;
import org.openapitools.client.model.GetServerDetails;
import org.openapitools.client.model.GetServers;
import org.openapitools.client.model.ServerUpdate;
import org.openapitools.client.model.ServersPostRequest;

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
public class ServersApi {
    private ApiClient apiClient;

    public ServersApi() {
        this(new ApiClient());
    }

    @Autowired
    public ServersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получить список ВМ с подробной информацией
     * 
     * <p><b>200</b> - ОК
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param sortKey Атрибут, по которому сортируются ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param changesSince Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @param image Фильтр по идентификатору образа
     * @param flavor Фильтр по идентификатору шаблона конфигурации ВМ
     * @param name Фильтр по имени ВМ
     * @param status Фильтр по статусу ВМ
     * @param ip Фильтр по IP-адресу версии 4
     * @param reservationId Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
     * @param ip6 Фильтр по IP-адресу версии 6
     * @param tags Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
     * @param tagsAny Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTags Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTagsAny Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
     * @param changesBefore Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @return GetListServerDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversDetailGetRequestCreation(Integer limit, String marker, String sortKey, String sortDir, String changesSince, String image, String flavor, String name, String status, String ip, String reservationId, String ip6, String tags, String tagsAny, String notTags, String notTagsAny, String changesBefore) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "marker", marker));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_key", sortKey));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_dir", sortDir));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "changes-since", changesSince));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "image", image));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flavor", flavor));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "ip", ip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reservation_id", reservationId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "ip6", ip6));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tags", tags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tags-any", tagsAny));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "not-tags", notTags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "not-tags-any", notTagsAny));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "changes-before", changesBefore));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetListServerDetails> localVarReturnType = new ParameterizedTypeReference<GetListServerDetails>() {};
        return apiClient.invokeAPI("/servers/detail", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список ВМ с подробной информацией
     * 
     * <p><b>200</b> - ОК
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param sortKey Атрибут, по которому сортируются ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param changesSince Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @param image Фильтр по идентификатору образа
     * @param flavor Фильтр по идентификатору шаблона конфигурации ВМ
     * @param name Фильтр по имени ВМ
     * @param status Фильтр по статусу ВМ
     * @param ip Фильтр по IP-адресу версии 4
     * @param reservationId Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
     * @param ip6 Фильтр по IP-адресу версии 6
     * @param tags Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
     * @param tagsAny Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTags Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTagsAny Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
     * @param changesBefore Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @return GetListServerDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetListServerDetails> serversDetailGet(Integer limit, String marker, String sortKey, String sortDir, String changesSince, String image, String flavor, String name, String status, String ip, String reservationId, String ip6, String tags, String tagsAny, String notTags, String notTagsAny, String changesBefore) throws WebClientResponseException {
        ParameterizedTypeReference<GetListServerDetails> localVarReturnType = new ParameterizedTypeReference<GetListServerDetails>() {};
        return serversDetailGetRequestCreation(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore).bodyToMono(localVarReturnType);
    }

    /**
     * Получить список ВМ с подробной информацией
     * 
     * <p><b>200</b> - ОК
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param sortKey Атрибут, по которому сортируются ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param changesSince Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @param image Фильтр по идентификатору образа
     * @param flavor Фильтр по идентификатору шаблона конфигурации ВМ
     * @param name Фильтр по имени ВМ
     * @param status Фильтр по статусу ВМ
     * @param ip Фильтр по IP-адресу версии 4
     * @param reservationId Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
     * @param ip6 Фильтр по IP-адресу версии 6
     * @param tags Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
     * @param tagsAny Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTags Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTagsAny Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
     * @param changesBefore Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @return ResponseEntity&lt;GetListServerDetails&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetListServerDetails>> serversDetailGetWithHttpInfo(Integer limit, String marker, String sortKey, String sortDir, String changesSince, String image, String flavor, String name, String status, String ip, String reservationId, String ip6, String tags, String tagsAny, String notTags, String notTagsAny, String changesBefore) throws WebClientResponseException {
        ParameterizedTypeReference<GetListServerDetails> localVarReturnType = new ParameterizedTypeReference<GetListServerDetails>() {};
        return serversDetailGetRequestCreation(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore).toEntity(localVarReturnType);
    }

    /**
     * Получить список ВМ с подробной информацией
     * 
     * <p><b>200</b> - ОК
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param sortKey Атрибут, по которому сортируются ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param changesSince Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @param image Фильтр по идентификатору образа
     * @param flavor Фильтр по идентификатору шаблона конфигурации ВМ
     * @param name Фильтр по имени ВМ
     * @param status Фильтр по статусу ВМ
     * @param ip Фильтр по IP-адресу версии 4
     * @param reservationId Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
     * @param ip6 Фильтр по IP-адресу версии 6
     * @param tags Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
     * @param tagsAny Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTags Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTagsAny Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
     * @param changesBefore Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversDetailGetWithResponseSpec(Integer limit, String marker, String sortKey, String sortDir, String changesSince, String image, String flavor, String name, String status, String ip, String reservationId, String ip6, String tags, String tagsAny, String notTags, String notTagsAny, String changesBefore) throws WebClientResponseException {
        return serversDetailGetRequestCreation(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore);
    }
    /**
     * Получить список ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param sortKey Атрибут, по которому сортируются ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param changesSince Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @param image Фильтр по идентификатору образа
     * @param flavor Фильтр по идентификатору шаблона конфигурации ВМ
     * @param name Фильтр по имени ВМ
     * @param status Фильтр по статусу ВМ
     * @param ip Фильтр по IP-адресу версии 4
     * @param reservationId Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
     * @param ip6 Фильтр по IP-адресу версии 6
     * @param tags Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
     * @param tagsAny Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTags Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTagsAny Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
     * @param changesBefore Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @return GetServers
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversGetRequestCreation(Integer limit, String marker, String sortKey, String sortDir, String changesSince, String image, String flavor, String name, String status, String ip, String reservationId, String ip6, String tags, String tagsAny, String notTags, String notTagsAny, String changesBefore) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "marker", marker));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_key", sortKey));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_dir", sortDir));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "changes-since", changesSince));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "image", image));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flavor", flavor));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "ip", ip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reservation_id", reservationId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "ip6", ip6));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tags", tags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tags-any", tagsAny));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "not-tags", notTags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "not-tags-any", notTagsAny));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "changes-before", changesBefore));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetServers> localVarReturnType = new ParameterizedTypeReference<GetServers>() {};
        return apiClient.invokeAPI("/servers", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить список ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param sortKey Атрибут, по которому сортируются ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param changesSince Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @param image Фильтр по идентификатору образа
     * @param flavor Фильтр по идентификатору шаблона конфигурации ВМ
     * @param name Фильтр по имени ВМ
     * @param status Фильтр по статусу ВМ
     * @param ip Фильтр по IP-адресу версии 4
     * @param reservationId Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
     * @param ip6 Фильтр по IP-адресу версии 6
     * @param tags Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
     * @param tagsAny Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTags Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTagsAny Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
     * @param changesBefore Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @return GetServers
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetServers> serversGet(Integer limit, String marker, String sortKey, String sortDir, String changesSince, String image, String flavor, String name, String status, String ip, String reservationId, String ip6, String tags, String tagsAny, String notTags, String notTagsAny, String changesBefore) throws WebClientResponseException {
        ParameterizedTypeReference<GetServers> localVarReturnType = new ParameterizedTypeReference<GetServers>() {};
        return serversGetRequestCreation(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore).bodyToMono(localVarReturnType);
    }

    /**
     * Получить список ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param sortKey Атрибут, по которому сортируются ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param changesSince Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @param image Фильтр по идентификатору образа
     * @param flavor Фильтр по идентификатору шаблона конфигурации ВМ
     * @param name Фильтр по имени ВМ
     * @param status Фильтр по статусу ВМ
     * @param ip Фильтр по IP-адресу версии 4
     * @param reservationId Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
     * @param ip6 Фильтр по IP-адресу версии 6
     * @param tags Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
     * @param tagsAny Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTags Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTagsAny Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
     * @param changesBefore Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @return ResponseEntity&lt;GetServers&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetServers>> serversGetWithHttpInfo(Integer limit, String marker, String sortKey, String sortDir, String changesSince, String image, String flavor, String name, String status, String ip, String reservationId, String ip6, String tags, String tagsAny, String notTags, String notTagsAny, String changesBefore) throws WebClientResponseException {
        ParameterizedTypeReference<GetServers> localVarReturnType = new ParameterizedTypeReference<GetServers>() {};
        return serversGetRequestCreation(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore).toEntity(localVarReturnType);
    }

    /**
     * Получить список ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * @param limit Максимальное количество элементов, возвращаемых в одном ответе. В последующих запросах указывайте в параметре &#x60;&#x60;marker&#x60;&#x60; идентификатор последнего элемента из ответа, чтобы получить следующий набор элементов
     * @param marker Маркер пагинации для больших наборов данных
     * @param sortKey Атрибут, по которому сортируются ВМ в ответе
     * @param sortDir Направление сортировки. Возможные значения:  &#x60;&#x60;asc&#x60;&#x60; — по возрастанию;  &#x60;&#x60;desc&#x60;&#x60; — по убыванию
     * @param changesSince Фильтр по дате и времени, когда ВМ последний раз меняла статус. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @param image Фильтр по идентификатору образа
     * @param flavor Фильтр по идентификатору шаблона конфигурации ВМ
     * @param name Фильтр по имени ВМ
     * @param status Фильтр по статусу ВМ
     * @param ip Фильтр по IP-адресу версии 4
     * @param reservationId Идентификатор резервирования, возвращаемый множественным вызовом создания ВМ
     * @param ip6 Фильтр по IP-адресу версии 6
     * @param tags Фильтр по тегам. Возвращает ВМ, соответствующие всем тегам в списке. Теги в запросе должны быть разделены запятой
     * @param tagsAny Фильтр по тегам. Возвращает ВМ, соответствующие любому тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTags Фильтр по тегам. Возвращает ВМ, которые не соответствуют ни одному тегу в списке. Теги в запросе должны быть разделены запятой
     * @param notTagsAny Фильтр по тегам. Возвращает ВМ, которые не соответствуют любому тегу в списке. Теги в запросе должны быть разделены запятой 
     * @param changesBefore Фильтр по дате и времени последнего изменения ВМ. Формат: &#x60;&#x60;CCYY-MM-DDThh:mm:ss±hh:mm&#x60;&#x60;. Значение &#x60;&#x60;±hh:mm&#x60;&#x60; указывает на часовой пояс (смещение от UTC)
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversGetWithResponseSpec(Integer limit, String marker, String sortKey, String sortDir, String changesSince, String image, String flavor, String name, String status, String ip, String reservationId, String ip6, String tags, String tagsAny, String notTags, String notTagsAny, String changesBefore) throws WebClientResponseException {
        return serversGetRequestCreation(limit, marker, sortKey, sortDir, changesSince, image, flavor, name, status, ip, reservationId, ip6, tags, tagsAny, notTags, notTagsAny, changesBefore);
    }
    /**
     * Создать новую ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * <p><b>413</b> - Превышен размер запроса
     * @param serversPostRequest Объект данных новой ВМ в формате JSON
     * @return GetServerDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversPostRequestCreation(ServersPostRequest serversPostRequest) throws WebClientResponseException {
        Object postBody = serversPostRequest;
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

        ParameterizedTypeReference<GetServerDetails> localVarReturnType = new ParameterizedTypeReference<GetServerDetails>() {};
        return apiClient.invokeAPI("/servers", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Создать новую ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * <p><b>413</b> - Превышен размер запроса
     * @param serversPostRequest Объект данных новой ВМ в формате JSON
     * @return GetServerDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetServerDetails> serversPost(ServersPostRequest serversPostRequest) throws WebClientResponseException {
        ParameterizedTypeReference<GetServerDetails> localVarReturnType = new ParameterizedTypeReference<GetServerDetails>() {};
        return serversPostRequestCreation(serversPostRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Создать новую ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * <p><b>413</b> - Превышен размер запроса
     * @param serversPostRequest Объект данных новой ВМ в формате JSON
     * @return ResponseEntity&lt;GetServerDetails&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetServerDetails>> serversPostWithHttpInfo(ServersPostRequest serversPostRequest) throws WebClientResponseException {
        ParameterizedTypeReference<GetServerDetails> localVarReturnType = new ParameterizedTypeReference<GetServerDetails>() {};
        return serversPostRequestCreation(serversPostRequest).toEntity(localVarReturnType);
    }

    /**
     * Создать новую ВМ
     * 
     * <p><b>202</b> - ОК
     * <p><b>400</b> - Некорректный запрос
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * <p><b>413</b> - Превышен размер запроса
     * @param serversPostRequest Объект данных новой ВМ в формате JSON
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversPostWithResponseSpec(ServersPostRequest serversPostRequest) throws WebClientResponseException {
        return serversPostRequestCreation(serversPostRequest);
    }
    /**
     * Удалить ВМ
     * 
     * <p><b>204</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdDeleteRequestCreation(String serverId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/servers/{server_id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Удалить ВМ
     * 
     * <p><b>204</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> serversServerIdDelete(String serverId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return serversServerIdDeleteRequestCreation(serverId).bodyToMono(localVarReturnType);
    }

    /**
     * Удалить ВМ
     * 
     * <p><b>204</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> serversServerIdDeleteWithHttpInfo(String serverId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return serversServerIdDeleteRequestCreation(serverId).toEntity(localVarReturnType);
    }

    /**
     * Удалить ВМ
     * 
     * <p><b>204</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * <p><b>409</b> - Конфликт
     * @param serverId Идентификатор ВМ
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdDeleteWithResponseSpec(String serverId) throws WebClientResponseException {
        return serversServerIdDeleteRequestCreation(serverId);
    }
    /**
     * Получить информацию о ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return GetServerDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdGetRequestCreation(String serverId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<GetServerDetails> localVarReturnType = new ParameterizedTypeReference<GetServerDetails>() {};
        return apiClient.invokeAPI("/servers/{server_id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Получить информацию о ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return GetServerDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetServerDetails> serversServerIdGet(String serverId) throws WebClientResponseException {
        ParameterizedTypeReference<GetServerDetails> localVarReturnType = new ParameterizedTypeReference<GetServerDetails>() {};
        return serversServerIdGetRequestCreation(serverId).bodyToMono(localVarReturnType);
    }

    /**
     * Получить информацию о ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ResponseEntity&lt;GetServerDetails&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetServerDetails>> serversServerIdGetWithHttpInfo(String serverId) throws WebClientResponseException {
        ParameterizedTypeReference<GetServerDetails> localVarReturnType = new ParameterizedTypeReference<GetServerDetails>() {};
        return serversServerIdGetRequestCreation(serverId).toEntity(localVarReturnType);
    }

    /**
     * Получить информацию о ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdGetWithResponseSpec(String serverId) throws WebClientResponseException {
        return serversServerIdGetRequestCreation(serverId);
    }
    /**
     * Обновить информацию о ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @param serverUpdate The serverUpdate parameter
     * @return GetServerDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec serversServerIdPutRequestCreation(String serverId, ServerUpdate serverUpdate) throws WebClientResponseException {
        Object postBody = serverUpdate;
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverId' when calling serversServerIdPut", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'serverUpdate' is set
        if (serverUpdate == null) {
            throw new WebClientResponseException("Missing the required parameter 'serverUpdate' when calling serversServerIdPut", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetServerDetails> localVarReturnType = new ParameterizedTypeReference<GetServerDetails>() {};
        return apiClient.invokeAPI("/servers/{server_id}", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Обновить информацию о ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @param serverUpdate The serverUpdate parameter
     * @return GetServerDetails
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetServerDetails> serversServerIdPut(String serverId, ServerUpdate serverUpdate) throws WebClientResponseException {
        ParameterizedTypeReference<GetServerDetails> localVarReturnType = new ParameterizedTypeReference<GetServerDetails>() {};
        return serversServerIdPutRequestCreation(serverId, serverUpdate).bodyToMono(localVarReturnType);
    }

    /**
     * Обновить информацию о ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @param serverUpdate The serverUpdate parameter
     * @return ResponseEntity&lt;GetServerDetails&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetServerDetails>> serversServerIdPutWithHttpInfo(String serverId, ServerUpdate serverUpdate) throws WebClientResponseException {
        ParameterizedTypeReference<GetServerDetails> localVarReturnType = new ParameterizedTypeReference<GetServerDetails>() {};
        return serversServerIdPutRequestCreation(serverId, serverUpdate).toEntity(localVarReturnType);
    }

    /**
     * Обновить информацию о ВМ
     * 
     * <p><b>200</b> - ОК
     * <p><b>400</b> - ОК
     * <p><b>401</b> - Ошибка аутентификации
     * <p><b>403</b> - Недостаточно прав
     * <p><b>404</b> - Объект не найден
     * @param serverId Идентификатор ВМ
     * @param serverUpdate The serverUpdate parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec serversServerIdPutWithResponseSpec(String serverId, ServerUpdate serverUpdate) throws WebClientResponseException {
        return serversServerIdPutRequestCreation(serverId, serverUpdate);
    }
}
