package com.ddd.strategy.impl;

import com.ddd.domain.AccountBO;
import com.ddd.strategy.DebitPolicy;
import org.springframework.stereotype.Service;

/**
 * 出借策略实现
 * @author james
 * @date 2020/4/16
 */
@Service
public class DebitPolicyImpl implements DebitPolicy {

    @Override
    public void preDebit(AccountBO accountBO, Long amount) {
        if (accountBO.isFrozen()) {
            throw new RuntimeException("出借时账号被冻结");
        }
        if (accountBO.getBalance() < amount) {
            throw new RuntimeException("出借时余额不足");
        }
    }

    @Override
    public void afterDebit(AccountBO accountBO, Long amount) {
        System.out.println("afterDebit");
    }
}
