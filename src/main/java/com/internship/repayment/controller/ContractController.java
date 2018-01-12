package com.internship.repayment.controller;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Contract;
import com.internship.repayment.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/repayment/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @RequestMapping(value = "/queryContract",method = RequestMethod.GET)
    public String queryContract(@RequestParam String username,ModelMap map){
        Result<List<Contract>> results=contractService.queryContract(username);
        if (results.getState().equals(Result.SUCCESS)){
            map.addAttribute("contracts",results.getResult());
            return "customer_queryContract";
        }else {
            Exception e = new Exception("没有签订合同");
            map.addAttribute("exception",e);
            return "error";
        }
    }



}
