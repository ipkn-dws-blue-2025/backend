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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String vmId;

    @Column(nullable = false)
    private String projectId;

    @Column(nullable = false)
    private String namespace;
}
