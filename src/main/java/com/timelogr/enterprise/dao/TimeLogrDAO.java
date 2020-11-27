package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Account;
import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;

import java.util.List;

public interface TimeLogrDAO {

    TimeLog saveLog(TimeLog timeLog);

    List<TimeLog> getAllLoggedTime();

    Project saveProject(Project project) throws Exception;

    List<Project> getAllProjects();

    Account saveAccount(Account account) throws Exception;

    List<Account> getAllAccounts();

}
