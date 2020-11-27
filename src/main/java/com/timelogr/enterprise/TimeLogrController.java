package com.timelogr.enterprise;

import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;
import com.timelogr.enterprise.dto.Account;
import com.timelogr.enterprise.service.TimeLogrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TimeLogrController {

    @Autowired
    TimeLogrService timeLogrService;

    /**
     *
     * Root endpoint for index page
     * @return index.html
     */
    @RequestMapping("/")
    public String index(Model model){
        TimeLog timeLog = new TimeLog();
        model.addAttribute(timeLog);
        model.addAttribute("allLogs", timeLogrService.getAllLoggedTime());
        return "index";
    }

    /**
     * Developers saves a new time logged
     * @param timeLog
     * @return index
     */
    @RequestMapping("/saveTimeLog")
    public String saveTimeLog(TimeLog timeLog) {
        timeLogrService.saveLog(timeLog);
        return "redirect:";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        Account account = new Account();
        model.addAttribute(account);
        model.addAttribute("allLogs", timeLogrService.getAllLoggedTime());
        return "login";
    }

    @GetMapping("/create-account")
    public String account(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }
    /**
     * Save log time for testing
     * @param timeLog
     * @return
     */
    @PostMapping(value= "/", consumes="application/json", produces="application/json")
    public TimeLog newTimeLog(@RequestBody TimeLog timeLog) {
        TimeLog newLog = timeLogrService.saveLog(timeLog);
        return newLog;
    }

    /**
     * Return all logged time for testing
     * @param
     * @return
     */
    @GetMapping("/timeLogs")
    @ResponseBody
    public List<TimeLog> getAllLoggedTime() {
        return timeLogrService.getAllLoggedTime();
    }

    /**
     * Return all projects
     * @param
     * @return
     */
    @GetMapping("/projects")
    @ResponseBody
    public List<Project> getAllProjects() {
        return timeLogrService.getAllProjects();
    }



    @RequestMapping("/clients")
    public String Clients(Model model){
        // model.addAttribute("employee", this.timeLogrServices.GetAllEmployees());
        return "clients";
    }

    @RequestMapping("/settings")
    public String Settings() {
        return "settings";
    }

    @RequestMapping("/newproject")
    public String NewProject(Model model) {
        Project project = new Project();
        model.addAttribute(project);
        return "newproject";
    }

    @RequestMapping("/saveProject")
    public String NewProject(Project project) {
        timeLogrService.saveProject(project);
        return "index";
    }

    @RequestMapping("/projectdetails")
    public String projectdetails(Model model){
        // model.addAttribute("employee", this.timeLogrServices.GetAllEmployees());
        return "projectdetails";
    }



}
