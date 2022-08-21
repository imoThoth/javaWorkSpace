package com.demoConnection.Prometheus.dao;

import com.demoConnection.Prometheus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("postgres")
public class PersonDataAccessService implements UserDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, User user) {
        final String sql = "INSERT INTO person(id, name) VALUES(?,?)";
        jdbcTemplate.update(sql, new User(id, user.getName()), new Object[]{Types.VARCHAR, Types.VARCHAR});
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        final String sql = "SELECT id, name from person";
        List<User> people = jdbcTemplate.query(sql, (rs, i) -> {
            UUID id = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            return new User(id, name);
        });
        return people;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteUserById(UUID id) {
        return 0;
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return 0;
    }
}