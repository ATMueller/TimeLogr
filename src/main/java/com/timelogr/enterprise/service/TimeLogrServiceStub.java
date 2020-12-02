package com.timelogr.enterprise.service;

import com.timelogr.enterprise.dao.TimeLogrDAO;
import com.timelogr.enterprise.dto.Account;
import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
