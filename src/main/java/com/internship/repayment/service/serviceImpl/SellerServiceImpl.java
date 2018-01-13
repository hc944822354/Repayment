package com.internship.repayment.service.serviceImpl;

import com.internship.repayment.VO.Result;
import com.internship.repayment.entity.Contract;

import com.internship.repayment.entity.Seller;
import com.internship.repayment.repository.ContractRepository;
import com.internship.repayment.repository.SellerRepository;
import com.internship.repayment.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Result <List<Seller> >querySeller(String username){
        List<Contract> contracts=contractRepository.findContractsByCustomer_Username(username);
        Result<List<Seller>> results;
        if(contracts!=null) {
            List<Seller> sellers = new LinkedList<Seller>();
            for (Contract contract : contracts
                    ) {
                sellers.add(contract.getSeller());

            }
            results=Result.getSuccessInstance(sellers);
            results.setMsg("查询成功");
        }
        else
            results=Result.getFailInstance("没有负责销售员",null);

        return results;

    }

    @Autowired
    private SellerRepository sellerRepository;


    @Override
    public Result<Seller> login(String username, String password) {
        Seller seller = sellerRepository.findSellerByName(username);
        //账户存在且密码正确
        Result<Seller> result;
        if (seller!=null&&seller.getPassword().equals(password)){
            result = Result.getSuccessInstance(seller);
            result.setMsg("登陆成功");
        }else if (seller!=null){
            result = Result.getFailInstance("密码错误",seller);
        }else {
            result = Result.getFailInstance("账户不存在",null);
        }
        return result;
    }

}
