package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Bill;
import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Repayment;
import com.internship.repayment.repository.ContractRepository;
import com.internship.repayment.repository.RepaymentRepository;
import com.internship.repayment.service.BillService;
import com.internship.repayment.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private RepaymentRepository repaymentRepository ;
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Result<List<Bill>> queryBill(String username) {
        List<Contract> contractList = contractRepository.findContractsByCustomer_Username(username);
        List<Bill> billList = new ArrayList<>();
        for (Contract c:contractList) {
            List<Repayment> repaymentList = repaymentRepository.findRepaymentByContract_Contractid(c.getContractid());
            Bill b = new Bill();
            Double repaymentSum = 0.0;
            for (Repayment r:repaymentList) {
                repaymentSum+=r.getPaymoney();
            }
            b.setContractid(c.getContractid());
            b.setCustomerid(c.getCustomer().getCustomerid());
            b.setCustomername(c.getCustomer().getName());
            b.setBillbegintime(c.getBegintime());
            b.setBillcuttime(c.getCuttime());
            b.setBillcontractnname(c.getContractname());
            b.setBillsummoney(repaymentSum);
            b.setBillremainmoney(c.getSummoney()-repaymentSum);
            b.setBillreturnSummoney(repaymentSum);
            billList.add(b);
        }
        Result<List<Bill>> result;
        if (billList.size() == 0){
            result = Result.getFailInstance("无账单",null);
        }else {
            result = Result.getSuccessInstance(billList);
        }
        return result;
    }
}
