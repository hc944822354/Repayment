package com.internship.repayment.service;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Contract;

import java.util.List;

public interface ContractService {
   Result<List<Contract>> queryContract(String username);
}
