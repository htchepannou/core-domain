package com.tchepannou.core.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Base class of persistent
 */
public class Persistent implements Serializable{
    //-- Attribute
    private long id;

    //-- Constructor
    public Persistent(){

    }
    public Persistent(long id){
        this.id = id;
    }

    //-- Getter/Setter
    public final long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    //-- Object overrides
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
