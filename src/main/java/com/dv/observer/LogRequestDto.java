package com.dv.observer;

import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LogRequestDto {
    private String notebookId;
    private String deviceSerialNumber;
    private String jigName;
    private String logSource;
    private Map<String, Object> logData;
}
