package com.ddd.infrastructure.db.model;

import com.ddd.domain.account.model.AccountBO;

import java.util.Date;

/**
 * @author james
 * @date 2020/4/16
 */
public class AccountPO {

    private Integer id;

    /**
     * 账户ID
     */
    private String accountId;

    /**
     * 账户余额
     */
    private Long balance;

    /**
     * 是否冻结
     */
    private boolean isFrozen;

    private Date createDt;

    public AccountPO() {
    }

    public AccountPO(AccountBO accountBO) {
        this.accountId = accountBO.getAccountId();
        this.balance = accountBO.getBalance();
        this.isFrozen = accountBO.isFrozen();
        this.createDt = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}
