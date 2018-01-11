package com.internship.repayment;

import com.internship.repayment.entity.Customer;
import com.internship.repayment.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);
    @Test
    public void testCustomerInsert() throws Exception {
        Customer customer = new Customer();
        customer.setUsername("123456");
        customer.setName("张三");
        customer.setPassword("sadsfasfa");
        customer.setAddress("北京");
        customer.setGender("男");
        customer.setReputation("良好");
        customer.setTelphone("12345678912");
        customerRepository.save(customer);
    }

    @Test
    public void testCustomerfindCustomerByUsername(){
        Customer customer = customerRepository.findCustomerByUsername("123456");
        logger.info(customer.toString());
    }
}
