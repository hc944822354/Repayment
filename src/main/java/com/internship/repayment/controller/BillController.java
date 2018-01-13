package com.internship.repayment.controller;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Bill;
import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/repayment/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping(value = "/queryBill",method = RequestMethod.GET)
    public String queryContract(HttpSession session, ModelMap map){
        Customer customer = (Customer) session.getAttribute("customer");
        Result<List<Bill>> results=billService.queryBill(customer.getUsername());
        if (results.getState().equals(Result.SUCCESS)){
            session.setAttribute("customer",customer);
            map.addAttribute("bills",results.getResult());
            return "customer_queryBill";
        }else {
            Exception e = new Exception("没有欠款账单");
            map.addAttribute("exception",e);
            return "error";
        }
    }
}
