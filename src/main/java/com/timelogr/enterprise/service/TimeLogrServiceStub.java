package com.timelogr.enterprise.service;

import com.timelogr.enterprise.dao.TimeLogrDAO;
import com.timelogr.enterprise.dto.Employee;
import com.timelogr.enterprise.dto.TimeLog;
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
    public TimeLog save(TimeLog timeLog) {
        return timelogrDAO.save(timeLog);
    }

    @Override
    public List<TimeLog> getAllLoggedTime() {
        return timelogrDAO.getAllLoggedTime();
    }

    @Override
    public Employee saveEmployee(Employee employee) { return timelogrDAO.saveEmployee(employee);}

    @Override
    public List<Employee> getAllEmployees() { return timelogrDAO.getAllEmployees(); }
}
