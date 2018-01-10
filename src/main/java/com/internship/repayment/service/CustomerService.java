package com.internship.repayment.service;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Result<Customer> login(String username, String password);
}
