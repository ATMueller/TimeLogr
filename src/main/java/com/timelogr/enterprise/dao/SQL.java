package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Account;
import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("timelogrDAO")
public class SQL implements TimeLogrDAO {

    @Autowired
    TimeLogRepository timeLogRepository;
    ProjectRepository projectRepository;
    AccountRepository accountRepository;


    @Override
    public TimeLog saveLog(TimeLog timeLog) {
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

    @Override
    public Project saveProject(Project project) {
        Project savedProject = projectRepository.save(project);
        return savedProject;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> allProjects = new ArrayList<>();
        Iterable<Project> projects = projectRepository.findAll();
        for (Project project : projects) {
            allProjects.add(project);
        }
        return allProjects;
    }
}
