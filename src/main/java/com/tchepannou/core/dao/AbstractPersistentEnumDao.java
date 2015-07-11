package com.tchepannou.core.dao;

import com.tchepannou.core.domain.PersistentEnum;

import java.util.List;

public interface AbstractPersistentEnumDao<T extends PersistentEnum> {
    T findById(long id);

    T findByName(String name);

    List<T> findAll();
}
