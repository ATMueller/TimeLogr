package com.timelogr.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ALL WEB FILES GO IN THE resources/templates DIRECTORY
 */
@Controller
@RequestMapping("/")
public class TimeLogrController {

    private final TimeLogrServices timeLogrServices;

    @Autowired
    public TimeLogrController(TimeLogrServices timeLogrServices){
        super();
        this.timeLogrServices = timeLogrServices;
    }

    /**
     * STARTS PROGRAM IN THE resources/templates/index.html
     */
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("employee", this.timeLogrServices.getAllEmployees());
        return "index";
    }

    @RequestMapping("/clients")
    public String clients(Model model){
        model.addAttribute("employee", this.timeLogrServices.getAllEmployees());
        return "clients";
    }

    @RequestMapping("/settings")
    public String settings() {
        return "settings";
    }

    @RequestMapping("/newproject")
    public String newProject() {
        return "newproject";
    }

    @RequestMapping("/projectdetails")
    public String projectDetails(Model model){
        model.addAttribute("employee", this.timeLogrServices.getAllEmployees());
        return "projectdetails";
    }

    /*
    Pass in project ID
    @RequestMapping("/logTime")
    Go to service stub and call timeLog DAO save
    */
}
