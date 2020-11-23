package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;

import java.util.List;

public interface TimeLogrDAO {

    TimeLog saveLog(TimeLog timeLog);

    List<TimeLog> getAllLoggedTime();

    Project saveProject(Project project);

    List<Project> getAllProjects();
}
