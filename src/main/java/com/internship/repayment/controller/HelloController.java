package com.internship.repayment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception();
    }

    @RequestMapping("/")
    public String index(ModelMap map) throws Exception{
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

}
