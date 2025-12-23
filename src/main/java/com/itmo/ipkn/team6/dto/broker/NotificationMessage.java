package com.itmo.ipkn.team6.dto.broker;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationMessage {

    private long userId;
    private String instantValue;
    private String userValue;
    private String metric;
    private long timestamp;
}
