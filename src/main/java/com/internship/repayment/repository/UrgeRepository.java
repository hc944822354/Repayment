package com.internship.repayment.repository;

import com.internship.repayment.entity.Urge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UrgeRepository extends JpaRepository<Urge,Long>{
    // 查询催款信息
    @Query("select u from Urge u where u.contract.customer.username=:username")
    public Urge findUrgeByContract_Customer_Username(@Param("username") String username);
}
