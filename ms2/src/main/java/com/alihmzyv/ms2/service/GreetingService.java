package com.alihmzyv.ms2.service;

import com.alihmzyv.ms2.dto.GreetingLogRequestDto;
import com.alihmzyv.ms2.dto.GreetingLogResponseDto;

public interface GreetingService {
    GreetingLogResponseDto logGreeting(GreetingLogRequestDto greetingLogRequestDto);

    Long getCountOfAllGreetings();
}
