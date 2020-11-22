package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.TimeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("timelogrDAO")
public class SQL implements TimeLogrDAO {

    @Autowired
    TimeLogRepository timeLogRepository;

    @Override
    public TimeLog save(TimeLog timeLog) {
        TimeLog savedtimelog = timeLogRepository.save(timeLog);
        return savedtimelog;
    }

    @Override
    public List<TimeLog> getAllLoggedTime() {
        List<TimeLog> totalLogs = new ArrayList<>();
        Iterable<TimeLog> logs = timeLogRepository.findAll();
        for (TimeLog timeLog : logs) {
            totalLogs.add(timeLog);
        }
        return totalLogs;
    }
}
