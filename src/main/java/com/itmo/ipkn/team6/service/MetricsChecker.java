package com.itmo.ipkn.team6.service;

public interface MetricsChecker {

    boolean checkRamMetric();
    boolean checkDiskMetric();
    boolean checkCpuMetric();
    boolean checkNetworkMetric();
}
