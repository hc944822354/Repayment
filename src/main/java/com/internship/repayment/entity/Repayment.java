package com.internship.repayment.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Repayment {
    @Id
    @GeneratedValue
    private Long rapaymentid;

    @ManyToOne
    @JoinColumn(name = "contractid")
    private Contract contract;

    private String rapaymentname;

    private Date paytime;

    private Double paymoney;

    public Long getRapaymentid() {
        return rapaymentid;
    }

    public void setRapaymentid(Long rapaymentid) {
        this.rapaymentid = rapaymentid;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getRapaymentname() {
        return rapaymentname;
    }

    public void setRapaymentname(String rapaymentname) {
        this.rapaymentname = rapaymentname;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Double getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Double paymoney) {
        this.paymoney = paymoney;
    }
}
