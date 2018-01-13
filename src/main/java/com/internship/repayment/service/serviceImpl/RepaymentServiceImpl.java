package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Repayment;
import com.internship.repayment.repository.RepaymentRepository;
import com.internship.repayment.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RepaymentServiceImpl implements RepaymentService {
    @Autowired
    private RepaymentRepository repaymentRepository;

    @Override
    public Result<List<Repayment>> queryRepayment(String username){
        List<Repayment> repayments=repaymentRepository.findRepaymentByContract_Customer_Username(username);
        Result<List<Repayment>> results;
        if(repayments!=null){
            results=Result.getSuccessInstance(repayments);
            results.setMsg("查询成功");
        }
        else
            results=Result.getFailInstance("没有回款记录",null);
        return results;
    }
}
