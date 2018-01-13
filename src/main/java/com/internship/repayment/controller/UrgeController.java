package com.internship.repayment.controller;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.entity.Urge;
import com.internship.repayment.service.CustomerService;
import com.internship.repayment.service.UrgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/repayment/urge")
public class UrgeController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UrgeService urgeService;

    @RequestMapping(value = "/queryUrgeBills",method = RequestMethod.GET)
    public  String queryUrgeBill(HttpSession session, ModelMap map){
        Customer customer = (Customer) session.getAttribute("customer");
        Result<List<Urge>> urgeBillsResult = urgeService.queryUrgeBills(customer.getUsername());
        if (urgeBillsResult.getState().equals(Result.SUCCESS)){
            session.setAttribute("customer",customer);
            List<Urge> urges = urgeBillsResult.getResult();
            map.addAttribute("urgeBills",urgeBillsResult.getResult());
            return "customer_queryUrgeBill";
        }else {
            Exception e = new Exception("无欠款记录");
            map.addAttribute("exception",e);
            map.addAttribute("url",customer.toString());
            return "error";
        }
    }
}
