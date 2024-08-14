package com.ChatApplication.Project.Controller;

import com.ChatApplication.Project.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("send")
    public ResponseEntity<String> sendMessage(@RequestParam String sender, @RequestParam String reciever ,@RequestParam String message,@RequestParam String timestamp){
        return chatService.sendMessage(sender,reciever,message,timestamp);
    }

    @GetMapping("get")
    public ResponseEntity<List<String>> getChats(@RequestParam String sender, @RequestParam String reciever, @RequestParam String startTimestamp, @RequestParam String endTimestamp){
        return chatService.getChats(sender,reciever,startTimestamp,endTimestamp);
    }

    @PutMapping("delete")
    public ResponseEntity<String> deleteMessage(@RequestParam String sender, @RequestParam String reciever, @RequestParam String message,@RequestParam String timestamp){
        return chatService.deleteMessage(sender,reciever,message,timestamp);
    }

}
