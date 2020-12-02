package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Account;
import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TimeLogrDAO {

    TimeLog saveLog(TimeLog timeLog);

    List<TimeLog> getAllLoggedTime();

    Project saveProject(Project project) throws Exception;

    List<Project> getAllProjects();

    Account saveAccount(Account account) throws Exception;

    List<Account> getAllAccounts();

    Account findAccountByEmail(String email);

    Account findAccountById(Integer id);

    Project findProjectById(Integer id);

}
