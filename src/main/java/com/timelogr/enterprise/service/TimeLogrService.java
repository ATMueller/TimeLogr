package com.timelogr.enterprise.service;

import com.timelogr.enterprise.dto.Employee;
import com.timelogr.enterprise.dto.TimeLog;

import java.util.List;

public interface TimeLogrService {

    TimeLog save(TimeLog timeLog);

    List<TimeLog> getAllLoggedTime();

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();
}
