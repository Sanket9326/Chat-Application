package com.ChatApplication.Project.Repository;

import com.ChatApplication.Project.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value = "Select * from user where username = :username and password = :password",nativeQuery = true)
    List<User> loginUser(@Param("username") String username,@Param("password") String password);

    @Query(value = "select * from user where username = :username ",nativeQuery = true)
    List<User> verifyUser(@Param("username") String username);
}
