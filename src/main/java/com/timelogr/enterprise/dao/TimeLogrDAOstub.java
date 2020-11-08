package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Employee;
import com.timelogr.enterprise.dto.TimeLog;
import org.springframework.stereotype.Repository;

import javax.lang.model.type.ArrayType;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class TimeLogrDAOstub implements TimeLogrDAO {

    HashMap<Integer, TimeLog> allTimeLogs = new HashMap<>();
    @Override
    public TimeLog save(TimeLog timeLog) {
        allTimeLogs.put(timeLog.getId(), timeLog);
        return timeLog;
    }

    @Override
    public List<TimeLog> getAllLoggedTime() {
        return new ArrayList<>(allTimeLogs.values());
    }

    HashMap<Long, Employee> allEmployees = new HashMap<Long, Employee>();
    @Override
    public Employee saveEmployee(Employee employee){ return employee;}

    @Override
    public List<Employee> getAllEmployees(){
        return new ArrayList<>(allEmployees.values());
    }
}
