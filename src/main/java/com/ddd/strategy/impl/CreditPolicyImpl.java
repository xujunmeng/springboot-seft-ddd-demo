package com.ddd.strategy.impl;

import com.ddd.domain.AccountBO;
import com.ddd.strategy.CreditPolicy;
import org.springframework.stereotype.Service;

/**
 * 入账策略实现
 * @author james
 * @date 2020/4/16
 */
@Service
public class CreditPolicyImpl implements CreditPolicy {

    @Override
    public void preCredit(AccountBO accountBO, Long amount) {
        if (accountBO.isFrozen()) {
            throw new RuntimeException("入账时账号被冻结");
        }
    }

    @Override
    public void afterCredit(AccountBO accountBO, Long amount) {
        System.out.println("afterCredit");
    }
}
