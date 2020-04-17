package com.ddd.domain.account.repository;

import com.ddd.domain.account.model.AccountBO;

/**
 * Created by james on 2020/4/17.
 */
public interface AccountRepository {

    /**
     *
     * @param accountBO
     */
    void updateAccount(AccountBO accountBO);

    /**
     *
     * @param accountId
     * @return
     */
    AccountBO getByAccountId(String accountId);

}
