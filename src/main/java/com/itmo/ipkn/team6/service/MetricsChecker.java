package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.model.util.MetricThresholdType;

public interface MetricsChecker {

    void checkMetric(MetricThresholdType metric, Long userId);
}
