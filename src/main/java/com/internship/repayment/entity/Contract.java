package com.internship.repayment.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Contract {
    @Id
    @GeneratedValue
    private Long contractid;

    @JoinColumn(name = "customerid")
    @ManyToOne
    private Customer customer;

    @JoinColumn(name = "sellerid")
    @ManyToOne
    private Seller seller;

    private String contractname;

    @Temporal(TemporalType.TIMESTAMP)
    private Date begintime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cuttime;

    private Double summoney;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getContractid() {
        return contractid;
    }

    public void setContractid(Long contractid) {
        this.contractid = contractid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getContractname() {
        return contractname;
    }

    public void setContractname(String contractname) {
        this.contractname = contractname;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getCuttime() {
        return cuttime;
    }

    public void setCuttime(Date cuttime) {
        this.cuttime = cuttime;
    }

    public Double getSummoney() {
        return summoney;
    }

    public void setSummoney(Double summoney) {
        this.summoney = summoney;
    }
}
