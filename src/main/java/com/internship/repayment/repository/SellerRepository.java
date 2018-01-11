package com.internship.repayment.repository;

import com.internship.repayment.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerRepository extends JpaRepository<Seller,Long> {
    @Query("select s from Seller s where s.name =:sellername")
    Seller findSellerByName(String sellername);
}
