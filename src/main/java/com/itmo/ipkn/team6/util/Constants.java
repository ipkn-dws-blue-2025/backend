package com.itmo.ipkn.team6.util;

public interface Constants {

    interface VkCloudApi {

        String CPU_USAGE_PATTERN = "cpu_usage_user{vm_uuid=\"%s\", cpu=\"cpu-total\"}";
        String RAM_USAGE_PATTERN = "mem_used_percent{vm_uuid=\"%s\"}";
        String DISK_READ_USAGE_PATTERN = "sum(rate(diskio_read_bytes{vm_uuid=\"%s\"}))";
        String DISK_WRITE_USAGE_PATTERN = "sum(rate(diskio_write_bytes{vm_uuid=\"%s\"}))";
        String NETWORK_SEND_USAGE_PATTERN = "sum(rate(net_bytes_sent{vm_uuid=\"%s\"}))";
        String NETWORK_RECEIVED_USAGE_PATTERN = "sum(rate(net_bytes_recv{vm_uuid=\"%s\"}))";
    }

    interface Controller {
        String BASE_API_PATH = "/itmo/ipkn/team6/api";
        String AUTH = "/itmo/ipkn/team6/auth";
    }
}
