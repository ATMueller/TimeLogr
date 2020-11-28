package com.timelogr.enterprise;

import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;
import com.timelogr.enterprise.dto.Account;
import com.timelogr.enterprise.service.TimeLogrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TimeLogrController {

    @Autowired
    private TimeLogrService timeLogrService;

    /**
     *
     * Root endpoint for index page
     * @return index.html
     */

    @RequestMapping("/")
    public String login(Model model, HttpSession session) {
        Account account = new Account();
        model.addAttribute(account);
        session.setAttribute("alert", "0");
        model.addAttribute("allLogs", timeLogrService.getAllLoggedTime());
        return "login";
    }

    @RequestMapping("/home")
    public String index(Model model){
        TimeLog timeLog = new TimeLog();
        model.addAttribute(timeLog);
        model.addAttribute("allLogs", timeLogrService.getAllLoggedTime());
        return "home";
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

    @GetMapping("/create-account")
    public String saveAccount(Account account,  HttpSession session) {
        System.out.println("--------------");
        System.out.println(account);
        timeLogrService.saveAccount(account);
        session.setAttribute("alert","1");
        return "login";
    }
    @GetMapping("/check-account")
    public String loginAccount(Account account, HttpSession session) {
        System.out.println("--------------");
        List<Account> acclist = timeLogrService.getAllAccounts();
        //System.out.println(account.getEmail());
        System.out.println("----------");
        //System.out.println(acclist);
        System.out.println(account);
        for(Account temp: acclist){
            System.out.println(temp);
            if(temp.getEmail().equals(account.getEmail()) && temp.getPassword().equals(account.getPassword())){

                return "redirect:home";
            }
            else{
                session.setAttribute("alert","2");
            }

        }
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
