package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeLogRepository extends CrudRepository<TimeLog,Integer> {
    List<TimeLog> findByProject(String projectName);
}
