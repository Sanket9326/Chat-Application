package com.ChatApplication.Project.Repository;

import com.ChatApplication.Project.Models.UserFriends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFriendsDao extends JpaRepository<UserFriends, Integer> {

    @Query(value = "select * from UserFriends where username = :sender",nativeQuery = true)
    UserFriends getUser(@Param("sender") String sender);
}
