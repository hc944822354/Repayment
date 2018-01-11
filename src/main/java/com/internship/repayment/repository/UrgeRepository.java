package com.internship.repayment.repository;

import com.internship.repayment.entity.Urge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UrgeRepository extends JpaRepository<Urge,Long>{
    // 查询催款信息
    @Query("select u from Urge u where u.contract.customer.name=:customername")
    public Urge findUrgeByContract_Customer_Name(String customername);
}
