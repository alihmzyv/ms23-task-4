package com.alihmzyv.ms1.service;

import com.alihmzyv.ms1.dto.GreetingLogRequestDto;
import com.alihmzyv.ms1.dto.GreetingLogResponseDto;

public interface GreetingService {
    GreetingLogResponseDto logGreeting(GreetingLogRequestDto greetingLogRequestDto);

    Long getCountOfAllGreetings();
}
