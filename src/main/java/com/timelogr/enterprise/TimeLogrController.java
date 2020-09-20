package com.timelogr.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TimeLogrController {

    @RequestMapping("/")
    public String index(){
        return "start";
    }
}
