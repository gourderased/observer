package com.dv.observer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    public void save(LogReceiveRequestDto dto) {
        Log log = Log.builder()
            .notebookId(dto.getNotebookId())
            .timestamp(dto.getTimestamp())
            .gasConcentration(dto.getGasConcentration())
            .faultNumber(dto.getFaultNumber())
            .deviceStatus(new Log.DeviceStatus(
                dto.getDeviceStatus().getAlarm1(),
                dto.getDeviceStatus().getAlarm2(),
                dto.getDeviceStatus().getFault(),
                dto.getDeviceStatus().getRelay1(),
                dto.getDeviceStatus().getRelay2(),
                dto.getDeviceStatus().getRelay3(),
                dto.getDeviceStatus().getMonitoringState()
            ))
            .build();
        logRepository.save(log);
    }

}
