package com.itmo.ipkn.team6.model;

import com.itmo.ipkn.team6.model.util.MetricThresholdType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "threshold_settings")
public class ThresholdSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetricThresholdType metricType;

    @Column(nullable = false)
    private String thresholdValue;

    @Column(nullable = false)
    private String vmId;

    @Column(nullable = false)
    private String projectId;

    @Column(nullable = false)
    private String namespace;

    @Column(nullable = false)
    private Long userId;

    @Override
    public String toString() {
        return "ThresholdSetting{\n" +
                "\tid=" + id + ",\n"+
                "\tmetricType=" + metricType + ",\n"+
                "\tthresholdValue='" + thresholdValue + ",\n"+
                "\tvmId='" + vmId + ",\n"+
                "\tprojectId='" + projectId + ",\n"+
                "\tnamespace='" + namespace + ",\n"+
                '}';
    }
}
