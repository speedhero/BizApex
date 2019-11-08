package com.apex.bussiness.entity;

import com.apex.bussiness.framework.object.AbstractBO;
import com.apex.presistence.beans.TstProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class Product extends AbstractBO {

    private TstProduct tstProduct;

    public Product() {
        this.tstProduct = new TstProduct();
    }

    public Product(TstProduct tstProduct) {
        this.tstProduct = tstProduct;
    }
    @JsonIgnore
    public TstProduct getTstProduct() {
        return this.tstProduct;
    }

    /**
     * @return ID
     */
    public Long getId() {
        return this.tstProduct.getId();
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.tstProduct.setId(id);
    }

    /**
     * @return PRD_NAME
     */
    public String getPrdName() {
        return this.tstProduct.getPrdName();
    }

    /**
     * @param prdName
     */
    public void setPrdName(String prdName) {
        this.tstProduct.setPrdName(prdName);
    }

    /**
     * @return PRD_NUM
     */
    public String getPrdNum() {
        return this.tstProduct.getPrdNum();
    }

    /**
     * @param prdNum
     */
    public void setPrdNum(String prdNum) {
        this.tstProduct.setPrdNum(prdNum);
    }

    /**
     * @return PRD_PRICE
     */
    public BigDecimal getPrdPrice() {
        return  this.tstProduct.getPrdPrice();
    }

    /**
     * @param prdPrice
     */
    public void setPrdPrice(BigDecimal prdPrice) {
        this.tstProduct.setPrdPrice(prdPrice);
    }

    /**
     * @return SUBTABLE
     */
    public String getSubtable() {
        return  this.tstProduct.getSubtable();
    }

    /**
     * @param subtable
     */
    public void setSubtable(String subtable) {
        this.tstProduct.setSubtable(subtable);
    }
}
