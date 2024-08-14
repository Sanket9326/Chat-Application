package com.ChatApplication.Project.Service;

import com.ChatApplication.Project.Models.Friend;
import com.ChatApplication.Project.Models.Frnd;
import com.ChatApplication.Project.Models.UserFriends;
import com.ChatApplication.Project.Repository.FriendReqDao;
import com.ChatApplication.Project.Repository.UserFriendsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class FriendReqService {
    @Autowired
    FriendReqDao friendReqDao;

    @Autowired
    UserFriendsDao userFriendsDao;

    public ResponseEntity<String> requestFriend(String sender, String receiver, String pending) {
        try {
            Friend frnd = new Friend();
            frnd.setSender(sender);
            frnd.setReceiver(receiver);
            frnd.setStatus(pending);
            friendReqDao.save(frnd);
            return new ResponseEntity<>("Friend Request sent", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> accpetFriend(String acceptor, String sender, String accepted) {
        try{
            friendReqDao.accept(acceptor,sender,accepted);
            saveFriend(sender,acceptor);
            saveFriend(accepted,sender);
            return new ResponseEntity<>("Friend Accepted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.BAD_REQUEST);
        }
    }

    public void saveFriend(String sender, String receiver) {
        try {
          UserFriends temp = userFriendsDao.getUser(sender);
          if (temp != null) {
              Frnd f = temp.getF();
              f.setName(receiver);
              temp.setF(f);
          }else{
              UserFriends friend = new UserFriends();
              Frnd f = new Frnd();
              f.setName(receiver);
              friend.setF(f);
              friend.setUsername(sender);
              userFriendsDao.save(friend);
          }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
