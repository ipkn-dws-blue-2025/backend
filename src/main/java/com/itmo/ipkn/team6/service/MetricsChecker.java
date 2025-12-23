package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.model.User;
import com.itmo.ipkn.team6.model.util.MetricThresholdType;

public interface MetricsChecker {

    void checkMetric(MetricThresholdType metric, User user);
}
