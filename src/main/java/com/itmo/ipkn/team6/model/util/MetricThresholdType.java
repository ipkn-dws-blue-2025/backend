package com.itmo.ipkn.team6.model.util;

import com.itmo.ipkn.team6.util.Constants;
import lombok.Getter;

@Getter
public enum MetricThresholdType {

    CPU(Constants.VkCloudApi.CPU_USAGE_PATTERN),
    RAM(Constants.VkCloudApi.RAM_USAGE_PATTERN),
    DISK_READ(Constants.VkCloudApi.DISK_READ_USAGE_PATTERN),
    DISK_WRITE(Constants.VkCloudApi.DISK_WRITE_USAGE_PATTERN),
    NETWORK_SEND(Constants.VkCloudApi.NETWORK_SEND_USAGE_PATTERN),
    NETWORK_RECEIVE(Constants.VkCloudApi.NETWORK_RECEIVED_USAGE_PATTERN),;

    private final String pattern;

    MetricThresholdType(String pattern) {
        this.pattern = pattern;
    }
}
