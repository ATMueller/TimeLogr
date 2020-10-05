package com.timelogr.enterprise;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TESTING DUMMY DATA
 */
@Service
public class TimeLogrServices {

    public static List<Employee> employeeList = new ArrayList<>();

    static{
        for(int i = 0; i < 10; i++){
            employeeList.add(new Employee(i, "Human" + i,"d","d"));
        }
    }

    public List <Employee> getAllEmployees(){
        return employeeList;
    }
}
