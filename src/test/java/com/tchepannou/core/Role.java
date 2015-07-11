package com.tchepannou.core;

import com.tchepannou.core.domain.PersistentEnum;

public class Role extends PersistentEnum {
    public Role() {
    }

    public Role(long id, String name) {
        super(id, name);
    }
}
