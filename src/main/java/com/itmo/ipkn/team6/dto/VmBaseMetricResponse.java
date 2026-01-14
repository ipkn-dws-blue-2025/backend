package com.itmo.ipkn.team6.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class VmBaseMetricResponse {

    private MonitoringData data;

    @Data
    public static class MonitoringData {

        private List<MonitoringResult> result;

    }

    @Data
    public static class MonitoringResult {

        private Metric metric;
        private List<Object> value;

    }

    @Data
    public static class Metric {

        @JsonAlias("__name__")
        private String name;

    }

}


