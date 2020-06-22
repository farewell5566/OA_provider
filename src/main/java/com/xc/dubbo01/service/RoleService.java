package com.xc.dubbo01.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.dubbo01.Stas;
import com.xc.dubbo01.entity.Role;
import com.xc.dubbo01.mapper.RoleExample;
import com.xc.dubbo01.mapper.RoleMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0",timeout = 100000,interfaceClass = IRoleService.class)
public class RoleService implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public PageInfo<Role> findAll(int pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        RoleExample roleExam = new RoleExample();
        List<Role> roleData = roleMapper.selectByExample(roleExam);

/*        System.out.println(roleData.size());
        return null;*/

        System.out.println(ToStringBuilder.reflectionToString(roleData));
        return new PageInfo<>(roleData, 3);
    }

    @Override
    public Role findById(Integer id) {
        return roleMapper.selectByID(id);
        //return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Stas updateRolePer(int id, int[] idData) {

        for (int idP : idData) {
            System.out.println("id:  " + id);
            System.out.println("idP:  " + idP);
            roleMapper.updataRolePer(id, idP);
        }

        //roleMapper.updateRolePers(id,idData);

        return Stas.build(200);
    }
}
