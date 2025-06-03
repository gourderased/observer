package com.dv.observer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String notebookId;
    private String timestamp;

    @Embedded
    private DeviceStatus deviceStatus;

    private double gasConcentration;

    private int faultNumber;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt; // DB 저장 시간

    @Embeddable
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeviceStatus {
        private int alarm1;
        private int alarm2;
        private int fault;
        private int relay1;
        private int relay2;
        private int relay3;
        private int monitoringState;
    }
}