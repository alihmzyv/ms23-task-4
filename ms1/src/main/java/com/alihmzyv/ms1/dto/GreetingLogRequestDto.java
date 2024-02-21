package com.alihmzyv.ms1.dto;

import lombok.Data;

@Data
public class GreetingLogRequestDto {
    private Long occurredAtInEpochMillis;

    public static GreetingLogRequestDto of(Long occurredAtInEpochMillis) {
        GreetingLogRequestDto greetingLogRequest = new GreetingLogRequestDto();
        greetingLogRequest.setOccurredAtInEpochMillis(occurredAtInEpochMillis);
        return greetingLogRequest;
    }
}
