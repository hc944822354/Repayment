package com.internship.repayment.repository;

import com.internship.repayment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select c from Customer c where c.username=:username")
    Customer findCustomerByUsername(@Param("username")String username);

    @Query("select c from Customer c where c in ?1")
    List<Customer> findCustomerInCustomerList(List<Customer> customers);


}
