package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Seller;
import com.internship.repayment.repository.ContractRepository;
import com.internship.repayment.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class SellerServiceImpl implements SellerService {
    @Autowired
    private ContractRepository contractRepository;
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
}
