package com.apex.presistence.beans;

import javax.persistence.*;

@Table(name = "TSEQUENCE")
public class IDGenerator {
    @Id
    @Column(name = "NAME")
    private String name;

    @Column(name = "ID")
    private Integer id;

    @Column(name = "RANGE_NO")
    private Long rangeNo;

    @Column(name = "RANGE_SIZE")
    private Long rangeSize;

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return RANGE_NO
     */
    public Long getRangeNo() {
        return rangeNo;
    }

    /**
     * @param rangeNo
     */
    public void setRangeNo(Long rangeNo) {
        this.rangeNo = rangeNo;
    }

    /**
     * @return RANGE_SIZE
     */
    public Long getRangeSize() {
        return rangeSize;
    }

    /**
     * @param rangeSize
     */
    public void setRangeSize(Long rangeSize) {
        this.rangeSize = rangeSize;
    }
}