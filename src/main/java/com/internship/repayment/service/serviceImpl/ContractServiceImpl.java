package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.VO.Result;
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
    public Result<List<Contract>> queryContract(String username){
        List<Contract>contracts=contractRepository.findContractsByCustomer_Username(username);
        Result<List<Contract>> results;
        if (contracts!=null) {
            results = Result.getSuccessInstance(contracts);
            results.setMsg("查询成功");
        }
        else
            results=Result.getFailInstance("没有签订合同",null);

        return results;

    }
}
