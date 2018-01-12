package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Seller;
import com.internship.repayment.repository.ContractRepository;
import com.internship.repayment.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Result<List<Seller>> querySeller(String username){
        List<Contract> contracts=contractRepository.findContractsByCustomer_Username(username);
        Result<List<Seller>> result = new Result<>();
        if(contracts!=null) {
            List<Seller> sellers = new LinkedList<Seller>();
            result = Result.getSuccessInstance(sellers);
            for (Contract contract : contracts
                    ) {
                sellers.add(contract.getSeller());

            }
            return result;
        }
        else
            result = Result.getFailInstance("没有相关销售员",null);
            return result;


    }
}
