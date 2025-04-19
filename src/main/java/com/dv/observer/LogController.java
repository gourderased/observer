package com.dv.observer;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @PostMapping
    public ResponseEntity<LogResponseDto> createLog(@RequestBody LogRequestDto requestDto) {
        LogResponseDto savedLog = logService.createLog(requestDto);
        return ResponseEntity.ok(savedLog);
    }

    @GetMapping
    public ResponseEntity<List<LogResponseDto>> getAllLogs() {
        List<LogResponseDto> logs = logService.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogResponseDto> getLogById(@PathVariable Long id) {
        LogResponseDto log = logService.getLogById(id);
        return ResponseEntity.ok(log);
    }
}
