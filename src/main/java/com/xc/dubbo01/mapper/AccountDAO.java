package com.xc.dubbo01.mapper;

import com.xc.dubbo01.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccountDAO继承基类
 */
@Repository
public interface AccountDAO extends MyBatisBaseDao<Account, Integer, AccountExample> {
    List<Account> findAll();
}