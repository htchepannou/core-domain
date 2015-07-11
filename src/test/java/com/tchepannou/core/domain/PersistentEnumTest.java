package com.tchepannou.core.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersistentEnumTest {
    @Test
    public void testConstructor(){
        PersistentEnum p = new PersistentEnum(1, "foo");

        assertThat(p.getId()).isEqualTo(1);
        assertThat(p.getName()).isEqualTo("foo");
    }

    @Test
    public void testConstructor_Default(){
        PersistentEnum p = new PersistentEnum();

        assertThat(p.getId()).isEqualTo(0);
        assertThat(p.getName()).isNull();
    }

    @Test
    public void testSetter(){
        PersistentEnum p = new PersistentEnum();
        p.setId(1);
        p.setName("foo");

        assertThat(p.getId()).isEqualTo(1);
        assertThat(p.getName()).isEqualTo("foo");
    }

    @Test
    public void testEquals_true(){
        PersistentEnum p1 = new PersistentEnum(1, "foo");
        PersistentEnum p2 = new PersistentEnum(1, "foo");

        assertThat(p1.equals(p2)).isTrue();
    }

    @Test
    public void testEquals_false(){
        PersistentEnum p1 = new PersistentEnum(1, "foo");
        PersistentEnum p2 = new PersistentEnum(2, "foo");

        assertThat(p1.equals(p2)).isFalse();
    }

    @Test
    public void testHash(){
        PersistentEnum p1 = new PersistentEnum(1, "foo");

        assertThat(p1.hashCode()).isEqualTo(1);
    }


    @Test
    public void testToString(){
        PersistentEnum p1 = new PersistentEnum(1, "foo");

        assertThat(p1.toString()).isNotNull();
    }
}
