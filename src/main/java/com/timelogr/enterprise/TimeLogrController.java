package com.timelogr.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//ALL WEB FILES GO IN THE resources/templates DIRECTORY
@Controller
@RequestMapping("/")
public class TimeLogrController {
    private TimeLogrServices timeLogrServices;


    @Autowired
    public TimeLogrController(TimeLogrServices timeLogrServices){
        super();
        this.timeLogrServices = timeLogrServices;
    }



    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("employee", this.timeLogrServices.GetAllEmployees());
        return "index"; //STARTS PROGRAM IN THE resources/templates/index.html
    }

    @RequestMapping("/page1")
        public String page1() {
            return "page1";
    }
}
