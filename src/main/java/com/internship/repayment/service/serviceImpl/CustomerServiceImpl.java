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

    @Autowired
    private ContractRepository contractRepository;

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
    public List<Seller> querySeller(String username){
        List<Contract> contracts=contractRepository.findContractsByCustomer_Username(username);
        if(contracts!=null) {
            List<Seller> sellers = new LinkedList<Seller>();
            for (Contract contract : contracts
                    ) {
                sellers.add(contract.getSeller());

            }
            return sellers;
        }
        else
            return null;


    }

    @Override
    public List<Contract> queryContract(String username){
        List<Contract>contracts=contractRepository.findContractsByCustomer_Username(username);
        if (contracts!=null){
            return contracts;
        }
        else
            return null;

    }
}
