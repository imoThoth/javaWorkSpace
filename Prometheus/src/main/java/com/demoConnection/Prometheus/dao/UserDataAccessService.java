package com.demoConnection.Prometheus.dao;

import com.demoConnection.Prometheus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Add a user to the database
@Repository("postgresNOT")
public class UserDataAccessService implements UserDao{

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user){
        DB.add(new User(id, user.getName()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers(){//implement contract to get all users
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> mayBeUser = selectUserById(id);
        if(mayBeUser.isEmpty()){
            return 0;
        }
        DB.remove(mayBeUser.get());
        return 1;
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return selectUserById(id)
                .map(p -> {
                    int idToUpdate = DB.indexOf(p);
                    if( idToUpdate >= 0){
                        DB.set(idToUpdate, new User(id, user.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
