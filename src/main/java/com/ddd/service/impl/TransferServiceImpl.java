package com.ddd.service.impl;

import com.ddd.domain.AccountBO;
import com.ddd.service.AccountService;
import com.ddd.service.TransferService;
import com.ddd.strategy.CreditPolicy;
import com.ddd.strategy.DebitPolicy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author james
 * @date 2020/4/16
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Resource
    private AccountService accountService;

    @Resource
    private CreditPolicy creditPolicy;

    @Resource
    private DebitPolicy debitPolicy;

    @Override
    public boolean transfer(String fromAccountId, String toAccountId, Long amount) {
        AccountBO fromAccount = accountService.getAccountById(fromAccountId);
        fromAccount.setDebitPolicy(debitPolicy);
        fromAccount.debit(amount);

        AccountBO toAccount = accountService.getAccountById(toAccountId);
        toAccount.setCreditPolicy(creditPolicy);
        toAccount.credit(amount);

        accountService.updateAccount(fromAccount);
        accountService.updateAccount(toAccount);
        return true;
    }
}
