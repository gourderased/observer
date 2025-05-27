package com.dv.observer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/logs")
public class LogReceiveController {

    private final LogService logService;

    @PostMapping
    public ResponseEntity<String> receiveLog(@RequestBody LogReceiveRequestDto requestDto) {
        logService.save(requestDto);
        return ResponseEntity.ok("Log saved");
    }
}
