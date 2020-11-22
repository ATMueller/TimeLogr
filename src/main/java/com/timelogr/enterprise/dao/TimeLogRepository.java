package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.TimeLog;
import org.springframework.data.repository.CrudRepository;

public interface TimeLogRepository extends CrudRepository<TimeLog,Integer> {
}
