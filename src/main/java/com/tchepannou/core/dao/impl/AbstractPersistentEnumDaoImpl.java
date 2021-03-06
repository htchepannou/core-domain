package com.tchepannou.core.dao.impl;

import com.tchepannou.core.dao.AbstractPersistentEnumDao;
import com.tchepannou.core.domain.PersistentEnum;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractPersistentEnumDaoImpl<T extends PersistentEnum> extends JdbcTemplate implements AbstractPersistentEnumDao<T> {

    public AbstractPersistentEnumDaoImpl(final DataSource dataSource) {
        super(dataSource);
    }

    //-- Abstract methods
    protected abstract String getTableName ();

    protected abstract T createPersistenEnum ();

    //-- AbstractPersistentEnumDao overrides
    @Override
    public T findById(final long id) {
        try {
            return queryForObject(
                    String.format("SELECT * FROM %s WHERE id=?", getTableName()),
                    new Object[]{id},
                    getRowMapper()
            );
        } catch (EmptyResultDataAccessException e) {    // NOSONAR
            return null;
        }
    }

    @Override
    public T findByName(final String name) {
        try {
            return queryForObject(
                    String.format("SELECT * FROM %s WHERE name=?", getTableName()),
                    new Object[]{name.toLowerCase()},
                    getRowMapper()
            );
        } catch (EmptyResultDataAccessException e) {    // NOSONAR
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        return query(String.format("SELECT * FROM %s", getTableName()), getRowMapper());
    }

    //-- Protected
    protected RowMapper<T> getRowMapper () {
        return new RowMapper<T>() {
            @Override
            public T mapRow(final ResultSet rs, final int i) throws SQLException {
                final T purpose = createPersistenEnum();
                purpose.setId(rs.getLong("id"));
                purpose.setName(rs.getString("name"));
                return purpose;
            }
        };
    }
}
