package com.internship.repayment.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Urge {
    @Id
    @GeneratedValue
    private Long urgeid;

    @JoinColumn(name = "contractid")
    @ManyToOne
    private Contract contract;

    @Temporal(TemporalType.TIMESTAMP)
    private Date urgetime;

    public Long getUrgeid() {
        return urgeid;
    }

    public void setUrgeid(Long urgeid) {
        this.urgeid = urgeid;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Date getUrgetime() {
        return urgetime;
    }

    public void setUrgetime(Date urgetime) {
        this.urgetime = urgetime;
    }
}
