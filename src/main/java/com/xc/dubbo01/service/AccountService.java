package com.xc.dubbo01.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xc.dubbo01.Stas;
import com.xc.dubbo01.entity.Account;
import com.xc.dubbo01.entity.Role;
import com.xc.dubbo01.mapper.AccountDAO;
import com.xc.dubbo01.mapper.AccountExample;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0",timeout = 100000,interfaceClass = IAccountService.class)
public class AccountService implements IAccountService {


    @Autowired
    AccountDAO accMapper;


    @Override
    public Account findByLoginNameAndPassword(String loginName, String password) {
        AccountExample accExample = new AccountExample();
        accExample.createCriteria()
                .andLoginNameEqualTo(loginName)
                .andPasswordEqualTo(password);

        List<Account> accounts = accMapper.selectByExample(accExample);

        return accounts.size() == 1 ? accounts.get(0) : null;
    }

    @Override
    public PageInfo<Account> findAll(int pageNum, Integer pageSize) {


        List<Account> accAllData = accMapper.findAll();
        Account acc = accAllData.get(0);
        Role role = accAllData.get(0).getRoles().get(0);

        System.out.println("-------");
        System.out.println(accAllData.size());

        System.out.println(ToStringBuilder.reflectionToString(role));
        System.out.println(ToStringBuilder.reflectionToString(acc.getRoles().get(0)));
        System.out.println(ToStringBuilder.reflectionToString(acc.getPermissions().get(0)));

        System.out.println("-------");

        List<Account> accData = accMapper.selectByExample(new AccountExample());


        PageHelper.startPage(pageNum, pageSize);
        System.out.println("pageNum" + pageNum);
        System.out.println("pageSize" + pageSize);
        return new PageInfo<Account>(accData, 3);
    }

    @Override
    public Stas deleteById(int id) {
        AccountExample accExample = new AccountExample();
        accExample.createCriteria().andIdEqualTo(id);

        int row = accMapper.deleteByExample(accExample);
        Stas stas = new Stas();

        return row == 1 ? stas.build(200) : stas.error("没有删除数据");

    }

    @Override
    public void updataAccount(Account acc) {
        accMapper.updateByPrimaryKeySelective(acc);
    }
}
