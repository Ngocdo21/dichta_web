package com.example.demospring1.login.repository.database;

import com.example.demospring1.login.model.enity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIFDB extends JpaRepository<UserInfo, Integer> {
}
