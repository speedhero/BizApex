package com.apex.presistence.beans;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "TST_PRODUCT")
public class TstProduct {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRD_NAME")
    private String prdName;

    @Column(name = "PRD_NUM")
    private String prdNum;

    @Column(name = "PRD_PRICE")
    private BigDecimal prdPrice;

    @Column(name = "SUBTABLE")
    private String subtable;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return PRD_NAME
     */
    public String getPrdName() {
        return prdName;
    }

    /**
     * @param prdName
     */
    public void setPrdName(String prdName) {
        this.prdName = prdName == null ? null : prdName.trim();
    }

    /**
     * @return PRD_NUM
     */
    public String getPrdNum() {
        return prdNum;
    }

    /**
     * @param prdNum
     */
    public void setPrdNum(String prdNum) {
        this.prdNum = prdNum == null ? null : prdNum.trim();
    }

    /**
     * @return PRD_PRICE
     */
    public BigDecimal getPrdPrice() {
        return prdPrice;
    }

    /**
     * @param prdPrice
     */
    public void setPrdPrice(BigDecimal prdPrice) {
        this.prdPrice = prdPrice;
    }

    /**
     * @return SUBTABLE
     */
    public String getSubtable() {
        return subtable;
    }

    /**
     * @param subtable
     */
    public void setSubtable(String subtable) {
        this.subtable = subtable == null ? null : subtable.trim();
    }
}