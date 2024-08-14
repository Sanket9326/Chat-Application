package com.ChatApplication.Project.Repository;

import com.ChatApplication.Project.Models.Friend;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendReqDao extends JpaRepository<Friend,Integer> {

    @Modifying
    @Transactional
    @Query(value = "update Friend set status = :curr where sender = :sender and receiver = :acceptor",nativeQuery = true)
    void accept(@Param("acceptor") String acceptor,@Param("sender") String sender,@Param("curr") String accepted);
}
