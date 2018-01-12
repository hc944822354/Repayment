package com.internship.repayment.controller;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Seller;
import com.internship.repayment.service.CustomerService;
import com.internship.repayment.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/repayment/seller")
public class SellerController {


    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/querySeller",method = RequestMethod.GET)
    public  String querySeller(@RequestParam String username, ModelMap map){
        Result<List<Seller>> results=sellerService.querySeller(username);
        if (results.getState().equals(Result.SUCCESS)){
            map.addAttribute("sellers",results.getResult());
            return "customer_querySeller";
        }else {
            Exception e = new Exception("没有负责销售员");
            map.addAttribute("exception",e);
            return "error";
        }


    }
}
