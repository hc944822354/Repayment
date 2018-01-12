package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Urge;
import com.internship.repayment.repository.UrgeRepository;
import com.internship.repayment.service.UrgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrgeServiceImpl implements UrgeService {
    @Autowired
    private UrgeRepository urgeRepository;
    @Override
    public Result<List<Urge>> queryUrgeBills(String username) {
        Result<List<Urge>> result = new Result<>();
        List<Urge> urges = urgeRepository.findUrgeByContract_Customer_Username(username);
        if (urges!=null&&urges.size()!=0){
            result = Result.getSuccessInstance(urges);
            result.setMsg("查询成功");
            return result;
        }else {
            result = Result.getFailInstance("没有欠款记录",null);
            return result;
        }
    }
}
