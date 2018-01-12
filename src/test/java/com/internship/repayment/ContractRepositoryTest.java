package com.internship.repayment;

import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.entity.Seller;
import com.internship.repayment.repository.ContractRepository;
import com.internship.repayment.repository.CustomerRepository;
import com.internship.repayment.repository.SellerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ContractRepositoryTest {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    private Logger logger=LoggerFactory.getLogger(ContractRepositoryTest.class);

    @Test
    public void testContractInsert() throws Exception{
        Contract contract=new Contract();
        Customer customer=customerRepository.findCustomerByUsername("123457");
        Seller seller=sellerRepository.findSellerByName("098766");

        contract.setContractname("家具合同");
        contract.setCustomer(customer);
        contract.setSeller(seller);
        contract.setBegintime(new Date());
        contract.setCuttime(new Date());
        contract.setDescription("这是一份家具合同");
        contract.setSummoney(5000.0);
        contractRepository.save(contract);

    }

    @Test
    public void testContractfindContactByContactName()
    {
       Contract contact= contractRepository.findContractByContractname("家具合同");
       logger.info(contact.toString());

    }

    @Test
    public void testContractfindContactByCustomer_Username(){
        List <Contract> contracts=contractRepository.findContractsByCustomer_Username("123456");
        for (Contract contract:contracts
             ) {
            logger.info(contract.toString());

        }


    }


    @Test
    public void testContractfindContractBySeller_Username()
    {
        List <Contract> contracts=contractRepository.findContractsBySeller_Username("123908");
        for (Contract contract:contracts
                ) {
            logger.info(contract.toString());

        }
    }


    @Test
    public void testContactfindCustomersBySellerUsername()
    {
        List <Customer> customers=contractRepository.findCustomersBySellerUername("123908");
        for (Customer customer:customers
             ) {
            logger.info(customer.toString());
        }
    }

}
