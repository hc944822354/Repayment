package com.internship.repayment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/repayment/urge")
public class UrgeController {
    @RequestMapping(value = "/queryUrgeBill",method = RequestMethod.GET)
    public  String queryUrgeBill(@RequestParam String username, ModelMap map){
        return "error";
    }
}
