package com.internship.repayment.controller;

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
    public  String queryContract(@RequestParam String username, ModelMap map){
        List<Contract> contracts=contractService.queryContract(username);
        if (contracts!=null)
        {
            map.addAttribute("contracts",contracts);
            return "customer_queryContract";
        }
        else
        {
            Exception e=new Exception("没有合同");
            map.addAttribute("exception",e);

            return "error";

        }
    }
}
