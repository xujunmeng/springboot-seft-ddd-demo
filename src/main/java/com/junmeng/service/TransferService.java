package com.junmeng.service;

/**
 * @author james
 * @date 2020/4/16
 */
public interface TransferService {

    boolean transfer(String fromAccountId, String toAccountId, Long amount);

}
