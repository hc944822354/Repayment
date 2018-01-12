package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.entity.Contract;
import com.internship.repayment.repository.ContractRepository;
import com.internship.repayment.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractRepository contractRepository;

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
