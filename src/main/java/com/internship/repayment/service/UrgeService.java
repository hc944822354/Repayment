package com.internship.repayment.service;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Urge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UrgeService {
    Result<List<Urge>> queryUrgeBills(String username);
}
