package com.alihmzyv.ms1.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        AbstractConverter<Long, LocalDateTime> epochMillisToLocalDateTimeConverter = epochMillisToLocalDateTimeConverter();
        AbstractConverter<LocalDateTime, Long> localDateTimeToLongConverter = localDateTimeToLongConverter();
        modelMapper.addConverter(epochMillisToLocalDateTimeConverter);
        modelMapper.addConverter(localDateTimeToLongConverter);
        return modelMapper;
    }

    @Bean
    public AbstractConverter<Long, LocalDateTime> epochMillisToLocalDateTimeConverter() {
        return new AbstractConverter<>() {
            @Override
            protected LocalDateTime convert(Long epochMillis) {
                return Instant.ofEpochMilli(epochMillis).atZone(ZoneId.of("UTC")).toLocalDateTime();
            }
        };
    }

    @Bean
    public AbstractConverter<LocalDateTime, Long> localDateTimeToLongConverter() {
        return new AbstractConverter<>() {
            @Override
            protected Long convert(LocalDateTime time) {
                return time.toInstant(ZoneOffset.UTC).toEpochMilli();
            }
        };
    }
}
