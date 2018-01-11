package com.internship.repayment;

import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Customer;
import com.internship.repayment.entity.Repayment;
import com.internship.repayment.entity.Seller;
import com.internship.repayment.repository.ContractRepository;
import com.internship.repayment.repository.CustomerRepository;
import com.internship.repayment.repository.RepaymentRepository;
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
public class RepaymentRepositoryTest {

    @Autowired
    private RepaymentRepository repaymentRepository;

    @Autowired
    private ContractRepository contractRepository;

    private Logger logger=LoggerFactory.getLogger(RepaymentRepositoryTest.class);

    @Test
    public void testRepaymentInsert()throws Exception{
        Repayment repayment=new Repayment();
        Contract contract=contractRepository.findContractByContractname("家具合同");
        repayment.setContract(contract);
        repayment.setRapaymentname("家具合同还款第一期");
        repayment.setPaytime(new Date());
        repayment.setPaymoney(1000.0);
        repaymentRepository.save(repayment);



    }

    @Test
    public void testRepaymentfindRepaymentByContract_Customer_UserName()
    {
        List<Repayment> repayments=repaymentRepository.findRepaymentByContract_Customer_Username("123456");
        for (Repayment repayment:repayments
             ) {
            logger.info(repayment.toString());
        }


    }
}
