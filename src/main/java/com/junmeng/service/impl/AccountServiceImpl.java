package com.junmeng.service.impl;

import com.junmeng.entity.AccountBO;
import com.junmeng.service.AccountService;
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
