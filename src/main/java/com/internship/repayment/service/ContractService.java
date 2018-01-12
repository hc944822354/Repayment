package com.internship.repayment.service;

import com.internship.repayment.entity.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> queryContract(String username);
}
