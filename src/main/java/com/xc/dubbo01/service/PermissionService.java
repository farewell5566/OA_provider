package com.xc.dubbo01.service;


import com.github.pagehelper.PageInfo;
import com.xc.dubbo01.Stas;
import com.xc.dubbo01.entity.Permission;
import com.xc.dubbo01.mapper.PermissionExample;
import com.xc.dubbo01.mapper.PermissionMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service(version = "1.0.0",timeout = 100000,interfaceClass = IPermissionService.class)
public class PermissionService implements IPermissionService {

    @Autowired
    PermissionMapper perMapper;

    @Override
    public PageInfo<Permission> findAll(int pageNum, Integer pageSize) {

        PageInfo<Permission> pageInfos = new PageInfo<>(perMapper.selectByExample(new PermissionExample()));
        return pageInfos;


    }

    @Override
    public Permission findById(Integer id) {
        return perMapper.selectByPrimaryKey(id);
    }

    @Override
    public Stas update(Permission per) {
        int rows = 0;

        if (null != perMapper.selectByPrimaryKey(per.getId())) {
            rows = perMapper.updateByPrimaryKeySelective(per);
        } else {
            rows = perMapper.insert(per);
        }
        return rows == 1 ? Stas.build(200) : Stas.error("Dont Update Permission");

    }

    @Override
    public List<Permission> findName() {
        PermissionExample perEx = new PermissionExample();
        perEx.createCriteria().andNameIsNotNull();
        return perMapper.selectByExample(perEx);
    }

    @Override
    public List<Permission> findAll() {
        return perMapper.selectByExample(new PermissionExample());
    }
}
