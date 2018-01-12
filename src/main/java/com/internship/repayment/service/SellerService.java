package com.internship.repayment.service;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Seller;

import java.util.List;

public interface SellerService {
    Result<List<Seller>> querySeller(String username);
}
