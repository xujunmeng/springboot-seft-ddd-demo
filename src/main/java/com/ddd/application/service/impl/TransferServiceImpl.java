package com.ddd.application.service.impl;

import com.ddd.application.service.TransferService;
import com.ddd.domain.account.model.AccountBO;
import com.ddd.domain.account.model.strategy.CreditPolicy;
import com.ddd.domain.account.model.strategy.DebitPolicy;
import com.ddd.domain.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author james
 * @date 2020/4/16
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Resource
    private CreditPolicy creditPolicy;

    @Resource
    private DebitPolicy debitPolicy;

    @Resource
    private AccountRepository accountRepository;

    @Transactional
    @Override
    public boolean transfer(String fromAccountId, String toAccountId, Long amount) {
        AccountBO fromAccount = accountRepository.getByAccountId(fromAccountId);
        fromAccount.setDebitPolicy(debitPolicy);
        fromAccount.debit(amount);
        fromAccount.save();

        AccountBO toAccount = accountRepository.getByAccountId(toAccountId);
        toAccount.setCreditPolicy(creditPolicy);
        toAccount.credit(amount);
        toAccount.save();

        //下面封装到一个领域里面处理
        //三方服务调用
        //1.查Account手机号
        //2.发送短信，调用外部接口

        //消息
        return true;
    }
}
