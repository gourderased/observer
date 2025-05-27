package com.dv.observer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    public void save(LogReceiveRequestDto dto) {
        LogEntity entity = LogEntity.builder()
            .notebookId(dto.getNotebookId())
            .timestamp(dto.getTimestamp())
            .alarm1(dto.getDeviceStatus().getAlarm1())
            .alarm2(dto.getDeviceStatus().getAlarm2())
            .fault(dto.getDeviceStatus().getFault())
            .relay1(dto.getDeviceStatus().getRelay1())
            .relay2(dto.getDeviceStatus().getRelay2())
            .relay3(dto.getDeviceStatus().getRelay3())
            .monitoringState(dto.getDeviceStatus().getMonitoringState())
            .gasConcentration(dto.getGasConcentration())
            .faultNumber(dto.getFaultNumber())
            .build();

        logRepository.save(entity);
    }

}
