package com.alihmzyv.ms2.service.impl;

import com.alihmzyv.ms2.dto.GreetingLogRequestDto;
import com.alihmzyv.ms2.dto.GreetingLogResponseDto;
import com.alihmzyv.ms2.entity.GreetingLog;
import com.alihmzyv.ms2.repository.GreetingLogRepository;
import com.alihmzyv.ms2.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GreetingServiceImpl implements GreetingService {
    private final GreetingLogRepository greetingLogRepository;
    private final ModelMapper modelMapper;

    @Override
    public GreetingLogResponseDto logGreeting(GreetingLogRequestDto greetingLogRequestDto) {
        GreetingLog greetingLog = modelMapper.map(greetingLogRequestDto, GreetingLog.class);
        GreetingLog greetingLogSaved = greetingLogRepository.save(greetingLog);
        return modelMapper.map(greetingLogSaved, GreetingLogResponseDto.class);
    }

    @Override
    public Long getCountOfAllGreetings() {
        return greetingLogRepository.count();
    }
}
