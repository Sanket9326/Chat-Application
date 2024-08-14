package com.ChatApplication.Project.Repository;

import com.ChatApplication.Project.Models.UserChats;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatDao extends JpaRepository<UserChats,Integer> {

    @Query(value = "SELECT message from UserChats where sender = :sender and receiver = :receiver and timestamp >= :start and timestamp <= :end",nativeQuery = true)
    List<String> getChats(@Param("sender") String sender,@Param("receiver") String receiver,@Param("start") String startTimestamp,@Param("end") String endTimestamp);

    @Transactional
    @Modifying
    @Query(value = "DELETE from user_chats where sender = :sender and receiver = :receiver and message = :message and timestamp = :timestamp",nativeQuery = true)
    void deleteMessage(@Param("sender") String sender,@Param("receiver") String receiver,@Param("message") String message,@Param("timestamp") String timestamp);
}
