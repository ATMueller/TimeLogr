package com.timelogr.enterprise.service;

import com.timelogr.enterprise.dao.TimeLogrDAO;
import com.timelogr.enterprise.dto.Account;
import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeLogrServiceStub implements TimeLogrService {

    @Autowired
    private TimeLogrDAO timelogrDAO;

    public TimeLogrServiceStub(){

    }

    public TimeLogrServiceStub(TimeLogrDAO timelogrDAO) {
        this.timelogrDAO = timelogrDAO;
    }

    @Override
    public TimeLog saveLog(TimeLog timeLog) {
        return timelogrDAO.saveLog(timeLog);
    }

    @Override
    public List<TimeLog> getAllLoggedTime() {
        return timelogrDAO.getAllLoggedTime();
    }

    @SneakyThrows
    @Override
    public Project saveProject(Project project) {
        return timelogrDAO.saveProject(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return timelogrDAO.getAllProjects();
    }

    @SneakyThrows
    @Override
    public Account saveAccount(Account account) { return timelogrDAO.saveAccount(account); }

    @Override
    public List<Account> getAllAccounts() {
        return timelogrDAO.getAllAccounts();
    }

    @Override
    public Account findAccountByEmail(String email) { return timelogrDAO.findAccountByEmail(email); }

    @Override
    public Account findAccountById(Integer id) {
        return timelogrDAO.findAccountById(id);
    }

    @Override
    public Project findProjectById(Integer id) {
        return timelogrDAO.findProjectById(id);
    }

    @Override
    public List<Project> getClientProjects(int client) {
        return timelogrDAO.getClientProjects(client);
    }

    @Override
    public BigDecimal sumProjectLogsTime(Project project) {
            BigDecimal time = new BigDecimal("0");
//        double cost = 0;

        // double[] ans = new double[2];

        Iterable<TimeLog> logs = timelogrDAO.getProjectLogs(project.getId());
        for (TimeLog timeLog : logs) {
            time = time.add(BigDecimal.valueOf(timeLog.getDuration()));
            System.out.println("Time: " +time);
        }
//        ans[0] = time;
//        double wage = project.getWage().doubleValue();
//        cost = time * wage;
//        ans[1] = cost;
        return time;
    }

    @Override
    public BigDecimal sumProjectLogsCost(Project project) {
        BigDecimal totalTime = sumProjectLogsTime(project);
        BigDecimal cost = new BigDecimal("0.00");
        cost = project.getWage();
        cost = cost.multiply(totalTime);
        return cost;
    }


    @Override
    public Project getProjectById(int projectId) {
        return timelogrDAO.getProjectById(projectId);
    }


}
