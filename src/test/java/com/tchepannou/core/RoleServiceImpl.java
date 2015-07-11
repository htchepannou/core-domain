package com.tchepannou.core;

import com.tchepannou.core.dao.AbstractPersistentEnumDao;
import com.tchepannou.core.service.impl.AbstractPersistentEnumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl extends AbstractPersistentEnumServiceImpl<Role> implements RoleService{
    @Autowired
    private RoleDao dao;

    @Override
    protected AbstractPersistentEnumDao<Role> getDao() {
        return dao;
    }
}
