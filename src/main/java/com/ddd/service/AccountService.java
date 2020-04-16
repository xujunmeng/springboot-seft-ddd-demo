package com.ddd.service;

import com.ddd.domain.AccountBO;

/**
 * Created by james on 2020/4/16.
 */
public interface AccountService {

    AccountBO getAccountById(String accountId);

    int updateAccount(AccountBO accountBO);

}
