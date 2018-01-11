package com.internship.repayment.repository;

import com.internship.repayment.entity.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepaymentRepository extends JpaRepository<Repayment,Long> {
    // 查询相关回款记录
    @Query("select r from Repayment r where r.contract.customer.username=:username")
    Repayment findRepaymentByContract_Customer_Username(@Param("username") String username);
}
