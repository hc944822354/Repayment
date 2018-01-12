package com.internship.repayment.controller;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Repayment;
import com.internship.repayment.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/repayment/repayment")
public class RepaymentController {

    @Autowired
    private RepaymentService repaymentService;

    @RequestMapping(value = "/queryRepayment", method = RequestMethod.GET)
    public String queryRepayment(@RequestParam String username, ModelMap map) {
        Result<List<Repayment>> results = repaymentService.queryRepayment(username);
        if (results.getState().equals(Result.SUCCESS)) {
            map.addAttribute("repayments", results.getResult());
            return "customer_queryRepayment";
        } else {
            Exception e = new Exception("没有回款记录");
            map.addAttribute("exception", e);
            return "error";
        }


    }
}
