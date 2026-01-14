package com.itmo.ipkn.team6.dto.rest;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VmMonitoringResponse {

    private String status;
    private DataContainer data;

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataContainer {
        private String resultType;
        private List<ResultItem> result;
    }

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultItem {
        private Map<String, String> metric;

        private List<ValueItem> values;

        @Data
        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class ValueItem {
            private long timestamp;
            private String value;
        }
    }
}
