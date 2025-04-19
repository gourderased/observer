package com.dv.observer;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LogResponseDto {
    private Long id;
    private LocalDateTime timestamp;
    private String notebookId;
    private String deviceSerialNumber;
    private String jigName;
    private String logSource;
    private String logData;

    public static LogResponseDto from(Log log) {
        return LogResponseDto.builder()
            .id(log.getId())
            .timestamp(log.getTimestamp())
            .notebookId(log.getNotebookId())
            .deviceSerialNumber(log.getDeviceSerialNumber())
            .jigName(log.getJigName())
            .logSource(log.getLogSource())
            .logData(log.getLogData())
            .build();
    }
}