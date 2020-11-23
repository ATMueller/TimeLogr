package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class TimeLogrDAOstub implements TimeLogrDAO {

    HashMap<Integer, TimeLog> allTimeLogs = new HashMap<>();
    @Override
    public TimeLog saveLog(TimeLog timeLog) {
        Integer timeLogID = timeLog.getId();
        allTimeLogs.put(timeLogID, timeLog);
        return timeLog;
    }

    @Override
    public List<TimeLog> getAllLoggedTime() {
        List<TimeLog> allLogs = new ArrayList<>(allTimeLogs.values());
        return allLogs;
    }

    @Override
    public Project saveProject(Project project) {
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        return null;
    }
}
