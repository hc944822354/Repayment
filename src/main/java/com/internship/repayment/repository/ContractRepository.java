package com.internship.repayment.repository;

import com.internship.repayment.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Long> {
    // 根据合同名来查询合同信息
    @Query("select c from Contract c where c.contractname=:contractname")
    Contract findContractByContractname(String contractname);

    // 查询用户名相关合同
    @Query("select n from Contract c where c.customer.username=:username")
    List<Contract> findContractsByCustomer_Username(String username);
}
