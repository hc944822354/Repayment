package com.internship.repayment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/repayment")
public class IndexController {

    @RequestMapping("/")
    public String index(Model model)  {
        model.addAttribute("customer_login","/repayment/customer/");
        return "index";
    }
}
