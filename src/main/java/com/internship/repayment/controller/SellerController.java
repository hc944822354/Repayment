package com.internship.repayment.controller;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.entity.Seller;
import com.internship.repayment.service.CustomerService;
import com.internship.repayment.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/repayment/seller")
public class SellerController {


    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/querySeller",method = RequestMethod.GET)
    public  String querySeller(HttpSession session, ModelMap map){
        Customer customer = (Customer) session.getAttribute("customer");
        Result<List<Seller>> results=sellerService.querySeller(customer.getUsername());
        if (results.getState().equals(Result.SUCCESS)){
            session.setAttribute("customer",customer);
            map.addAttribute("sellers",results.getResult());
            session.setAttribute("customer",customer);
            return "customer_querySeller";
        }else {
            Exception e = new Exception("没有负责销售员");
            map.addAttribute("exception",e);
            return "error";
        }


    }
}
