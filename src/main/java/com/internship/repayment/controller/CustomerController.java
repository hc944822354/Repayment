package com.internship.repayment.controller;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.repository.ContractRepository;
import com.internship.repayment.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ContractRepository contractRepository;



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

    @RequestMapping(value = "/updateSelf",method = RequestMethod.GET)
    public String updateSelf(ModelMap map,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        logger.error(customer.toString());
        session.setAttribute("customer",customer);
        map.addAttribute("customer",customer);
        return "customer_update_self";
    }

    @RequestMapping(value = "/returnBill",method = RequestMethod.GET)
    public String returnBill(ModelMap map,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        List<Contract> contractList = contractRepository.findContractsByCustomer_Username(customer.getUsername());
        return "error";
    }
    @RequestMapping(value = "/updateSelf",method = RequestMethod.POST)
    public String updateSelf(@ModelAttribute Customer customer,ModelMap map,HttpSession session){
        logger.error(customer.toString());
        Result<Customer> result =customerService.updateSelf(customer);
        if (result.getState().equals(Result.SUCCESS)){
            Customer customer1 = result.getResult();
            logger.error(customer1.toString());
            session.setAttribute("customer",customer1);
            return "customer_update_self";
        }else {
            map.addAttribute("exception","用户不存在");
            map.addAttribute("url",customer.getUsername());
            return "error";
        }
    }
}
