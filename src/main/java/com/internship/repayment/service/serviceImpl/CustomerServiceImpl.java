package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.entity.Seller;
import com.internship.repayment.repository.ContractRepository;
import com.internship.repayment.repository.CustomerRepository;
import com.internship.repayment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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

    @Override
    public Result<Customer> findCustomer(String username) {
        Customer customer = customerRepository.findCustomerByUsername(username);
        Result<Customer> result;
        if (customer!=null){
            result = Result.getSuccessInstance(customer);
            result.setMsg("用户存在");
        }else {
            result = Result.getFailInstance("用户不存在",null);
        }
        return result;
    }

    @Override
    public Result<Customer> updateSelf(Customer customer) {
        Customer customer1 = customerRepository.findCustomerByUsername(customer.getUsername());
        Result<Customer> result ;
        if (customer1!=null) {
            Customer customer2 = customerRepository.save(customer);
            result = Result.getSuccessInstance(customer2);
            return result;
        }else {
            result = Result.getFailInstance("用户不存在",customer);
            return result;
        }
    }

    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Result <List<Customer> >queryCustomer(String username){
        List<Contract> contracts=contractRepository.findContractsBySeller_Username(username);
        Result<List<Customer>> results;
        if(contracts!=null) {
            List<Customer> customers = new LinkedList<Customer>();
            for (Contract contract : contracts
                    ) {
                customers.add(contract.getCustomer());

            }
            results=Result.getSuccessInstance(customers);
            results.setMsg("查询成功");
        }
        else
            results=Result.getFailInstance("没有负责客户",null);

        return results;

    }


}
