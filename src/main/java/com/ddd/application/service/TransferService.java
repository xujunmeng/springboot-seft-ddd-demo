package com.ddd.application.service;

/**
 * Created by james on 2020/4/16.
 */
public interface TransferService {

    boolean transfer(String fromAccountId, String toAccountId, Long amount);

}
