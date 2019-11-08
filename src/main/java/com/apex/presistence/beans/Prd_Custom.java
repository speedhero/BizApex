package com.apex.presistence.beans;

import javax.persistence.*;

@Table(name = "PRD_CUSTM")
public class Prd_Custom {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "IS_NEED_VIP")
    private Long isNeedVip;

    @Column(name = "VIP_USER")
    private Long vipUser;

    @Column(name = "PRD_TYPE")
    private Long prdType;

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
     * @return IS_NEED_VIP
     */
    public Long getIsNeedVip() {
        return isNeedVip;
    }

    /**
     * @param isNeedVip
     */
    public void setIsNeedVip(Long isNeedVip) {
        this.isNeedVip = isNeedVip;
    }

    /**
     * @return VIP_USER
     */
    public Long getVipUser() {
        return vipUser;
    }

    /**
     * @param vipUser
     */
    public void setVipUser(Long vipUser) {
        this.vipUser = vipUser;
    }

    /**
     * @return PRD_TYPE
     */
    public Long getPrdType() {
        return prdType;
    }

    /**
     * @param prdType
     */
    public void setPrdType(Long prdType) {
        this.prdType = prdType;
    }
}