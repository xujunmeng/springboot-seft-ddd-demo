package com.ddd.service.impl;

import com.ddd.domain.AccountBO;
import com.ddd.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author james
 * @date 2020/4/16
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public AccountBO getAccountById(String accountId) {
        return null;
    }

    @Override
    public int updateAccount(AccountBO accountBO) {
        return 0;
    }
}
