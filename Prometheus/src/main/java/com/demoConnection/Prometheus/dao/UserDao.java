package com.demoConnection.Prometheus.dao;

import com.demoConnection.Prometheus.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    //insert user with id
    int insertUser(UUID id, User user);

    //insert user with randomly generated id
    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    //create a contract to get all user
    List<User> selectAllUsers();
    Optional<User> selectUserById(UUID id);
    int deleteUserById(UUID id);
    int updateUserById(UUID id, User user);

}
