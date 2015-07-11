package com.tchepannou.core.service.impl;

import com.tchepannou.core.dao.AbstractPersistentEnumDao;
import com.tchepannou.core.domain.PersistentEnum;
import com.tchepannou.core.exception.NotFoundException;
import com.tchepannou.core.service.AbstractPersistentEnumService;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractPersistentEnumServiceImpl<T extends PersistentEnum> implements AbstractPersistentEnumService<T> {
    //-- Abstract methods
    protected abstract AbstractPersistentEnumDao<T> getDao ();

    //-- AbstractPersistentEnumService overrides
    @Override
    public T findById(final long id) {
        T purpose = getDao().findById(id);
        if (purpose == null){
            throw new NotFoundException(id, getPersistentClass());
        }
        return purpose;
    }

    @Override
    public T findByName(final String name) {
        T purpose = name != null ? getDao().findByName(name) : null;
        if (purpose == null){
            throw new NotFoundException(name, getPersistentClass());
        }
        return purpose;
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    //-- Protected
    protected Class getPersistentClass () {
        return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}