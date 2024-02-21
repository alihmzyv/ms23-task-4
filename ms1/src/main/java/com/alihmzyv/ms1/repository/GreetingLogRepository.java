package com.alihmzyv.ms1.repository;

import com.alihmzyv.ms1.entity.GreetingLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingLogRepository extends CrudRepository<GreetingLog, Long> {
}
