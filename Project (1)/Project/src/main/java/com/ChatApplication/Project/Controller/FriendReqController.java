package com.ChatApplication.Project.Controller;

import com.ChatApplication.Project.Service.FriendReqService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("request")
public class FriendReqController {

    @Autowired
    FriendReqService friendReqService ;

    @PostMapping("req")
    public ResponseEntity<String> requestFriend(@RequestParam String sender, @RequestParam String receiver) {
        return friendReqService.requestFriend(sender,receiver,"pending");
    }

    @PostMapping("accept")
    public ResponseEntity<String> acceptFriend(@RequestParam String acceptor, @RequestParam String sender) {
        return friendReqService.accpetFriend(acceptor,sender,"Accepted");
    }

}
