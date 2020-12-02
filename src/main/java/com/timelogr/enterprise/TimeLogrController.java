package com.timelogr.enterprise;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.timelogr.enterprise.dto.Project;
import com.timelogr.enterprise.dto.TimeLog;
import com.timelogr.enterprise.dto.Account;
import com.timelogr.enterprise.service.TimeLogrService;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.util.AbstractMap;
import java.util.HashMap;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Controller
public class TimeLogrController {

    @Autowired
    private TimeLogrService timeLogrService;

    /**
     *
     * Root endpoint for index page
     * @return login.html
     */
    @RequestMapping("/")
    public String login(Account account, Model model,HttpSession oldsession, HttpServletRequest request) {
        oldsession.invalidate();
        HttpSession session = request.getSession();
        model.addAttribute(account);
        session.setAttribute("alert", "0");
        model.addAttribute("allLogs", timeLogrService.getAllLoggedTime());
        return "login";
    }
    /**CREATES A NEW ACCOUNT FROM THE MODAL IN LOGIN.HTML
        IS NOW SANITIZED
    */
    @RequestMapping(value ="/create-account",method = RequestMethod.POST)
    public String saveAccount(@Validated @ModelAttribute("account") Account account, Errors errors, Model model, HttpSession session) {
        System.out.println(errors);
        List<Account> acclist = timeLogrService.getAllAccounts();
        for (Account temp : acclist) {
            if(temp.getEmail().equals(account.getEmail())){
                errors.reject("Email used");
                session.setAttribute("alert", 1);
                session.setAttribute("msg", "The Email you have entered is being used");
                session.setAttribute("modal", 1);
            }
        }
        System.out.println(errors);
        if (null != errors && errors.getErrorCount() > 0) {
            return "login";
        } else {
            model.addAttribute("successMsg", "Details saved successfully!!");
            timeLogrService.saveAccount(account);
            session.setAttribute("alert",1);
            session.setAttribute("msg", "Account Created");
            return "login";
        }
    }
    /**CHECKS THE LOGIN.HTML SIGN IN FORM AND SEARCHES FOR A MATCHING EMAIL AND PASSWORD
     * RETURNS THE USERS ACCOUNT */
    @RequestMapping(value ="/check-account",method = RequestMethod.POST)
    public String loginAccount(@Validated @ModelAttribute("account") Account account, Errors errors, Model model, HttpSession session) {
        if (null != errors && errors.getErrorCount() > 0) {
            List<Account> acclist = timeLogrService.getAllAccounts();
            for (Account temp : acclist) {
                if (temp.getEmail().equals(account.getEmail()) && temp.getPassword().equals(account.getPassword())) {
                    Account userAccount = timeLogrService.findAccountByEmail(temp.getEmail());
                    session.setAttribute("userEmail", userAccount.getEmail());
                    return "redirect:home";
                }
            }
            session.setAttribute("alert", 1);
            session.setAttribute("msg", "The Account information you entered is incorrect");
            return "login";
        }
        return "login";
    }


    /**
     *
     * MAIN PAGE ONLY RETURNS AFTER LOGIN
     * AND ALL FUNCTIONS RELATED TO THE HOME PAGE
     * @return dev.html
     */
    @RequestMapping("/home")
    public String index(Model model, HttpSession session, Project project){
        if(session.getAttribute("userEmail") == null || session.getAttribute("userEmail").equals("")){
            return "redirect:/";
        }
        Object userEmail = session.getAttribute("userEmail");
        Account account = timeLogrService.findAccountByEmail(userEmail.toString());
        System.out.println("getTyped: " + account.getType());
        if(account.getType().equals("employee")) {
            return "redirect:/dev";
        }
        else {
            return "redirect:/clients";
        }
    }

    @RequestMapping("/dev")
    public String dev(Model model, HttpSession session, Project project){
        if(session.getAttribute("userEmail") == null || session.getAttribute("userEmail").equals("")){
            return "redirect:/";
        }
        Object userEmail = session.getAttribute("userEmail");
        Account account = timeLogrService.findAccountByEmail(userEmail.toString());
        System.out.println("type: " + account.getType());
        if(account.getType().equals("client")) {
            return "redirect:/clients";
        }

        TimeLog timeLog = new TimeLog();
        model.addAttribute(timeLog);

        Account userAccount = timeLogrService.findAccountByEmail(session.getAttribute("userEmail").toString());
        List<TimeLog> allLoggedTime = timeLogrService.getAllLoggedTime();
        System.out.println(allLoggedTime);
        Map<TimeLog, Map.Entry<Project, Account>> timelogOut = new HashMap<>();
        System.out.println(timeLogrService.findAccountById(userAccount.getId()));
        for(TimeLog temp : allLoggedTime){
            if(temp.getEmployeeID() == userAccount.getId()){
                Project tempProject =timeLogrService.findProjectById(temp.getProjectID());

                timelogOut.put(temp,new AbstractMap.SimpleEntry(tempProject, timeLogrService.findAccountById(tempProject.getClientId())));
            }
        }

        System.out.println(allLoggedTime);
        System.out.println(timelogOut);
        System.out.println(userAccount.getId());
        model.addAttribute("userAccount", userAccount);
        model.addAttribute("userTimeLogs", timelogOut);
        model.addAttribute("allAccounts", timeLogrService.getAllAccounts());
        model.addAttribute("allLogs", timeLogrService.getAllLoggedTime());
        model.addAttribute("allProjects", timeLogrService.getAllProjects());
        return "dev";
    }

