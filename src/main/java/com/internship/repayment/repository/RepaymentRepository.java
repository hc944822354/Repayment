package com.internship.repayment.repository;

import com.internship.repayment.entity.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepaymentRepository extends JpaRepository<Repayment,Long> {
    // 查询相关回款记录
    @Query("select r from Repayment r where r.contract.customer.name=:customername")
    Repayment findRepaymentByContract_Customer_Name(String customername);
}
