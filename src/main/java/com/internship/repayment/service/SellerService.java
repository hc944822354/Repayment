package com.internship.repayment.service;

import com.internship.repayment.entity.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> querySeller(String username);
}
