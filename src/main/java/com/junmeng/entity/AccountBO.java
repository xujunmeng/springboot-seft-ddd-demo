package com.junmeng.entity;

/**
 * 账户业务对象
 * @author james
 * @date 2020/4/16
 */
public class AccountBO {

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
}
