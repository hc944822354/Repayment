package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.repository.CustomerRepository;
import com.internship.repayment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Result<Customer> login(String username, String password) {
        Customer customer = customerRepository.findCustomerByUsername(username);
        //账户存在且密码正确
        Result<Customer> result;
        if (customer!=null&&customer.getPassword().equals(password)){
            result = Result.getSuccessInstance(customer);
            result.setMsg("登陆成功");
        }else if (customer!=null){
            result = Result.getFailInstance("密码错误",customer);
        }else {
            result = Result.getFailInstance("账户不存在",null);
        }
        return result;
    }
}
