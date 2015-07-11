package com.tchepannou.core.domain;

public class PersistentEnum extends Persistent {
    //-- Attributes
    private String name;

    //-- Constructor
    public PersistentEnum (){

    }
    public PersistentEnum (long id, String name) {
        super(id);
        this.name = name;
    }

    //-- Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
