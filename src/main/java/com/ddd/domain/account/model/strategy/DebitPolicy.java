package com.ddd.domain.account.model.strategy;

import com.ddd.domain.account.model.AccountBO;

/**
 * Created by james on 2020/4/16.
 */
public interface DebitPolicy {

    void preDebit(AccountBO accountBO, Long amount);

    void afterDebit(AccountBO accountBO, Long amount);

}
