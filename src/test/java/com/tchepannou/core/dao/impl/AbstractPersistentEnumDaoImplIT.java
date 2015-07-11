package com.tchepannou.core.dao.impl;

import com.tchepannou.core.Role;
import com.tchepannou.core.RoleDao;
import com.tchepannou.core.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class AbstractPersistentEnumDaoImplIT {
    @Autowired
    private RoleDao roleDao;

    @Test
    public void testFindById() throws Exception {
        // When
        Role role = roleDao.findById(1);

        // Then
        assertThat(role).isEqualTo(new Role(1, "admin"));
    }
    @Test
    public void testFindById_badId() throws Exception {
        // When
        Role role = roleDao.findById(999);

        // Then
        assertThat(role).isNull();
    }

    @Test
    public void testFindByName() throws Exception {
        // When
        Role role = roleDao.findByName("admin");

        // Then
        assertThat(role).isEqualTo(new Role(1, "admin"));

    }
    @Test
    public void testFindByName_badName() throws Exception {
        // When
        Role role = roleDao.findByName("???");

        // Then
        assertThat(role).isNull();

    }

    @Test
    public void testFindAll() throws Exception {
        // When
        List<Role> roles = roleDao.findAll();

        // Then
        assertThat(roles).containsExactly(
                new Role(1, "admin"),
                new Role(2, "member")
        );

    }
}
