package com.timelogr.enterprise;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
