package com.internship.repayment.repository;

import com.internship.repayment.entity.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RepaymentRepository extends JpaRepository<Repayment,Long> {
    // 查询相关回款记录
    @Query("select r from Repayment r where r.contract.customer.username=:username")
    List<Repayment> findRepaymentByContract_Customer_Username(@Param("username") String username);

    @Query("select r from Repayment r where r.contract.contractid =:contractid")
    List<Repayment> findRepaymentByContract_Contractid(@Param("contractid")Long contractid);
}
