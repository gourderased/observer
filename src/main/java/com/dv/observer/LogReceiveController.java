package com.dv.observer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogReceiveController {

    @PostMapping
    public ResponseEntity<String> receiveLog(@RequestBody LogReceiveRequestDto requestDto) {
        System.out.println("Received log: " + requestDto);
        return ResponseEntity.ok("Log received");
    }
}
