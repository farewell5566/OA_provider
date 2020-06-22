package com.xc.dubbo01.mapper;

import com.xc.dubbo01.entity.Permission;

import org.springframework.stereotype.Repository;

/**
 * PermissionMapper继承基类
 */
@Repository
public interface PermissionMapper extends MyBatisBaseDao<Permission, Integer, PermissionExample> {
}