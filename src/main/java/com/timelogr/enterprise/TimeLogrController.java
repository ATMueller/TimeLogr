package com.timelogr.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//ALL WEB FILES GO IN THE resources/templates DIRECTORY
@Controller
@RequestMapping("/")
public class TimeLogrController {

    //TESTING DUMMY DATA#######################################
    public static List<employee> employeeList = new ArrayList<>();
    static{
        for(int i =0;i<10;i++){
            employeeList.add(new employee(i, "Human" + i,"d","d"));
        }
    }
    @GetMapping
    public String getAllEmployees(Model model){
        model.addAttribute("employee", employeeList);
        return "index";
    }



    //#########################################################

    @RequestMapping("/")
    public String index(){

        return "index"; //STARTS PROGRAM IN THE resources/templates/index.html
    }

    @RequestMapping("/page1")
        public String page1() {
            return "page1";
    }
}
