package com.alihmzyv.ms1.resource;

import com.alihmzyv.ms1.dto.GreetingLogRequestDto;
import com.alihmzyv.ms1.dto.GreetingLogResponseDto;
import com.alihmzyv.ms1.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;


@RequiredArgsConstructor
@RequestMapping("/hello")
@RestController
public class GreetingResource {
    private final GreetingService greetingService;

    @GetMapping
    public String getGreeting() {
        greetingService.logGreeting(GreetingLogRequestDto.of(Instant.now().toEpochMilli()));
        return String.format("Hello from ms1 %s", greetingService.getCountOfAllGreetings());
    }
}
