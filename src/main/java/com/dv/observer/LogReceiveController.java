package com.dv.observer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/logs")
@RequiredArgsConstructor
public class LogReceiveController {

    private final LogService logService;

    @PostMapping
    public void receiveLog(@RequestBody LogReceiveRequestDto dto) {
        logService.save(dto);
    }
}
