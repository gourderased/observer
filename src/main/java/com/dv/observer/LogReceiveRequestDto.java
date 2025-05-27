package com.dv.observer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LogReceiveRequestDto {
    private String notebookId;
    private String timestamp;
    private DeviceStatus deviceStatus;
    private double gasConcentration;
    private int faultNumber;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
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
