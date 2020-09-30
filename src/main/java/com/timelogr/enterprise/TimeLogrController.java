package com.timelogr.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//ALL WEB FILES GO IN THE resources/templates DIRECTORY
@Controller
@RequestMapping("/")
public class TimeLogrController {

    @RequestMapping("/")
    public String index(){

        return "index"; //STARTS PROGRAM IN THE resources/templates/index.html
    }

    @RequestMapping("/page1")
        public String page1() {
            return "page1";
    }
}
