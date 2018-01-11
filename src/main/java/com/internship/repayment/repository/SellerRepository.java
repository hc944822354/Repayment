package com.internship.repayment.repository;

import com.internship.repayment.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellerRepository extends JpaRepository<Seller,Long> {
    @Query("select s from Seller s where s.username =:username")
    Seller findSellerByName(@Param("username") String username);


}
