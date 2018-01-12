package com.internship.repayment.controller;

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
    private CustomerService customerService;

    @Autowired
    private SellerService sellerService;


}
