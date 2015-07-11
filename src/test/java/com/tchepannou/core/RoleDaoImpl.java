package com.tchepannou.core;

import com.tchepannou.core.dao.impl.AbstractPersistentEnumDaoImpl;

import javax.sql.DataSource;

public class RoleDaoImpl  extends AbstractPersistentEnumDaoImpl<Role> implements RoleDao{
    public RoleDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getTableName() {
        return "t_role";
    }

    @Override
    protected Role createPersistenEnum() {
        return new Role ();
    }
}
