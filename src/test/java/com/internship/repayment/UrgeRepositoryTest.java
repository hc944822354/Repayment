package com.internship.repayment;

import com.internship.repayment.entity.*;
import com.internship.repayment.repository.*;
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

public class UrgeRepositoryTest {

    @Autowired
    private UrgeRepository urgeRepository;

    @Autowired
    private ContractRepository contractRepository;

    private  Logger logger=LoggerFactory.getLogger(UrgeRepositoryTest.class);

    @Test
    public void testUrgeInsert() throws Exception{
        Urge urge=new Urge();
        Contract contract= contractRepository.findContractByContractname("家具合同");
        urge.setContract(contract);
        urge.setUrgetime(new Date());
        urgeRepository.save(urge);

    }


    @Test
    public void testUrgefindUrgeByContract_Customer_Username(){
        List<Urge> urges=urgeRepository.findUrgeByContract_Customer_Username("123456");
        for (Urge urge:urges
             ) {
            logger.info(urge.toString());
        }

    }
}
