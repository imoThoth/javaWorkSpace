package com.hades.cerebus.dao;

import com.hades.cerebus.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    int insertUser(UUID id, User user);

    default int inserUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();
    Optional<User> selectUserById(UUID id);
    int deleteUserById(UUID id);
    int updateUserByID(UUID id, User user);
}
