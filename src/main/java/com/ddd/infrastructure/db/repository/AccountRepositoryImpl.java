package com.ddd.infrastructure.db.repository;

import com.ddd.domain.account.model.AccountBO;
import com.ddd.domain.account.repository.AccountRepository;
import com.ddd.infrastructure.db.mapper.AccountMapper;
import com.ddd.infrastructure.db.model.AccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author james
 * @date 2020/4/16
 */
@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void updateAccount(AccountBO accountBO) {
        accountMapper.updateAccount(new AccountPO(accountBO));
    }

    @Override
    public AccountBO getByAccountId(String accountId) {
        AccountPO accountPO = accountMapper.getByAccountId(accountId);
        AccountBO accountBO = new AccountBO(accountPO);

        //多个PO 转 BO

        return accountBO;
    }
}