    @RequestMapping("/saveTimeLog")
    public String saveTimeLog(TimeLog timeLog,Model model) {
        if(timeLog.getProjectID() != 0){
            timeLogrService.saveLog(timeLog);
        }

        return "redirect:/dev";
    }

    @PostMapping(value= "/d", consumes="application/json", produces="application/json")
    public TimeLog newTimeLog(@RequestBody TimeLog timeLog) {
        TimeLog newLog = timeLogrService.saveLog(timeLog);
        return newLog;
    }





    /**
     * Save log time for testing
     * @param timeLog
     * @return
     */


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
    public String Clients(Model model,Project project, HttpSession session, Account account) {
        if(session.getAttribute("userEmail") == null || session.getAttribute("userEmail").equals("")){
            return "redirect:/";
        }
        Object userEmail = session.getAttribute("userEmail");
        account = timeLogrService.findAccountByEmail(userEmail.toString());
        System.out.println("type: " + account.getType());
        if(account.getType().equals("employee")) {
            return "redirect:/dev";
        }
        List<Project> allClientProjects = timeLogrService.getClientProjects(account.getId());

        model.addAttribute("clientProjects", timeLogrService.getClientProjects(account.getId()));
        model.addAttribute("sumTime", timeLogrService);

        return "clients";
    }

    @RequestMapping("/settings")
    public String Settings() {
        return "settings";
    }

    @RequestMapping("/newproject")
    public String NewProject(Model model,Project project, HttpSession session, Account account) {
        if(session.getAttribute("userEmail") == null || session.getAttribute("userEmail").equals("")){
            return "redirect:/";
        }
        Object userEmail = session.getAttribute("userEmail");
        Account userAccount = timeLogrService.findAccountByEmail(userEmail.toString());
        List<Project> allProjects = timeLogrService.getAllProjects();
        System.out.println(allProjects);
        model.addAttribute(project);
        model.addAttribute("userAccount", userAccount);
        List<Account> allAccounts = timeLogrService.getAllAccounts();
        List<Account> allEmployees = null;
        System.out.println("===============================");
        return "newproject";
    }

    @RequestMapping(value ="/saveProject", method = RequestMethod.POST)
    public String saveProject(@Validated @ModelAttribute("project") Project project, Errors errors, HttpSession session) {
        Object userEmail = session.getAttribute("userEmail");
        System.out.println(errors.getErrorCount());
        Account userAccount = timeLogrService.findAccountByEmail(userEmail.toString());
        System.out.println("===============================");
        System.out.println(errors.getErrorCount());
        if (null != errors && errors.getErrorCount() > 0) {
            return "newproject";
        }else {
            System.out.println(userAccount);
            project.setClientId(userAccount.getId());
            timeLogrService.saveProject(project);
            return "redirect:/clients";
        }
    }


    @GetMapping("/editproject/{projectId}/")
    public ModelAndView specimensByPlant(@PathVariable("projectId") int projectId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editproject");
        modelAndView.addObject("project", timeLogrService.getProjectById(projectId));
        return  modelAndView;

    }


    @GetMapping(value ="/pullJson/{type}/",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String pullJson(@PathVariable("type") String type, Model model){
        Map<TimeLog, Map.Entry<Project, Account>> timelogOut = new HashMap<>();
        Gson gson = new Gson();
        String json;
        if(type.equals("account") || type.isEmpty()){
            List<Account> allAccounts =timeLogrService.getAllAccounts();
            json = gson.toJson(allAccounts);
        }
        else if(type.equals("Project")){
            List<Project> allProjects =timeLogrService.getAllProjects();
            json = gson.toJson(allProjects);
        }
        else if(type.equals("timelog")){
            List<TimeLog> allTimeLog =timeLogrService.getAllLoggedTime();
            json = gson.toJson(allTimeLog);
        }
        else{
            json = "Please enter a Variable type( account || project || timelog  ) in the URL";
        }


        List<TimeLog> allTimeLog =timeLogrService.getAllLoggedTime();



        System.out.println(json);
        return json;
    }


}
