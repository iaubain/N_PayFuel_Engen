/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.oltranz.pf.n_payfuel_engen.models.vouchers;


/**
 * @author manzi
 */
public class Voucher {
    private Integer id;
    private String voucherNumber;
    private Integer voucherAmount;
    private boolean isValid;
    private String recordDate;
    private String holder;
    private MerchantCustomer customerMerchant;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the voucherNumber
     */
    public String getVoucherNumber() {
        return voucherNumber;
    }

    /**
     * @param voucherNumber the voucherNumber to set
     */
    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    /**
     * @return the voucherAmount
     */
    public Integer getVoucherAmount() {
        return voucherAmount;
    }

    /**
     * @param voucherAmount the voucherAmount to set
     */
    public void setVoucherAmount(Integer voucherAmount) {
        this.voucherAmount = voucherAmount;
    }

    /**
     * @return the isValid
     */
    public boolean getIsValid() {
        return isValid;
    }

    /**
     * @param isValid the isValid to set
     */
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    /**
     * @return the recordDate
     */
    public String getRecordDate() {
        return recordDate;
    }

    /**
     * @param recordDate the recordDate to set
     */
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * @return the holder
     */
    public String getHolder() {
        return holder;
    }

    /**
     * @param holder the holder to set
     */
    public void setHolder(String holder) {
        this.holder = holder;
    }

    /**
     * @return the customerMerchant
     */
    public MerchantCustomer getCustomerMerchant() {
        return customerMerchant;
    }

    /**
     * @param customerMerchant the customerMerchant to set
     */
    public void setCustomerMerchant(MerchantCustomer customerMerchant) {
        this.customerMerchant = customerMerchant;
    }


}
