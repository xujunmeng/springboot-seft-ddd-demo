package com.junmeng.service.impl;

import com.junmeng.entity.AccountBO;
import com.junmeng.service.AccountService;
import com.junmeng.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author james
 * @date 2020/4/16
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountService accountService;

    @Override
    public boolean transfer(String fromAccountId, String toAccountId, Long amount) {
        AccountBO fromAccount = accountService.getAccountById(fromAccountId);
        AccountBO toAccount = accountService.getAccountById(toAccountId);

        //检查转出账号
        if (fromAccount.isFrozen()) {
            throw new RuntimeException("fromAccount被冻结");
        }
        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("余额不足");
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);

        //检查转入账号
        if (toAccount.isFrozen()) {
            throw new RuntimeException("toAccount被冻结");
        }
        toAccount.setBalance(toAccount.getBalance() + amount);

        //更新数据库
        accountService.updateAccount(fromAccount);
        accountService.updateAccount(toAccount);
        return true;
    }

}
