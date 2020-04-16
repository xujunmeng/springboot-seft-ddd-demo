package com.ddd.strategy;

import com.ddd.domain.AccountBO;

/**
 * Created by james on 2020/4/16.
 */
public interface CreditPolicy {

    void preCredit(AccountBO accountBO, Long amount);

    void afterCredit(AccountBO accountBO, Long amount);

}
