package com.itmo.ipkn.team6.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.jmx.support.MetricType;

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
    private MetricType metricType; // CPU, RAM и т.д.

    @Column(nullable = false)
    private Double thresholdValue; // Значение порога (например, 85.0)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
