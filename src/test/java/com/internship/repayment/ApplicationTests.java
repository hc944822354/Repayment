package com.internship.repayment;

import com.internship.repayment.controller.CustomerController;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;



    @Test
    public void testCustomerRepositpry() throws Exception {
        Customer customer = new Customer();
        customer.setName("张三");
        customer.setPassword("sadsfasfa");
        customer.setAddress("北京");
        customer.setGender("男");
        customer.setReputation("良好");
        customer.setTelphone("12345678912");
        customerRepository.save(customer);
    }

}