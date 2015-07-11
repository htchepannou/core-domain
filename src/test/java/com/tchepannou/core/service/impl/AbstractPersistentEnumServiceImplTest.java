package com.tchepannou.core.service.impl;

import com.tchepannou.core.Role;
import com.tchepannou.core.RoleService;
import com.tchepannou.core.TestConfig;
import com.tchepannou.core.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class AbstractPersistentEnumServiceImplTest {
    @Autowired
    private RoleService roleService;

    @Test
    public void testFindById() throws Exception {
        // When
        Role role = roleService.findById(1);

        // Then
        assertThat(role).isEqualTo(new Role(1, "admin"));
    }
    @Test(expected = NotFoundException.class)
    public void testFindById_badId() throws Exception {
        roleService.findById(1);
    }

    @Test
    public void testFindByName() throws Exception {
        // When
        Role role = roleService.findByName("admin");

        // Then
        assertThat(role).isEqualTo(new Role(1, "admin"));
    }
    @Test(expected = NotFoundException.class)
    public void testFindById_badName() throws Exception {
        roleService.findByName("???");
    }

    @Test
    public void testFindAll() throws Exception {
        // When
        List<Role> roles = roleService.findAll();

        // Then
        assertThat(roles).containsExactly(
                new Role(1, "admin"),
                new Role(2, "member")
        );

    }
}
