package com.example.testproject.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class PdwPfsStatBanCarrierRecord implements Serializable {
    private String invoiceNumber;
    private String invoiceDate;
    private String sellerId;
    private String processTime;
    private String invYm;
    private String carrierType;
    private String carrierId2;
    private BigDecimal totalAmount;
    private String createdBy;
    private String createdDate;
    private String createdIp;
    private String createdFunc;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private String lastModifiedIp;
    private String lastModifiedFunc;


    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public String getInvYm() {
        return invYm;
    }

    public void setInvYm(String invYm) {
        this.invYm = invYm;
    }

    public String getCarrierType() {
        return carrierType;
    }

    public void setCarrierType(String carrierType) {
        this.carrierType = carrierType;
    }

    public String getCarrierId2() {
        return carrierId2;
    }

    public void setCarrierId2(String carrierId2) {
        this.carrierId2 = carrierId2;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedIp() {
        return createdIp;
    }

    public void setCreatedIp(String createdIp) {
        this.createdIp = createdIp;
    }

    public String getCreatedFunc() {
        return createdFunc;
    }

    public void setCreatedFunc(String createdFunc) {
        this.createdFunc = createdFunc;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedIp() {
        return lastModifiedIp;
    }

    public void setLastModifiedIp(String lastModifiedIp) {
        this.lastModifiedIp = lastModifiedIp;
    }

    public String getLastModifiedFunc() {
        return lastModifiedFunc;
    }

    public void setLastModifiedFunc(String lastModifiedFunc) {
        this.lastModifiedFunc = lastModifiedFunc;
    }
}
