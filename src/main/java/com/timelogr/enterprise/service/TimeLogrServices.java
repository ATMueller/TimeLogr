package com.timelogr.enterprise.service;
import com.timelogr.enterprise.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
* This class is currently testing Dummy Data
 **/
@Service
public class TimeLogrServices implements ITimeLogrService {

    private static final List<Employee> employeeList = new ArrayList<>();

    static{
        for(int i =0; i<10; i++){
            employeeList.add(new Employee(i, "Human" + i,"d","d"));
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
