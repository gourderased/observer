package com.dv.observer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String notebookId;
    private String timestamp;

    private int alarm1;
    private int alarm2;
    private int fault;
    private int relay1;
    private int relay2;
    private int relay3;

    private int monitoringState;

    private double gasConcentration;
    private int faultNumber;
}
