package com.internship.repayment;

import com.internship.repayment.entity.Seller;
import com.internship.repayment.repository.SellerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SellerRepositoryTest {

    @Autowired
    private SellerRepository sellerRepository;
    private Logger logger= LoggerFactory.getLogger(SellerRepositoryTest.class);

    @Test
    public void testSellerInsert() throws Exception{
        Seller seller=new Seller();
        seller.setUsername("098766");
        seller.setName("小明");
        seller.setPassword("zxcvb");
        seller.setGender("女");
        seller.setTelphone("19823456789");
        seller.setJob("普通员工");
        sellerRepository.save(seller);

    }

    @Test
    public void testSellerfindSellerByName(){
        Seller seller=sellerRepository.findSellerByName("123908");
        logger.info(seller.toString());

    }


}
