package com.timelogr.enterprise;

import com.timelogr.enterprise.service.ITimeLogrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// ALL WEB FILES GO IN THE resources/templates DIRECTORY
@Controller
@RequestMapping("/")
public class TimeLogrController {

    private final ITimeLogrService timeLogrService;

    @Autowired
    public TimeLogrController(ITimeLogrService timeLogrService){
        super();
        this.timeLogrService = timeLogrService;
    }

    /**
     * Starts Program in the resources/templates/index.html
     */
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("employee", this.timeLogrService.getAllEmployees());
        return "index";
    }

    @RequestMapping("/clients")
    public String clients(Model model){
        model.addAttribute("employee", this.timeLogrService.getAllEmployees());
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
        model.addAttribute("employee", this.timeLogrService.getAllEmployees());
        return "projectdetails";
    }
    //pass in Project ID

    //@RequestMapping("/logTime")
    // go to service stub and call TimeLog DAO save

}
