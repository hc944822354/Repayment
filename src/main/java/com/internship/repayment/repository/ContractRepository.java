package com.internship.repayment.repository;

import com.internship.repayment.entity.Contract;
import com.internship.repayment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Long> {
    // 根据合同名来查询合同信息
    @Query("select c from Contract c where c.contractname=:contractname")
    Contract findContractByContractname(@Param("contractname") String contractname);

    // 根据账号查询用户相关合同
    //Query("select n from Contract c where c.customer.username=:username")
    //List<Contract> findContractsByCustomer_Username(@Param("username") String username);

    //根据账号查询销售员相关合同
    @Query("select c from Contract c where c.seller.username=:username")
    List<Contract> findContractsBySeller_Username(@Param("username") String username);

    //根据销售员账号查询销售员相关所有客户
    @Query("select c.customer from Contract c where c.seller.username =:username")
    List<Customer> findCustomersBySellerUername(@Param("username") String username);
}
