package com.internship.repayment.service;

import com.internship.repayment.VO.Result;

import java.util.List;
import com.internship.repayment.entity.Repayment;

public interface RepaymentService {
    Result<List<Repayment>> queryRepayment(String username);
}
