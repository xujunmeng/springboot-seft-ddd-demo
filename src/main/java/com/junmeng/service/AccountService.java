package com.junmeng.service;

import com.junmeng.entity.AccountBO;

/**
 * Created by james on 2020/4/16.
 */
public interface AccountService {

    AccountBO getAccountById(String accountId);

    int updateAccount(AccountBO accountBO);

}
