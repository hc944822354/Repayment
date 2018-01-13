package com.internship.repayment.entity;

import java.util.Date;

public class Bill {
    private Long customerid;
    private String customername;
    private String billcontractnname;
    private Date billcuttime;
    private Date billbegintime;
    private Double billsummoney;
    private Double billreturnSummoney;
    private Double billremainmoney;
    private Long contractid;

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getBillcontractnname() {
        return billcontractnname;
    }

    public void setBillcontractnname(String billcontractnname) {
        this.billcontractnname = billcontractnname;
    }

    public Date getBillcuttime() {
        return billcuttime;
    }

    public void setBillcuttime(Date billcuttime) {
        this.billcuttime = billcuttime;
    }

    public Date getBillbegintime() {
        return billbegintime;
    }

    public void setBillbegintime(Date billbegintime) {
        this.billbegintime = billbegintime;
    }

    public Double getBillsummoney() {
        return billsummoney;
    }

    public void setBillsummoney(Double billsummoney) {
        this.billsummoney = billsummoney;
    }

    public Double getBillreturnSummoney() {
        return billreturnSummoney;
    }

    public void setBillreturnSummoney(Double billreturnSummoney) {
        this.billreturnSummoney = billreturnSummoney;
    }

    public Double getBillremainmoney() {
        return billremainmoney;
    }

    public void setBillremainmoney(Double billremainmoney) {
        this.billremainmoney = billremainmoney;
    }

    public Long getContractid() {
        return contractid;
    }

    public void setContractid(Long contractid) {
        this.contractid = contractid;
    }
}
