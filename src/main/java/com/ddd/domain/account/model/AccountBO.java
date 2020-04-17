package com.ddd.domain.account.model;

import com.ddd.domain.account.model.strategy.CreditPolicy;
import com.ddd.domain.account.model.strategy.DebitPolicy;
import com.ddd.domain.account.repository.AccountRepository;
import com.ddd.infrastructure.db.mapper.AccountMapper;
import com.ddd.infrastructure.db.model.AccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 账户业务对象
 * @author james
 * @date 2020/4/16
 */
@Component
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

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper = null;

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

    public void updateAccount() {
        accountRepository.updateAccount(this);
    }

    public AccountBO getAccountById(String accountId) {
        return accountRepository.getByAccountId(accountId);
    }

    public AccountBO(AccountPO accountPO) {
        this.setAccountId(accountPO.getAccountId());
        this.setBalance(accountPO.getBalance());
        this.setFrozen(accountPO.isFrozen());
    }

    public void save() {
        AccountPO accountPO = new AccountPO();
        accountPO.setAccountId(this.getAccountId());
        accountPO.setBalance(this.getBalance());
        accountPO.setFrozen(this.isFrozen());
        accountPO.setCreateDt(new Date());
        accountMapper.updateAccount(accountPO);
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
