package com.example.demospring1.login.repository.database;

import com.example.demospring1.login.model.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDB extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user where username= ?1 AND  password = ?4", nativeQuery = true)
    User findUser(String username ,String password);

    @Query(value = "insert into user (username, password) values (?1, ?4)",nativeQuery = true)
    User insertNewUser(String username , String password);

    @Override
    <S extends User> S save(S s);


}
