package com.ddd.domain.account.model.strategy.impl;

import com.ddd.domain.account.model.AccountBO;
import com.ddd.domain.account.model.strategy.CreditPolicy;
import org.springframework.stereotype.Service;

/**
 * @author james
 * @date 2020/4/17
 */
@Service
public class CreditPolicyImpl implements CreditPolicy {

    @Override
    public void preCredit(AccountBO accountBO, Long amount) {

    }

    @Override
    public void afterCredit(AccountBO accountBO, Long amount) {

    }
}
