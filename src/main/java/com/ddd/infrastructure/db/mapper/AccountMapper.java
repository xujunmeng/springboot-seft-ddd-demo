package com.ddd.infrastructure.db.mapper;


import com.ddd.infrastructure.db.model.AccountPO;

/**
 * @author james
 * @date 2020/4/16
 */
public interface AccountMapper {

    void updateAccount(AccountPO accountPO);

    AccountPO getByAccountId(String accountId);
}
