package com.internship.repayment.controller;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/repayment/customer")
public class CustomerController{
    // 创建线程安全的Map
    static Map<Long,Customer> customers = Collections.synchronizedMap(new HashMap<Long, Customer>());
    @Autowired
    private CustomerService customerService;



    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer_index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute Customer customer, ModelMap map, HttpSession session){
        Result<Customer> result = customerService.login(customer.getUsername(),customer.getPassword());
        if (result.getState().equals(Result.SUCCESS)){
            Customer curCustomer = result.getResult();
            session.setAttribute("customer",curCustomer);
            map.addAttribute("query_seller","/repayment/customer/querySeller");
            return "customer_login_success";
        }else {
            Exception e = new Exception("密码错误");
            map.addAttribute("exception",e);
            map.addAttribute("url",customer.getUsername());
            return "error";
        }
    }

    @RequestMapping(value = "/querySelf",method = RequestMethod.GET)
    public String querySelf(@ModelAttribute Customer customer,ModelMap map,HttpSession session){
        Customer acustomer = (Customer) session.getAttribute("customer");
        session.setAttribute("customer",acustomer);
        return "customer_query_self";
    }

}
