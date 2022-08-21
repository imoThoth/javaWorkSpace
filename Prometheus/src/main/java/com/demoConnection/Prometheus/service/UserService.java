package com.demoConnection.Prometheus.service;

import com.demoConnection.Prometheus.dao.UserDao;
import com.demoConnection.Prometheus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("postgres") UserDao userdao){
        this.userDao = userdao;
    }

    //insert new user
    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    public List<User> selectAllUsers(){//create service to get all users
        return userDao.selectAllUsers();
    }

    public Optional<User> selectUserById(UUID id){
        return userDao.selectUserById(id);
    }

    public int deleteUserById(UUID id){
        return userDao.deleteUserById(id);
    }

    public int updateUserById(UUID id, User user){
        return userDao.updateUserById(id, user);
    }
}
