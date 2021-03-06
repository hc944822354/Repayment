package com.internship.repayment.service;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.entity.Seller;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CustomerService {
    Result<Customer> login(String username, String password);
    Result<Customer> findCustomer(String username);
    Result<Customer> updateSelf(Customer customer);
    Result<List<Customer>> queryCustomer(String username);

}
