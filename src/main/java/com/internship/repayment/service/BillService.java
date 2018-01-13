package com.internship.repayment.service;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Bill;

import java.util.List;

public interface BillService {
    Result<List<Bill>> queryBill(String username);
}
