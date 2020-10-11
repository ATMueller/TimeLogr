package com.timelogr.enterprise.service;

import com.timelogr.enterprise.dto.employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeLogrServices {
    //TESTING DUMMY DATA#######################################
    public static List<employee> employeeList = new ArrayList<>();
    static{
        for(int i =0;i<10;i++){
            employeeList.add(new employee(i, "Human" + i,"d","d"));
        }
    }
    public List <employee> GetAllEmployees(){
        return employeeList;
    }




    //#########################################################
}
