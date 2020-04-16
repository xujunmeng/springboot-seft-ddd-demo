package com.ddd.domain;

import com.ddd.strategy.CreditPolicy;
import com.ddd.strategy.DebitPolicy;

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

    /**
     * 出借策略
     */
    private DebitPolicy debitPolicy;

    /**
     * 入账策略
     */
    private CreditPolicy creditPolicy;

    /**
     * 出借方法
     *
     * @param amount 金额
     */
    public void debit(Long amount) {
        debitPolicy.preDebit(this, amount);
        this.balance -= amount;
        debitPolicy.afterDebit(this, amount);
    }

    /**
     * 转入方法
     */
    public void credit(Long amount) {
        creditPolicy.preCredit(this, amount);
        this.balance += amount;
        creditPolicy.afterCredit(this, amount);
    }

    /**
     * BO和DO转换必须加set方法这是一种权衡
     */
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

    public DebitPolicy getDebitPolicy() {
        return debitPolicy;
    }

    public void setDebitPolicy(DebitPolicy debitPolicy) {
        this.debitPolicy = debitPolicy;
    }

    public CreditPolicy getCreditPolicy() {
        return creditPolicy;
    }

    public void setCreditPolicy(CreditPolicy creditPolicy) {
        this.creditPolicy = creditPolicy;
    }
}
