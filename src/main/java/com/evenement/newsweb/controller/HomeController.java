package com.evenement.newsweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home()
    {
        return "index";
    }
    @RequestMapping("/secured")
    @ResponseBody
    public String secured() {
        return "secured page";
    }
}
