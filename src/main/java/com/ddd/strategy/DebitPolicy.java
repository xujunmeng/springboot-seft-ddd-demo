package com.ddd.strategy;

import com.ddd.domain.AccountBO;

/**
 * Created by james on 2020/4/16.
 */
public interface DebitPolicy {

    void preDebit(AccountBO accountBO, Long amount);

    void afterDebit(AccountBO accountBO, Long amount);

}
