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

    @Autowired TimeLogRepository timeLogRepository;
    @Autowired ProjectRepository projectRepository;
    @Autowired AccountRepository accountRepository;


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
    public Project saveProject(Project project) throws Exception{
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

    @Override
    public Account saveAccount(Account account) throws Exception{
        Account newAccount = accountRepository.save(account);
        return newAccount;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> allAccounts = new ArrayList<>();
        Iterable<Account> accounts = accountRepository.findAll();
        for (Account account : accounts){
            allAccounts.add(account);
        }
        return allAccounts;
    }

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    @Override
    public List<Project> getClientProjects(int client) {
        return projectRepository.findByClientId(client);
    }

    @Override
    public List<TimeLog> getProjectLogs(String projectName) {
        return timeLogRepository.findByProject(projectName);
    }

    @Override
    public Project getProjectById(int projectId) {
        return projectRepository.findById(projectId).get();
    }


}
