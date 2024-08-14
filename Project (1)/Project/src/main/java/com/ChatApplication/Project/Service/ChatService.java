package com.ChatApplication.Project.Service;

import com.ChatApplication.Project.Models.UserChats;
import com.ChatApplication.Project.Repository.ChatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    ChatDao chatDao;

    public ResponseEntity<String> sendMessage(String sender, String reciever, String message, String timestamp) {
        try{
            UserChats uc = new UserChats();
            uc.setSender(sender);
            uc.setReceiver(reciever);
            uc.setMessage(message);
            uc.setTimestamp(timestamp);
            chatDao.save(uc);
            return new ResponseEntity<>("Message sent successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<String>> getChats(String sender, String reciever, String startTimestamp, String endTimestamp) {
        try{
            List<String> messages = chatDao.getChats(sender,reciever,startTimestamp,endTimestamp);
            if (messages.isEmpty()){
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(messages,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteMessage(String sender, String reciever, String message, String timestamp) {
        try{
            chatDao.deleteMessage(sender,reciever,message,timestamp);
            return new ResponseEntity<>("Message deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
