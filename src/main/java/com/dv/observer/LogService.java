package com.dv.observer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public LogResponseDto createLog(LogRequestDto requestDto) {
        String serializedLogData = "";
        try {
            serializedLogData = objectMapper.writeValueAsString(requestDto.getLogData());
        } catch (Exception e) {
            throw new RuntimeException("logData 직렬화 실패", e);
        }

        Log log = Log.builder()
            .notebookId(requestDto.getNotebookId())
            .deviceSerialNumber(requestDto.getDeviceSerialNumber())
            .jigName(requestDto.getJigName())
            .logSource(requestDto.getLogSource())
            .logData(serializedLogData)
            .build();

        Log savedLog = logRepository.save(log);
        return LogResponseDto.from(savedLog);
    }

    public List<LogResponseDto> getAllLogs() {
        return logRepository.findAll().stream()
            .map(LogResponseDto::from)
            .collect(Collectors.toList());
    }

    public LogResponseDto getLogById(Long id) {
        Log log = logRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Log not found: " + id));
        return LogResponseDto.from(log);
    }
}